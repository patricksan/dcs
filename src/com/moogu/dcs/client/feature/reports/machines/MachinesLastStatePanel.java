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
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Element;
import com.moogu.dcs.client.RemoteServicePool;
import com.moogu.dcs.client.common.DcsAsyncCallback;
import com.moogu.dcs.shared.model.Machine;

public class MachinesLastStatePanel extends FieldSet{

	public MachinesLastStatePanel() 
	{
		this.setStyleAttribute("margin", "5px");
		this.setHeading("Machines Last States");
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
 	    column.setId(MachineLastStateBM.ID);  
	    column.setHeader("Id");  
	    column.setWidth(50);  
	    configs.add(column);  
 	  
	    column = new ColumnConfig();  
	    column.setId(MachineLastStateBM.LAST_STATE);  
	    column.setHeader("State");  
	    column.setWidth(80);  
	    configs.add(column); 
	    
	    column = new ColumnConfig();  
	    column.setId(MachineLastStateBM.SPEED);  
	    column.setHeader("Speed");  
	    column.setWidth(80);  
	    configs.add(column);
	    
	    column = new ColumnConfig();  
 	    column.setId(MachineLastStateBM.STATE_DATE);  
 	    column.setHeader("Last Update");  
 	    column.setWidth(120);  
 	    column.setDateTimeFormat(DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss"));  
 	    configs.add(column); 
 	    
 	    
	    
 	    // creates a ColumnModel
 	    final ColumnModel cm = new ColumnModel(configs); 
 	    
 	    // creates the ListStore
 	    final ListStore<MachineLastStateBM> store = new ListStore<MachineLastStateBM>(); 
 	    
 	    // creates the grid
 	 	final Grid<MachineLastStateBM> grid = new Grid<MachineLastStateBM>(store, cm);
 	 	grid.setStyleAttribute("borderTop", "none");  
 	 	grid.setAutoExpandColumn(MachineLastStateBM.LAST_STATE);  
 	 	grid.setBorders(false);  
 	 	grid.setStripeRows(true);  
 	 	grid.setColumnLines(true);  
 	 	grid.setColumnReordering(true);
 	 	grid.setAutoHeight(true);
 			 	
 		this.add(grid);
 	    
 	    // populates the ListStore with data from the server
 	    RemoteServicePool.getReportingModule().listMachinesLastStates(
			new DcsAsyncCallback<List<Machine>>() 
			{
				@Override
				protected void onCustomSuccess(List<Machine> result) 
				{
					List<MachineLastStateBM> machinesLS = new ArrayList<MachineLastStateBM>();
					for( Machine mTO : result )
					{
						machinesLS.add(new MachineLastStateBM(mTO));
					}
					grid.getStore().add(machinesLS);
				}
			});
    }
}
