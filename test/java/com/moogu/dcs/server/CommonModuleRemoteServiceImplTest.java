package com.moogu.dcs.server;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.moogu.dcs.server.feature.management.RuntimeConfigurationService;
import com.moogu.dcs.test.common.TestHelper;
import static org.mockito.Mockito.*;

/**
 * 
 * Simple Mocked Test for <code>CommonModuleRemoteServiceImpl</code>
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class CommonModuleRemoteServiceImplTest {

	@Mock
	private RuntimeConfigurationService service;

	private CommonModuleRemoteServiceImpl victim;

	@Before
	public void setUp() {
		victim = new CommonModuleRemoteServiceImpl();
		TestHelper.setFieldValue(victim, "configurationService", service);
	}

	@Test
	public void savePropertiesTest() {
		victim.saveProperties(new HashMap<String, String>());
		verify(service).deleteAllProperties();
	}

}
