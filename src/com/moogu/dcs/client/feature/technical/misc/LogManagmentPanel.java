package com.moogu.dcs.client.feature.technical.misc;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.Html;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;

public class LogManagmentPanel extends FieldSet{

    public LogManagmentPanel() 
    {
        this.setStyleAttribute("margin", "5px");
        this.setHeading("Log Management");
        this.setLayout(new RowLayout(Orientation.HORIZONTAL));

        final Html html = new Html("<a href='monitor/log4j' target='_blank'>Click here to configure logs</a>");
        this.add(html);
        this.setHeight(120);
        this.setAutoWidth(true);
        this.setMonitorWindowResize(true);
    }

    @Override
	public void onWindowResize(int width, int height) {
		this.setSize(width - 10, height - 20);
	}

}
