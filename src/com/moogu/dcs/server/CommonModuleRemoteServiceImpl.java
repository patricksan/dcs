package com.moogu.dcs.server;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.moogu.dcs.client.CommonModuleRemoteService;
import com.moogu.dcs.client.common.ClientLog;
import com.moogu.dcs.server.feature.management.ClientLogger;
import com.moogu.dcs.server.feature.management.RuntimeConfigurationService;
import com.moogu.dcs.shared.utils.DcsSharedException;

@Component
@Transactional(readOnly = false, timeout = 15)
public class CommonModuleRemoteServiceImpl implements CommonModuleRemoteService {

	@Autowired
	private RuntimeConfigurationService configurationService;

	public void dummy() throws DcsSharedException {
	}

	public List<String> getProperetyKeys() {
		return Arrays.asList(RuntimeConfigurationService.KEYS);
	}

	public Map<String, String> getProperties() {
		return configurationService.getPropertes();
	}

	public void log(ClientLog.Type log, String message) {
		ClientLogger.log(log, message);
	}

	public void saveProperties(Map<String, String> props) {
		configurationService.deleteAllProperties();
		for (final Map.Entry<String, String> prop : props.entrySet()) {
			final String key = prop.getKey();
			if (!StringUtils.isBlank(key)) {
				configurationService.setProperty(key, prop.getValue());
			}
		}

	}
}
