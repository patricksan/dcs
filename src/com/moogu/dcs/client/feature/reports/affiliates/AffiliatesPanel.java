package com.moogu.dcs.client.feature.reports.affiliates;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.google.gwt.user.client.Element;
import com.moogu.dcs.client.RemoteServicePool;
import com.moogu.dcs.client.common.DcsAsyncCallback;
import com.moogu.dcs.shared.model.Affiliate;

public class AffiliatesPanel extends FieldSet
{
	public AffiliatesPanel() 
	{
		this.setStyleAttribute("margin", "5px");
		this.setHeading("Affiliates");
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
 	    column.setId(AffiliateBM.ID);  
 	    column.setHeader("Id");  
 	    column.setWidth(50);  
 	    configs.add(column);  
 	  
 	    column = new ColumnConfig();  
 	    column.setId(AffiliateBM.NAME);  
 	    column.setHeader("Name");  
 	    column.setWidth(150);  
 	    configs.add(column);  
 	  
 	    column = new ColumnConfig();  
 	    column.setId(AffiliateBM.AFFILIATE);  
 	    column.setHeader("Affiliate");  
 	    column.setWidth(150);  
 	    configs.add(column);  
 		
 	    // creates a ColumnModel
 	    ColumnModel cm = new ColumnModel(configs); 
 	    
 	    // creates the ListStore
 	    final ListStore<AffiliateBM> store = new ListStore<AffiliateBM>(); 
 		
 	    // creates the grid
 	 	final Grid<AffiliateBM> grid = new Grid<AffiliateBM>(store, cm);  
 	 	grid.setStyleAttribute("borderTop", "none");  
 	 	grid.setAutoExpandColumn(AffiliateBM.NAME);  
 	 	grid.setBorders(false);  
 	 	grid.setStripeRows(true);  
 	 	grid.setColumnLines(true);  
 	 	grid.setColumnReordering(true);
 	 	grid.setAutoHeight(true);
 			 	
 		this.add(grid);
 	    
 	    // populates the ListStore with data from the server
 	    RemoteServicePool.getReportingModule().listAffiliates(
			new DcsAsyncCallback<List<Affiliate>>() 
			{
				@Override
				protected void onCustomSuccess(List<Affiliate> result) 
				{
					List<AffiliateBM> affiliates = new ArrayList<AffiliateBM>();
					for( Affiliate aTO : result )
					{
						affiliates.add(new AffiliateBM(aTO));
					}
					grid.getStore().add(affiliates);
				}
			});
    }

}
