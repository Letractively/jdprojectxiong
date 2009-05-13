package com.ejd.data.dao.iface;

import java.util.List;

import com.ejd.web.bo.Stakeholder;

public interface IStakeholderDao {

	public Stakeholder getStakeholderById(Integer id);
	public Stakeholder getStakeholderByUserId(String userId);
	public List<Stakeholder> getStakeholdersByMnemonicchars(String mnemonicchars);
	public List<Stakeholder> getStakeholdersByShortName(String shortName);
	public List<Stakeholder> getStakeholdersByFullName(String fullName);
	public List<Stakeholder> getStakeholdersByType(String type);
	public Stakeholder saveStakeholder(Stakeholder stakeholder);
	public Stakeholder saveOrUpdateStakeholder(Stakeholder stakeholder);
	public Stakeholder updateStakeholder(Stakeholder stakeholder);
	public boolean delStakeholderById(Integer id);
	public boolean delStakeholderByUserId(String userId);
}
