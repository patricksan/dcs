package com.moogu.dcs.client.feature.reports.machines;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.store.GroupingStore;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridGroupRenderer;
import com.extjs.gxt.ui.client.widget.grid.GroupColumnData;
import com.extjs.gxt.ui.client.widget.grid.GroupingView;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Element;
import com.moogu.dcs.client.RemoteServicePool;
import com.moogu.dcs.client.common.DcsAsyncCallback;
import com.moogu.dcs.shared.model.Machine;

public class MachinesNotWorkingPanel extends FieldSet{

	public MachinesNotWorkingPanel() 
	{
		this.setStyleAttribute("margin", "5px");
		this.setHeading("Machines not Working");
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
 	    column.setId(MachineNotWorkingBM.SITE_NAME);  
 	    column.setHeader("Site");  
 	    column.setWidth(80);
 	    configs.add(column);  
 	  
 	    column = new ColumnConfig();  
 	    column.setId(MachineNotWorkingBM.ID);  
 	    column.setHeader("Machine Id");  
 	    column.setWidth(50);  
 	    configs.add(column);  
 	  
 	    column = new ColumnConfig();  
 	    column.setId(MachineNotWorkingBM.NAME);  
 	    column.setHeader("Machine Name");  
 	    column.setWidth(80);  
 	    configs.add(column); 
 	    
 	    column = new ColumnConfig();  
	    column.setId(MachineNotWorkingBM.DESCRIPTION);  
	    column.setHeader("Machine Description");  
	    column.setWidth(100);  
	    configs.add(column); 
	    
	    column = new ColumnConfig();  
 	    column.setId(MachineNotWorkingBM.CLASS_NAME);  
 	    column.setHeader("Machine Class");  
 	    column.setWidth(80);  
 	    configs.add(column); 
 	    
 	    column = new ColumnConfig();  
	    column.setId(MachineNotWorkingBM.SHIFT_NAME);  
	    column.setHeader("Shift Model");  
	    column.setWidth(80);  
	    configs.add(column); 
	    
	    column = new ColumnConfig();  
 	    column.setId(MachineNotWorkingBM.STATE_DATE);  
 	    column.setHeader("Last State Date");  
 	    column.setWidth(90);  
 	    column.setDateTimeFormat(DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss"));  
 	    configs.add(column); 
 	    
 	    column = new ColumnConfig();  
	    column.setId(MachineNotWorkingBM.LAST_STATE);  
	    column.setHeader("State");  
	    column.setWidth(80);  
	    configs.add(column); 
 		
 	    // creates a ColumnModel
 	    final ColumnModel cm = new ColumnModel(configs); 
 	    
 	    // creates the GroupingStore
 	    final GroupingStore<MachineNotWorkingBM> store = new GroupingStore<MachineNotWorkingBM>(); 
 	    store.groupBy(MachineNotWorkingBM.SITE_NAME);  
 	   
 	    // creates a grouping view
 	    GroupingView view = new GroupingView();  
 	    view.setShowGroupedColumn(false);  
 	    view.setForceFit(true);  
 	    view.setGroupRenderer(new GridGroupRenderer() {  
 	      public String render(GroupColumnData data) {  
 	        String f = cm.getColumnById(data.field).getHeader();  
 	        String l = data.models.size() == 1 ? "Item" : "Items";  
 	        return f + ": " + data.group + " (" + data.models.size() + " " + l + ")";  
 	      }  
 	    }); 
 	    
 	    // creates the grid
 	 	final Grid<MachineNotWorkingBM> grid = new Grid<MachineNotWorkingBM>(store, cm);
 	 	grid.setView(view);
 	 	grid.setStyleAttribute("borderTop", "none");  
 	 	grid.setAutoExpandColumn(MachineNotWorkingBM.DESCRIPTION);  
 	 	grid.setBorders(false);  
 	 	grid.setStripeRows(true);  
 	 	grid.setColumnLines(true);  
 	 	grid.setColumnReordering(true);
 	 	grid.setAutoHeight(true);
 			 	
 		this.add(grid);
 	    
 	    // populates the ListStore with data from the server
 	    RemoteServicePool.getReportingModule().listMachinesNotWorking(
			new DcsAsyncCallback<List<Machine>>() 
			{
				@Override
				protected void onCustomSuccess(List<Machine> result) 
				{
					List<MachineNotWorkingBM> machinesNW = new ArrayList<MachineNotWorkingBM>();
					for( Machine mTO : result )
					{
						machinesNW.add(new MachineNotWorkingBM(mTO));
					}
					grid.getStore().add(machinesNW);
				}
			});
    }
}
