package com.moogu.dcs.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.moogu.dcs.shared.model.Affiliate;
import com.moogu.dcs.shared.model.Machine;
import com.moogu.dcs.shared.model.Site;


public interface ReportingModuleRemoteServiceAsync
{
	void dummy(AsyncCallback<Void> callback);
	
	void listAffiliates(AsyncCallback<List<Affiliate>> callback);
	
	void listMachinesNotWorking(AsyncCallback<List<Machine>> callback);
	
	void listMachinesDetails(AsyncCallback<List<Machine>> callback);
	
	void listMachinesLastStates(AsyncCallback<List<Machine>> callback);
	
	void listSiteConfiguration(AsyncCallback<List<Site>> callback);
}
