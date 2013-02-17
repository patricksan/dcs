package com.moogu.dcs.shared.model;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Site implements Serializable, IsSerializable
{
	private static final long serialVersionUID = -5274998614479189403L;

	private int siteId;
	
	private String siteName;
	
	public Site(int id, String name)
	{
		this.siteId = id;
		this.siteName = name;
	}

	public Site()
	{
		
	}
	
	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
}
