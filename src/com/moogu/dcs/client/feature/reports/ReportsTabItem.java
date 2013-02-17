package com.moogu.dcs.client.feature.reports;

import com.extjs.gxt.ui.client.widget.TabPanel;
import com.google.gwt.user.client.Element;
import com.moogu.dcs.client.common.widget.misc.TabItem;
import com.moogu.dcs.client.feature.reports.affiliates.AffiliatesTabItem;
import com.moogu.dcs.client.feature.reports.machines.MachinesDetailsTabItem;
import com.moogu.dcs.client.feature.reports.machines.MachinesLastStateTabItem;
import com.moogu.dcs.client.feature.reports.machines.MachinesNotWorkingTabItem;
import com.moogu.dcs.client.feature.reports.sites.SiteConfigurationTabItem;

/**
 * Reporting Module
 */
public class ReportsTabItem extends TabItem {

    private final TabPanel tp = new TabPanel();

    private final AffiliatesTabItem affiliatesTabItem = new AffiliatesTabItem();
    
    private final SiteConfigurationTabItem sitesTabItem = new SiteConfigurationTabItem();

    private final MachinesNotWorkingTabItem machinesNotWorkingTabItem = new MachinesNotWorkingTabItem();

    private final MachinesDetailsTabItem machinesDetailsTabItem = new MachinesDetailsTabItem();

    private final MachinesLastStateTabItem machinesLastStateTabItem = new MachinesLastStateTabItem();

    public ReportsTabItem() {
        super("Reports");
        this.setMonitorWindowResize(true);
        this.setSize(800, 700);
    }

    @Override
    protected void onRender(Element parent, int index) {
        super.onRender(parent, index);
        tp.setAutoWidth(true);

        this.add(tp);

        // add reporting modules
        tp.add(affiliatesTabItem);
        tp.add(sitesTabItem);
        tp.add(machinesDetailsTabItem);
        tp.add(machinesLastStateTabItem);
        tp.add(machinesNotWorkingTabItem);
    }
    
    @Override
	public void onWindowResize(int width, int height) {
		this.setSize(width - 10, height - 20);
		tp.setSize(width - 10, height - 20 );
	}
}