package com.moogu.dcs.client.feature.reports.sites;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Element;
import com.moogu.dcs.client.RemoteServicePool;
import com.moogu.dcs.client.common.DcsAsyncCallback;
import com.moogu.dcs.shared.model.Machine;
import com.moogu.dcs.shared.model.Site;

public class SiteConfigurationPanel extends FieldSet{

	public SiteConfigurationPanel() 
	{
		this.setStyleAttribute("margin", "5px");
		this.setHeading("Site Configuration");
		this.setLayout(new RowLayout(Orientation.VERTICAL));
		this.setAutoWidth(true);
		this.setMonitorWindowResize(true);
		
	}

	@Override
	public void onWindowResize(int width, int height) {
		this.setSize(width - 20, height - 20);
	}
	
	@Override
    protected void onRender(Element parent, int index) 
	{
        super.onRender(parent, index);
        
        // Creates the configuration for the grid columns
     	List<ColumnConfig> configs = new ArrayList<ColumnConfig>();  
     		  
 	    ColumnConfig column = new ColumnConfig();  
 	    column.setId(SiteBM.ID);  
	    column.setHeader("Id");  
	    column.setWidth(50);  
	    configs.add(column);  
 	  
	    column = new ColumnConfig();  
	    column.setId(SiteBM.NAME);  
	    column.setHeader("Name");  
	    column.setWidth(80);  
	    configs.add(column);
	    
 	    // creates a ColumnModel
 	    final ColumnModel cm = new ColumnModel(configs); 
 	    
 	    // creates the ListStore
 	    final ListStore<SiteBM> store = new ListStore<SiteBM>(); 
 	    
 	    // creates the grid
 	 	final Grid<SiteBM> grid = new Grid<SiteBM>(store, cm);
 	 	grid.setStyleAttribute("borderTop", "none");  
 	 	grid.setAutoExpandColumn(SiteBM.NAME);  
 	 	grid.setBorders(false);  
 	 	grid.setStripeRows(true);  
 	 	grid.setColumnLines(true);  
 	 	grid.setColumnReordering(true);
 	 	grid.setAutoHeight(true);
 			 	
 		this.add(grid);
 	    
 	    // populates the ListStore with data from the server
 	    RemoteServicePool.getReportingModule().listSiteConfiguration(
			new DcsAsyncCallback<List<Site>>() 
			{
				@Override
				protected void onCustomSuccess(List<Site> result) 
				{
					List<SiteBM> sites = new ArrayList<SiteBM>();
					for( Site sTO : result )
					{
						sites.add(new SiteBM(sTO));
					}
					grid.getStore().add(sites);
				}
			});
    }
}
