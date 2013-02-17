package com.moogu.dcs.server;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moogu.dcs.client.ReportingModuleRemoteService;
import com.moogu.dcs.server.feature.reports.MachineRepository;
import com.moogu.dcs.server.feature.reports.SiteRepository;
import com.moogu.dcs.server.model.DbMachineConfiguration;
import com.moogu.dcs.server.model.DbMachineState;
import com.moogu.dcs.server.model.DbSiteConfiguration;
import com.moogu.dcs.shared.model.Affiliate;
import com.moogu.dcs.shared.model.Machine;
import com.moogu.dcs.shared.model.MachineClass;
import com.moogu.dcs.shared.model.MachineState;
import com.moogu.dcs.shared.model.ShiftModel;
import com.moogu.dcs.shared.model.Site;
import com.moogu.dcs.shared.utils.DcsSharedException;

/**
 * The server side implementation of the RPC services that generate reports.
 */
@Service
public class ReportingModuleRemoteServiceImpl implements ReportingModuleRemoteService {

	/** for log */
	private final static Logger logger = Logger
			.getLogger(ReportingModuleRemoteServiceImpl.class.getName());

	@Autowired
	private MachineRepository machineRepo;
	
	@Autowired
	private SiteRepository siteRepo;
	
	public void setMachineRepo(MachineRepository machineRepo) {
		this.machineRepo = machineRepo;
	}

	public void setSiteRepo(SiteRepository siteRepo) {
		this.siteRepo = siteRepo;
	}
	
	public ReportingModuleRemoteServiceImpl()
	{
		logger.debug("Constructing ReportingModuleRemoteServiceImpl");
	}
	
	public void dummy() throws DcsSharedException {
		// TODO Auto-generated method stub
		
	}

	public List<Affiliate> listAffiliates() {
		/**
		 * The list of data to display.
		 * TODO replace with list from the database.
		 */
		List<Affiliate> affiliates = new ArrayList<Affiliate>();
		Affiliate a = new Affiliate();
		a.setId(1);
		a.setName("Name 1");
		a.setAffiliate("Affiliate 1");
		affiliates.add(a);
		
		a = new Affiliate();
		a.setId(2);
		a.setName("Name 2");
		a.setAffiliate("Affiliate 2");
		affiliates.add(a);
		
		a = new Affiliate();
		a.setId(3);
		a.setName("Name 3");
		a.setAffiliate("Affiliate 3");
		affiliates.add(a);
		
		return affiliates;
	}

	@Transactional(readOnly = true)
	public List<Machine> listMachinesNotWorking() 
	{
		List<Machine> machineTOs = new ArrayList<Machine>();
		
		// List machines not working (only machines with states are being listed)
		List<DbMachineConfiguration> dbMachines = machineRepo.listMachinesNotWorking();
		
		for(DbMachineConfiguration dbM : dbMachines)
		{
			Machine m = new Machine();
			m.setMachineId(dbM.getMachineId());
			m.setMachineName(dbM.getMachineName());
			m.setMachineDescription(dbM.getMachineDescription());
			m.setMachineSite(new Site(dbM.getMachineSite().getSiteId(),dbM.getMachineSite().getSiteName()));
			m.setMachineClass(new MachineClass(dbM.getMachineClass().getMachineClassId(), dbM.getMachineClass().getMachineClassName()));
			m.setShiftModel(new ShiftModel(dbM.getShiftModel().getShiftModelId(), dbM.getShiftModel().getShiftModelName()));
			
			// I only want to get the last state here
			MachineState ms = new MachineState();
			DbMachineState dbMs = machineRepo.getLastMachineState(dbM);
			ms.setMachine(m);
			ms.setMachineState(dbMs.getMachineStateString());
			ms.setMachineSpeed(dbMs.getMachineSpeed());
			ms.setStateCreationDate(dbMs.getStateCreationDate());
			m.setLastMachineState(ms);
			
			//Add to the transfer list
			machineTOs.add(m);
		}
		return machineTOs;
	}
	
	@Transactional(readOnly = true)
	public List<Machine> listMachinesDetails() 
	{
		List<Machine> machineTOs = new ArrayList<Machine>();
		List<DbMachineConfiguration> dbMachines = machineRepo.listMachines();
		for(DbMachineConfiguration dbM : dbMachines)
		{
			Machine m = new Machine();
			m.setMachineId(dbM.getMachineId());
			m.setMachineName(dbM.getMachineName());
			m.setMachineDescription(dbM.getMachineDescription());
			m.setMachineSite(new Site(dbM.getMachineSite().getSiteId(),dbM.getMachineSite().getSiteName()));
			m.setMachineClass(new MachineClass(dbM.getMachineClass().getMachineClassId(), dbM.getMachineClass().getMachineClassName()));
			m.setShiftModel(new ShiftModel(dbM.getShiftModel().getShiftModelId(), dbM.getShiftModel().getShiftModelName()));
			
			//Add to the transfer list
			machineTOs.add(m);
		}
		return machineTOs;
	}

	@Transactional(readOnly = true)
	public List<Machine> listMachinesLastStates() 
	{
		List<Machine> machineTOs = new ArrayList<Machine>();
		List<DbMachineState> dbMachinesStates = machineRepo.listLastMachineStates();
		for(DbMachineState dbMs : dbMachinesStates)
		{
			Machine m = new Machine();
			m.setMachineId(dbMs.getMachine().getMachineId());
			
			MachineState ms = new MachineState();
			ms.setMachine(m);
			m.setLastMachineState(ms);
			
			ms.setMachineState(dbMs.getMachineStateString());
			ms.setMachineSpeed(dbMs.getMachineSpeed());
			ms.setStateCreationDate(dbMs.getStateCreationDate());
			
			//Add to the transfer list
			machineTOs.add(m);
		}
		return machineTOs;
	}
	
	@Transactional(readOnly = true)
	public List<Site> listSiteConfiguration() 
	{
		List<Site> siteTOs = new ArrayList<Site>();
		List<DbSiteConfiguration> dbSites = siteRepo.listSiteConfiguration();
		for(DbSiteConfiguration dbS : dbSites)
		{
			Site m = new Site();
			m.setSiteId(dbS.getSiteId());
			m.setSiteName(dbS.getSiteName());
			
			//Add to the transfer list
			siteTOs.add(m);
		}
		return siteTOs;
	}
}