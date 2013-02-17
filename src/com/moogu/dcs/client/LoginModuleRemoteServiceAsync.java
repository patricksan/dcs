package com.moogu.dcs.client;

import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>DcsService</code>.
 */
public interface LoginModuleRemoteServiceAsync {

    void dummy(AsyncCallback<Void> callback);

    void getUserInfo(AsyncCallback<Map<String, String>> callback);

}