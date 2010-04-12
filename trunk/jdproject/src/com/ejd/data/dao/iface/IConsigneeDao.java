package com.ejd.data.dao.iface;

import java.util.List;

import com.ejd.web.bo.Consignee;

public interface IConsigneeDao {
	public Consignee getConsigneeById(Integer id);
	public List<Consignee> getConsigneeByStakeholderId(Integer stakeholderId);
	public List<Consignee> getAllConsignee();
	public Consignee addConsignee(Consignee consignee);
	public boolean delConsigneeById(Integer id);
	public boolean delConsigneeByStakeholderId(Integer stakeholderId);
	public Consignee updateConsignee(Consignee consignee);
	public Consignee saveConsignee(Consignee consignee);
	public Consignee saveOrUpdateConsignee(Consignee consignee);
}
