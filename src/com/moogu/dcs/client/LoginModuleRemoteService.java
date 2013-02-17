package com.moogu.dcs.client;

import java.util.Map;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.moogu.dcs.shared.utils.DcsSharedException;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("loginService")
public interface LoginModuleRemoteService extends RemoteService {

    // This method is to declare explicitly DcsSharedException as it will be 
    // in GWT serialization white list
    void dummy() throws DcsSharedException;

    /**
     * Gives profile information about the user
     * 
     * @return
     */
    Map<String, String> getUserInfo();
}