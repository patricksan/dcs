package com.moogu.dcs.server.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SITE_CONFIGURATION")
public class DbSiteConfiguration 
{
	@Id
	@Column(name = "SITE_ID")
	private int siteId;
	
	@Column(name = "SITE_NAME")
	private String siteName;
	
	@OneToMany(mappedBy="machineSite")
	private List<DbMachineConfiguration> machines = new ArrayList<DbMachineConfiguration>();

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

	public List<DbMachineConfiguration> getMachines() {
		return machines;
	}

	public void setMachines(List<DbMachineConfiguration> machines) {
		this.machines = machines;
	}

}
