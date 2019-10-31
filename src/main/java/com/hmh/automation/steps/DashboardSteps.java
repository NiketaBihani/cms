package com.hmh.automation.steps;

import net.thucydides.core.pages.Pages;

import com.hmh.automation.pages.HMHDashboardPage;
import com.ixxus.ipm.automation.steps.AbstractSteps;

public class DashboardSteps extends AbstractSteps<HMHDashboardPage>{
	private static final long serialVersionUID = 1L;
	public DashboardSteps(Pages pages) {
		super(pages, HMHDashboardPage.class);
	}

}
