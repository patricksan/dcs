package com.moogu.dcs.client;

import java.util.HashMap;
import java.util.Map;

import com.extjs.gxt.ui.client.widget.layout.AnchorLayout;
import com.google.gwt.core.client.EntryPoint;
import com.moogu.dcs.client.bootstrap.AsyncJobSequencer;
import com.moogu.dcs.client.bootstrap.InitJobFactory;
import com.moogu.dcs.client.bootstrap.SplachScreenDisplayer;

public class DcsEntryPoint implements EntryPoint {

	public static final String ROLE_1 = "dcs01";
	public static final String ROLE_2 = "dcs02";

	/**
	 * Keep an eye on User status security info
	 */
	private static Map<String, String> USER_INFO = new HashMap<String, String>();

	public static String getUserCode() {
		return DcsEntryPoint.USER_INFO.get("USER_CODE");
	}

	public static String getUserId() {
		return DcsEntryPoint.USER_INFO.get("USER_ID");
	}

	public static Integer getUserIdAsInteger() {
		return new Integer(DcsEntryPoint.USER_INFO.get("USER_ID"));
	}

	/**
	 * @return true if the user have at least one of the provided roles
	 */
	public static boolean isUserRole(String... roles) {

		for (final String pRole : roles) {
			// get the value from the map
			final String strValue = DcsEntryPoint.USER_INFO.get(pRole);

			// if it is null, the user required a role that was not inserted on
			// LOAD
			if (strValue == null) {
				throw new RuntimeException("Role [" + pRole
						+ "] is not defined.");
			}

			final boolean result = Boolean.valueOf(strValue);
			if (result) {
				return true;
			}
		}
		return false;
	}

	public static void setUserInfo(Map<String, String> infos) {
		DcsEntryPoint.USER_INFO = infos;
	}

	/**
	 * When GWT app is actually starting
	 */
	@SuppressWarnings("unused")
	public void onModuleLoad() {
		final com.extjs.gxt.ui.client.widget.Layout junk = new AnchorLayout();
		final AsyncJobSequencer jobSequencer = InitJobFactory
				.createInitJobSequencer();
		SplachScreenDisplayer.display(jobSequencer);
	}
}