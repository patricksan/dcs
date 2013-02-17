package com.moogu.dcs.client;

import com.google.gwt.core.client.GWT;

public class RemoteServicePool {

    private static final LoginModuleRemoteServiceAsync LOGIN_MODULE_REMOTE_SERVICE_ASYNC = GWT.create(LoginModuleRemoteService.class);

    private static final CommonModuleRemoteServiceAsync COMMON_MODULE_REMOTE_SERVICE_ASYNC = GWT.create(CommonModuleRemoteService.class);

    private static final ReportingModuleRemoteServiceAsync REPORTING_MODULE_REMOTE_SERVICE_ASYNC = GWT.create(ReportingModuleRemoteService.class);

    public static CommonModuleRemoteServiceAsync getCommonModule() {
        return RemoteServicePool.COMMON_MODULE_REMOTE_SERVICE_ASYNC;
    }

    public static LoginModuleRemoteServiceAsync getLoginModule() {
        return RemoteServicePool.LOGIN_MODULE_REMOTE_SERVICE_ASYNC;
    }
    
    public static ReportingModuleRemoteServiceAsync getReportingModule() {
        return RemoteServicePool.REPORTING_MODULE_REMOTE_SERVICE_ASYNC;
    }

}