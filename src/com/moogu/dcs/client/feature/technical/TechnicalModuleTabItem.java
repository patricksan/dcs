package com.moogu.dcs.client.feature.technical;

import com.extjs.gxt.ui.client.widget.TabPanel;
import com.google.gwt.user.client.Element;
import com.moogu.dcs.client.common.widget.misc.TabItem;
import com.moogu.dcs.client.feature.technical.misc.MiscTabItem;
import com.moogu.dcs.client.feature.technical.properties.PropertiesTabItem;
import com.moogu.dcs.client.feature.technical.sync.SyncTabItem;

/**
 * Technical Module
 */
public class TechnicalModuleTabItem extends TabItem {

    private final TabPanel tp = new TabPanel();

    private final MiscTabItem cacheTabItem = new MiscTabItem();

    private final PropertiesTabItem propertiesTabItem = new PropertiesTabItem();

    private final SyncTabItem syncTabItem = new SyncTabItem();
    
    public TechnicalModuleTabItem() {
        super("Technical Module");
        this.setMonitorWindowResize(true);
        this.setSize(800, 700);
    }

    @Override
    protected void onRender(Element parent, int index) {
        super.onRender(parent, index);
        
        tp.setAutoWidth(true);

        this.add(tp);

        // add technical module
        tp.add(cacheTabItem);
        tp.add(propertiesTabItem);
        tp.add(syncTabItem);
    }
    
    @Override
	public void onWindowResize(int width, int height) {
		this.setSize(width - 10, height - 20);
		tp.setSize(width - 10, height - 20);
	}
}