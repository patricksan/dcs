package com.moogu.dcs.shared.model;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Affiliate implements Serializable, IsSerializable 
{
	private static final long serialVersionUID = -4828419479290029501L;

	private int id;
	
	private String name;
	
	private String affiliate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAffiliate() {
		return affiliate;
	}

	public void setAffiliate(String affiliate) {
		this.affiliate = affiliate;
	}
}
