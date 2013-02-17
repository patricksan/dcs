package com.moogu.dcs.client.feature;

import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.moogu.dcs.client.DcsEntryPoint;
import com.moogu.dcs.client.feature.reports.ReportsTabItem;
import com.moogu.dcs.client.feature.technical.TechnicalModuleTabItem;

public class MainPanel extends LayoutContainer {

	private static MainPanel instance = null;
	
	private TabPanel tp = new TabPanel();
	
	public static MainPanel getInstance() {
		if (MainPanel.instance == null) {
			MainPanel.instance = new MainPanel();
		}
		return MainPanel.instance;
	}

	private MainPanel() {
		super(new FitLayout());

		this.setSize(800, 700);
		this.setBorders(false);
		this.setMonitorWindowResize(true);

		tp.setAutoWidth(true);

		TabItem reportsTabItem = new ReportsTabItem();
		this.add(tp);
		
		tp.add(reportsTabItem);
		
		if (DcsEntryPoint.isUserRole(DcsEntryPoint.ROLE_2)) {
			// if technical user
			TabItem TechnicalModuleTabItem = new TechnicalModuleTabItem();
			tp.add(TechnicalModuleTabItem);
		}

		tp.setLayoutData(new FitLayout());
		tp.setBorders(false);
	}

	@Override
	public void onWindowResize(int width, int height) {
		this.setSize(width - 10, height);
		tp.setSize(width - 10, height);
	}
}