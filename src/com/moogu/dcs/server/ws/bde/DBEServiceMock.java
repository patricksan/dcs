package com.moogu.dcs.server.ws.bde;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.moogu.dcs.server.model.DbMachineClass;
import com.moogu.dcs.server.model.DbMachineConfiguration;
import com.moogu.dcs.server.model.DbMachineState;
import com.moogu.dcs.server.model.DbShiftConfiguration;
import com.moogu.dcs.server.model.DbShiftModel;
import com.moogu.dcs.server.model.DbShiftResult;
import com.moogu.dcs.server.model.DbSiteConfiguration;

/**
 * Mock for <code>DBEService</code>. Left intentionally under src main folder so
 * it can be locally deployed.
 * 
 * @author rafaeldantas
 */
public class DBEServiceMock implements DBEService {

	public static final int MOCK_QUANTITY = 10;

	private static final List<DbSiteConfiguration> mockedSiteConfigurations;

	private static final List<DbMachineConfiguration> mockedMachineConfigurations;

	private static final List<DbMachineClass> mockedMachineClasses;

	// Ugly piece of code simply to mock the call to WS
	static {
		mockedSiteConfigurations = new ArrayList<DbSiteConfiguration>();
		mockedMachineConfigurations = new ArrayList<DbMachineConfiguration>();
		mockedMachineClasses = new ArrayList<DbMachineClass>();
		for (int i = 1; i < MOCK_QUANTITY + 1; i++) {
			DbSiteConfiguration siteConfiguration = new DbSiteConfiguration();
			siteConfiguration.setSiteId(i);
			siteConfiguration.setSiteName(i + "_name");

			DbMachineClass machineClass = new DbMachineClass();
			machineClass.setMachineClassId(i);
			machineClass.setMachineClassName(i + "_class_name");

			DbMachineConfiguration machineConfiguration = new DbMachineConfiguration();
			machineConfiguration.setMachineClass(machineClass);
			machineConfiguration.setMachineDescription(i + "_description");
			machineConfiguration.setMachineId(i);
			machineConfiguration.setMachineName(i + "_machine_name");
			machineConfiguration.setMachineSite(siteConfiguration);
			machineConfiguration.setShiftModel(new DbShiftModel(i, i + "_model"));

			DbMachineState machineState = new DbMachineState();
			machineState.setMachineSpeed(i * 5);
			machineState.setMachineState(i);
			machineState.setMachineStateId(i);
			machineState.setStateCreationDate(new Date());
			machineState.setMachine(machineConfiguration);

			mockedMachineClasses.add(machineClass);
			mockedMachineConfigurations.add(machineConfiguration);
			mockedSiteConfigurations.add(siteConfiguration);

		}

	}

	@Override
	public List<DbSiteConfiguration> getSiteConfiguration() {
		return mockedSiteConfigurations;
	}

	@Override
	public List<DbMachineConfiguration> getMachineConfiguration() {
		return mockedMachineConfigurations;
	}

	@Override
	public List<DbShiftConfiguration> getShiftConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DbMachineState> getMachineStates(int siteId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DbShiftResult> getShiftResults(int siteId, int shiftId, Date requestDate) {
		// TODO Auto-generated method stub
		return null;
	}

}
