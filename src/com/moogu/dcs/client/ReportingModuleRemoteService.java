package com.moogu.dcs.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.moogu.dcs.shared.model.Affiliate;
import com.moogu.dcs.shared.model.Machine;
import com.moogu.dcs.shared.model.Site;
import com.moogu.dcs.shared.utils.DcsSharedException;

@RemoteServiceRelativePath("reportingService")
public interface ReportingModuleRemoteService extends RemoteService
{
	// This method is to declare explicitly DcsSharedException as it will be 
    // in GWT serialization white list
    void dummy() throws DcsSharedException;
    
    List<Affiliate> listAffiliates();
    
    List<Machine> listMachinesNotWorking();
    
    List<Machine> listMachinesDetails();
    
    List<Machine> listMachinesLastStates();
    
    List<Site> listSiteConfiguration();
}
