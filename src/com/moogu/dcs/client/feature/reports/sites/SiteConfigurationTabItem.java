package com.moogu.dcs.client.feature.reports.sites;

import com.extjs.gxt.ui.client.widget.TabItem;
import com.google.gwt.user.client.Element;

public class SiteConfigurationTabItem extends TabItem {

    private final SiteConfigurationPanel panel = new SiteConfigurationPanel();

    public SiteConfigurationTabItem() {
        super("Site Configuration");
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
