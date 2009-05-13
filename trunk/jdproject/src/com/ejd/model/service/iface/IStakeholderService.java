package com.ejd.model.service.iface;

import java.util.List;

import com.ejd.model.exception.StakeholderException;
import com.ejd.web.bo.Stakeholder;

public interface IStakeholderService {
	public Stakeholder getStakeholderById(Integer id) throws StakeholderException;
	public Stakeholder getStakeholderByUserId(String userId) throws StakeholderException;
	public List<Stakeholder> getStakeholdersByMnemonicchars(String mnemonicchars) throws StakeholderException;
	public List<Stakeholder> getStakeholdersByShortName(String shortName) throws StakeholderException;
	public List<Stakeholder> getStakeholdersByFullName(String fullName) throws StakeholderException;
	public List<Stakeholder> getStakeholdersByType(String type) throws StakeholderException;
	public Stakeholder saveStakeholder(Stakeholder stakeholder) throws StakeholderException;
	public Stakeholder saveOrUpdateStakeholder(Stakeholder stakeholder) throws StakeholderException;
	public Stakeholder updateStakeholder(Stakeholder stakeholder) throws StakeholderException;
	public boolean delStakeholderById(Integer id) throws StakeholderException;
	public boolean delStakeholderByUserId(String userId) throws StakeholderException;
}
