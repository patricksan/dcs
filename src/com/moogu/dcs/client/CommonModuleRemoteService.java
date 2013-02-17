package com.moogu.dcs.client;

import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.moogu.dcs.client.common.ClientLog;
import com.moogu.dcs.shared.utils.DcsSharedException;

/**
 * Remote service to deal with currencies, currency groups, users,...
 */
@RemoteServiceRelativePath("commonService")
public interface CommonModuleRemoteService extends RemoteService {

	// This method is to declare explicitly DcsSharedException as it will be
	// in GWT serialization white list
	void dummy() throws DcsSharedException;

	List<String> getProperetyKeys();

	Map<String, String> getProperties();

	/**
	 * Log information in the Log4J Server
	 * 
	 * @param log
	 *            the type of Log. See ClientLog.Type
	 * @param message
	 *            the message to log
	 */
	void log(ClientLog.Type log, String message);

	void saveProperties(Map<String, String> props);
}
