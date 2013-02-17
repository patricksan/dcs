package com.moogu.dcs.server;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.moogu.dcs.client.DcsEntryPoint;
import com.moogu.dcs.client.LoginModuleRemoteService;
import com.moogu.dcs.shared.utils.DcsSharedException;

/**
 * The server side implementation of the RPC service.<br>
 * This class also starts Spring Framework when loaded for the first time.
 */
@SuppressWarnings("serial")
public class LoginModuleRemoteServiceImpl extends AbstractGwtServlet implements
		LoginModuleRemoteService {

	/** for log */
	private final static Logger logger = Logger
			.getLogger(LoginModuleRemoteServiceImpl.class.getName());

	public void dummy() throws DcsSharedException {
	}

	@Override
	protected Object getTargetObject() {
		return this;
	}

	/**
	 * 
	 * @see com.moogu.dcs.client.LoginModuleRemoteService#getUserInfo()
	 */
	public Map<String, String> getUserInfo() {

		final Map<String, String> result = new HashMap<String, String>();

		/** user principal name */
		String strUserConnected = getUser();

		if (strUserConnected == null) {
			strUserConnected = "DEV";
		}

		// user name
		result.put("USER_CODE", strUserConnected);
		result.put("USER_ID", "1");

		/** the roles */
		result.put(
				DcsEntryPoint.ROLE_1,
				String.valueOf(getThreadLocalRequest().isUserInRole(
						DcsEntryPoint.ROLE_1)));
		result.put(
				DcsEntryPoint.ROLE_2,
				String.valueOf(getThreadLocalRequest().isUserInRole(
						DcsEntryPoint.ROLE_2)));

		/** if DEV, set all permissions */
		if (strUserConnected.equals("DEV")) {
			result.put(DcsEntryPoint.ROLE_1, String.valueOf(true));
			result.put(DcsEntryPoint.ROLE_2, String.valueOf(true));
		}

		/** log information with debug */
		if (LoginModuleRemoteServiceImpl.logger.isDebugEnabled()) {
			LoginModuleRemoteServiceImpl.logger.debug("User id = "
					+ strUserConnected);
			LoginModuleRemoteServiceImpl.logger.debug("is User "
					+ DcsEntryPoint.ROLE_1 + " = "
					+ result.get(DcsEntryPoint.ROLE_1));
			LoginModuleRemoteServiceImpl.logger.debug("is User "
					+ DcsEntryPoint.ROLE_2 + " = "
					+ result.get(DcsEntryPoint.ROLE_2));
		}

		return result;
	}
}