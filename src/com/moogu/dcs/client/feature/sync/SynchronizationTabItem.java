package com.moogu.dcs.client.feature.sync;

import com.extjs.gxt.ui.client.widget.TabPanel;
import com.google.gwt.user.client.Element;
import com.moogu.dcs.client.common.widget.misc.TabItem;
import com.moogu.dcs.client.feature.technical.misc.MiscTabItem;
import com.moogu.dcs.client.feature.technical.properties.PropertiesTabItem;

/**
 * Synchronization module
 */
public class SynchronizationTabItem extends TabItem {

    private final TabPanel tp = new TabPanel();

    private final MiscTabItem cacheTabItem = new MiscTabItem();

    private final PropertiesTabItem propertiesTabItem = new PropertiesTabItem();

    public SynchronizationTabItem() {
        super("Technical Module");
    }

    @Override
    protected void onRender(Element parent, int index) {
        super.onRender(parent, index);

        this.add(tp);

        // add technical module
        tp.add(cacheTabItem);
        tp.add(propertiesTabItem);
    }
}