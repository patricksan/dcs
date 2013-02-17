package com.moogu.dcs.server.ws.bde;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.moogu.dcs.server.model.DbMachineConfiguration;

public class DBEServiceMockTest {

	private DBEService victmin;

	@Before
	public void setUp() {
		victmin = new DBEServiceMock();
	}

	@Test
	public void getMachineConfigurationTest() {
		List<DbMachineConfiguration> configurations = victmin.getMachineConfiguration();
		Assert.assertNotNull(configurations);
		Assert.assertEquals(DBEServiceMock.MOCK_QUANTITY, configurations.size());

		int i = 1;
		for (DbMachineConfiguration dbMachineConfiguration : configurations) {
			Assert.assertEquals(i + "_description", dbMachineConfiguration.getMachineDescription());
			Assert.assertEquals(i, dbMachineConfiguration.getMachineId());
			Assert.assertEquals(i + "_machine_name", dbMachineConfiguration.getMachineName());
			i++;
		}

	}
}
