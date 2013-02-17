package com.moogu.dcs.client.feature.technical.sync;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.moogu.dcs.client.common.widget.misc.Separator;

public class SynchronizationPanel extends FieldSet{

	public SynchronizationPanel() {
		this.setStyleAttribute("margin", "5px");
		this.setHeading("Sync");
		this.setLayout(new RowLayout(Orientation.VERTICAL));
		this.setAutoWidth(true);
		this.add(new Separator(0, 20));
		this.setMonitorWindowResize(true);
	}
	
	@Override
	public void onWindowResize(int width, int height) {
		this.setSize(width - 10, height - 20);
	}
}
