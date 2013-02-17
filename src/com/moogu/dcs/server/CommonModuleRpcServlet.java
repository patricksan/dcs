package com.moogu.dcs.server;

import com.moogu.dcs.client.CommonModuleRemoteService;

/**
 * RPC Servlet for Position Module. All method calls are redirected on the PositionModuleRemoteServiceImpl spring bean.
 */
public class CommonModuleRpcServlet extends AbstractGwtServlet {

    private static final long serialVersionUID = 57345442241138L;

    public CommonModuleRpcServlet() {
        super(false); // Transactions are managed by the spring bean
    }

    @Override
    protected Object getTargetObject() {
        return this.getApplicationContext().getBean(CommonModuleRemoteService.class);
    }

}
