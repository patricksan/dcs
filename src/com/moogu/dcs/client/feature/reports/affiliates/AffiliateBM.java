package com.moogu.dcs.client.feature.reports.affiliates;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.moogu.dcs.shared.model.Affiliate;

/**
 * Temporary representation of Affiliate
 * @author estelawd
 *
 */
public class AffiliateBM extends BaseModel
{
	private static final long serialVersionUID = 6538505221791131362L;
	
	public transient static final String ID = "id";
	public transient static final String NAME = "name";
	public transient static final String AFFILIATE = "affiliate";

	public AffiliateBM()
	{}
	
	/**
	 * Constructs an AffiliateBM from an Affiliate Transfer Object
	 * @param affiliateTO
	 */
	public AffiliateBM(Affiliate affiliateTO)
	{
		this.setId(affiliateTO.getId());
		this.setName(affiliateTO.getName());
		this.setAffiliate(affiliateTO.getAffiliate());
	}

	public int getId() {
		return (Integer) get(AffiliateBM.ID);
	}

	public void setId(int id) {
		set(AffiliateBM.ID, id);
	}

	public String getName() {
		return (String) get(AffiliateBM.NAME);
	}

	public void setName(String name) {
		set(AffiliateBM.NAME, name);
	}

	public String getAffiliate() {
		return (String) get(AffiliateBM.AFFILIATE);
	}

	public void setAffiliate(String affiliate) {
		set(AffiliateBM.AFFILIATE, affiliate);
	}
}
