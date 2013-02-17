package com.moogu.dcs.client.feature.reports.sites;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.moogu.dcs.shared.model.Site;

public class SiteBM extends BaseModel
{
	private static final long serialVersionUID = 2360290936573277373L;

	public transient static final String ID = "siteId";
	public transient static final String NAME = "siteName";
	
	public SiteBM(Site sTO)
	{
		set(SiteBM.ID, sTO.getSiteId());
		set(SiteBM.NAME, sTO.getSiteName());
	}
	
	public int getSiteId() {
		return get(SiteBM.ID);
	}

	public void setSiteId(int id) {
		set(SiteBM.ID, id);
	}
	
	public String getSiteName() {
		return get(SiteBM.NAME);
	}

	public void setSiteName(String name) {
		set(SiteBM.NAME, name);
	}
}
