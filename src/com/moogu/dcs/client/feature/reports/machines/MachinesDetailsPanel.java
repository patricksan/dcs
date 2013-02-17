package com.moogu.dcs.client.feature.reports.machines;

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
import com.moogu.dcs.shared.model.Machine;

public class MachinesDetailsPanel extends FieldSet{

	public MachinesDetailsPanel() 
	{
		this.setStyleAttribute("margin", "5px");
		this.setHeading("Machines Details");
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
 	    column.setId(MachineDetailsBM.ID);  
	    column.setHeader("Id");  
	    column.setWidth(50);  
	    configs.add(column);  
 	  
	    column = new ColumnConfig();  
 	    column.setId(MachineDetailsBM.NAME);  
 	    column.setHeader("Name");  
 	    column.setWidth(100);  
 	    configs.add(column); 
 	    
 	    column = new ColumnConfig();  
	    column.setId(MachineDetailsBM.DESCRIPTION);  
	    column.setHeader("Description");  
	    column.setWidth(100);  
	    configs.add(column); 
	    
 	    column = new ColumnConfig();  
 	    column.setId(MachineDetailsBM.SITE_ID);  
	    column.setHeader("Site Id");  
	    column.setWidth(50);
	    configs.add(column);  
	    
	    column = new ColumnConfig();  
 	    column.setId(MachineDetailsBM.SITE_NAME);  
	    column.setHeader("Site Name");  
	    column.setWidth(120);
	    configs.add(column);  
	    
	    column = new ColumnConfig();  
	    column.setId(MachineDetailsBM.SHIFT_MODEL_ID);  
	    column.setHeader("Shift Model Id");  
	    column.setWidth(80);  
	    configs.add(column); 
	    
	    column = new ColumnConfig();  
	    column.setId(MachineDetailsBM.CLASS_ID);  
	    column.setHeader("Class Id");  
	    column.setWidth(50);  
	    configs.add(column); 
	    
	    column = new ColumnConfig();  
 	    column.setId(MachineDetailsBM.CLASS_NAME);  
 	    column.setHeader("Class Name");  
 	    column.setWidth(100);  
 	    configs.add(column); 

 	    // creates a ColumnModel
 	    final ColumnModel cm = new ColumnModel(configs); 
 	    
 	    // creates the ListStore
 	    final ListStore<MachineDetailsBM> store = new ListStore<MachineDetailsBM>(); 
 	    
 	    // creates the grid
 	 	final Grid<MachineDetailsBM> grid = new Grid<MachineDetailsBM>(store, cm);
 	 	grid.setStyleAttribute("borderTop", "none");  
 	 	grid.setAutoExpandColumn(MachineDetailsBM.DESCRIPTION);  
 	 	grid.setBorders(false);  
 	 	grid.setStripeRows(true);  
 	 	grid.setColumnLines(true);  
 	 	grid.setColumnReordering(true);
 	 	grid.setAutoHeight(true);
 			 	
 		this.add(grid);
 	    
 	    // populates the ListStore with data from the server
 	    RemoteServicePool.getReportingModule().listMachinesDetails(
			new DcsAsyncCallback<List<Machine>>() 
			{
				@Override
				protected void onCustomSuccess(List<Machine> result) 
				{
					List<MachineDetailsBM> machinesD = new ArrayList<MachineDetailsBM>();
					for( Machine mTO : result )
					{
						machinesD.add(new MachineDetailsBM(mTO));
					}
					grid.getStore().add(machinesD);
				}
			});
    }
}
