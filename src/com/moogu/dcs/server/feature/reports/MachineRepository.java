package com.moogu.dcs.server.feature.reports;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.moogu.dcs.server.model.DbMachineConfiguration;
import com.moogu.dcs.server.model.DbMachineState;
import com.moogu.dcs.server.model.DbShiftConfiguration;
import com.moogu.dcs.server.model.DbShiftResult;
import com.moogu.dcs.server.model.DbSiteConfiguration;

@Component
public class MachineRepository 
{
	/** for log */
	private final static Logger logger = Logger
			.getLogger(MachineRepository.class.getName());
	
	@Autowired
    private SimpleJdbcTemplate jdbcTemplate;

    @Autowired
    private HibernateTemplate hibernateTemplate;
    
    public void setJdbcTemplate(SimpleJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public MachineRepository()
	{
		logger.debug("Constructing bean MachineRepository");
	}
	
	@SuppressWarnings("unchecked")
	public List<DbMachineConfiguration> listMachinesNotWorking()
    {
    	return (List<DbMachineConfiguration>) hibernateTemplate.find("" +
    			"select A.machine from DbMachineState A where A.machineStateId in " +
    			"(select max(B.machineStateId) from DbMachineState B group by B.machine) " +
    			"AND A.machineState in (1,2,5)");
    }
	
	@SuppressWarnings("unchecked")
	public List<DbMachineConfiguration> listMachines()
    {
    	return (List<DbMachineConfiguration>) hibernateTemplate.find("from DbMachineConfiguration");
    }
    
    public DbMachineState getLastMachineState( DbMachineConfiguration machine )
    {
    	return (DbMachineState) hibernateTemplate.find("from DbMachineState A where A.machineStateId = " +
    			"(select max(B.machineStateId) from DbMachineState B " +
    			"where B.machine = ?)", machine).get(0);
    }
	
	public List<DbSiteConfiguration> getSiteConfiguration() {
		return hibernateTemplate.loadAll(DbSiteConfiguration.class);
    }


	public List<DbMachineConfiguration> getMachineConfiguration() {
		return hibernateTemplate.loadAll(DbMachineConfiguration.class);
	}
    
	public List<DbShiftConfiguration> getShiftConfiguration() {
		return hibernateTemplate.loadAll(DbShiftConfiguration.class);
	}

	public List<DbMachineState> getMachineActualStates(int siteId) {
		List<DbMachineState> result = new ArrayList<DbMachineState>();
		
		// First get all machines for the site
		List<DbMachineConfiguration> machinesForSite = this.hibernateTemplate.find("from DbMachineConfiguration mc where mc.machineSite.siteId = " + siteId);
		
		// After, get the latest status for each machine
		for (DbMachineConfiguration machine: machinesForSite) {
			DbMachineState dbMachineState = this.getLastMachineState(machine);
			result.add(dbMachineState);
		}
		
		return result;
	}
	
	public List<DbShiftResult> getShiftResults(int siteId, int shiftId, Date date) {
		String baseHql = "from DbShiftResult sr where sr.shiftResultDate > ? AND sr.shiftResultDate < ? AND sr.machine.machineSite.siteId = ? AND sr.shift.shiftId = ?";
		
		Calendar to = new GregorianCalendar();
		to.setTime(date);
		to.add(Calendar.DATE, 1);

		List<DbShiftResult> result = this.hibernateTemplate.find(baseHql, date, to.getTime(), siteId, shiftId);
		
		return result;
	}
	

    @SuppressWarnings("unchecked")
	public List<DbMachineState> listLastMachineStates()
    {
    	return hibernateTemplate.find("" +
    		"from DbMachineState A where A.machineStateId in " +
    		"(select max(B.machineStateId) from DbMachineState B group by B.machine) ");
    }

	public List<DbShiftResult> getLastestShiftResults(int siteId, int shiftId) {
		List<DbShiftResult> result = new ArrayList<DbShiftResult>();
		
		// First get all machines for the site
		List<DbMachineConfiguration> machinesForSite = this.hibernateTemplate.find("from DbMachineConfiguration mc where mc.machineSite.siteId = " + siteId);
		
		// After, get the latest ShiftResult for each machine AND Shift
		for (DbMachineConfiguration machine: machinesForSite) {
			String baseHql = "from DbShiftResult sr where sr.machine.machineId = ? AND sr.shift.shiftId = ? and sr.shiftResultDate = (select max(other.shiftResultDate) from DbShiftResult other where other.machine.machineId = ? AND other.shift.shiftId = ?))";

			List<DbShiftResult> forThisMachine = this.hibernateTemplate.find(baseHql, shiftId, machine.getMachineId(), shiftId, machine.getMachineId());
			if (forThisMachine.size() > 0) {
				result.add(forThisMachine.get(0));
			}
		}

		
		return result;
	}

}
