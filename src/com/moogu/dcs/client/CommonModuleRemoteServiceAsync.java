package com.moogu.dcs.client;

import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.moogu.dcs.client.common.ClientLog;

public interface CommonModuleRemoteServiceAsync {

	void dummy(AsyncCallback<Void> callback);

	void getProperetyKeys(AsyncCallback<List<String>> callback);

	void getProperties(AsyncCallback<Map<String, String>> callback);

	void log(ClientLog.Type log, String message, AsyncCallback<Void> callback);

	void saveProperties(Map<String, String> props, AsyncCallback<Void> callback);
}
