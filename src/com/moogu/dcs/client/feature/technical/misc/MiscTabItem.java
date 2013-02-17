package com.moogu.dcs.client.feature.technical.misc;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.moogu.dcs.client.common.widget.misc.TabItem;

public class MiscTabItem extends TabItem {

    private final LogManagmentPanel logManagmentPanel = new LogManagmentPanel();

    public MiscTabItem() {
        super("Misc");
        setLayout(new RowLayout(Orientation.VERTICAL));
        this.add(logManagmentPanel);
        setAutoWidth(true);
        setMonitorWindowResize(true);
        this.setSize(800, 700);
    }

    @Override
    public void onSelection() {
        super.onShow();
    }
    
    @Override
	public void onWindowResize(int width, int height) {
		this.setSize(width - 10, height - 20);
	}
}
