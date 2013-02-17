package com.moogu.dcs.server;

import com.moogu.dcs.client.ReportingModuleRemoteService;

/**
 * RPC Servlet for Reporting Module. All method calls are redirected on the ReportingModuleRemoteServiceImpl spring bean.
 */
public class ReportingModuleRpcServlet extends AbstractGwtServlet {

    private static final long serialVersionUID = 5262496636321033739L;

	public ReportingModuleRpcServlet() {
        super(false); // Transactions are managed by the spring bean
    }

    @Override
    protected Object getTargetObject() {
        return this.getApplicationContext().getBean(ReportingModuleRemoteService.class);
    }

}
