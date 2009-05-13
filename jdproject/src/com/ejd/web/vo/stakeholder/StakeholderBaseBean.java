package com.ejd.web.vo.stakeholder;

import com.ejd.model.service.iface.IStakeholderService;

public class StakeholderBaseBean {

	public IStakeholderService stakeholderService;
    public boolean closeModalPanelAfterSaved = Boolean.FALSE;
	public IStakeholderService getStakeholderService() {
		return stakeholderService;
	}

	public void setStakeholderService(IStakeholderService stakeholderService) {
		this.stakeholderService = stakeholderService;
	}

	public boolean isCloseModalPanelAfterSaved() {
		return closeModalPanelAfterSaved;
	}

	public void setCloseModalPanelAfterSaved(boolean closeModalPanelAfterSaved) {
		this.closeModalPanelAfterSaved = closeModalPanelAfterSaved;
	}
	
}
