package com.moogu.dcs.server.ws.bde;

import java.util.Date;
import java.util.List;

import com.moogu.dcs.server.model.DbMachineConfiguration;
import com.moogu.dcs.server.model.DbMachineState;
import com.moogu.dcs.server.model.DbShiftConfiguration;
import com.moogu.dcs.server.model.DbShiftResult;
import com.moogu.dcs.server.model.DbSiteConfiguration;

/**
 * 
 * Interface that interacts with the BDE System, consuming SOAP Messages.
 * 
 * @author rafaeldantas
 */
public interface DBEService {

	/**
	 * Delivers an array of type SiteConfiguration with information about all
	 * configured sites of the company.
	 * 
	 * @return List<DbSiteConfiguration>
	 */
	public List<DbSiteConfiguration> getSiteConfiguration();

	/**
	 * Result is an array of type MachineConfiguration with information of all
	 * machines in the company.
	 * 
	 * @return List<DbMachineConfiguration>
	 */
	public List<DbMachineConfiguration> getMachineConfiguration();

	/**
	 * Result is an array of type ShiftConfiguration with information about all
	 * used shifts, grouped by shift models.
	 * 
	 * @return List<DbShiftConfiguration>
	 */
	public List<DbShiftConfiguration> getShiftConfiguration();

	/**
	 * Result is an array of type MachineState for all machines that are located
	 * in one specific site. Each entry holds several live data from a machine.
	 * 
	 * @param siteId
	 * @return List<DbMachineState>
	 */
	public List<DbMachineState> getMachineStates(int siteId);

	/**
	 * Delivers an array of type ShiftResult with the shift result of all
	 * machines in the requested site for the requested shift for the date Date.
	 * 
	 * 
	 * @param siteId
	 * @param shiftId
	 * @param requestDate
	 * @return List<DbShiftResult>
	 */
	public List<DbShiftResult> getShiftResults(int siteId, int shiftId, Date requestDate);

}
