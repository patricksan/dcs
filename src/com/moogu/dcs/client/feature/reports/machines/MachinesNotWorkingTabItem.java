package com.moogu.dcs.client.feature.reports.machines;

import com.extjs.gxt.ui.client.widget.TabItem;
import com.google.gwt.user.client.Element;

public class MachinesNotWorkingTabItem extends TabItem {

    private final MachinesNotWorkingPanel panel = new MachinesNotWorkingPanel();

    public MachinesNotWorkingTabItem() {
        super("Machines Not Working");
        this.setMonitorWindowResize(true);
        this.setSize(800, 700);
    }

    @Override
    protected void onRender(Element parent, int index) {
        super.onRender(parent, index);
        this.add(this.panel);
        this.setAutoWidth(true);
    }
    
    @Override
	public void onWindowResize(int width, int height) {
		this.setSize(width - 10, height - 20);
	}
}
