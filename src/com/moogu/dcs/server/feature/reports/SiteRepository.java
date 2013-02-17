package com.moogu.dcs.server.feature.reports;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.moogu.dcs.server.model.DbSiteConfiguration;

@Component
public class SiteRepository 
{
	private final static Logger logger = Logger.getLogger(SiteRepository.class.getName());
	
    @Autowired
    private HibernateTemplate hibernateTemplate;
    
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public List<DbSiteConfiguration> listSiteConfiguration()
    {
		return hibernateTemplate.loadAll(DbSiteConfiguration.class);
    }
}
