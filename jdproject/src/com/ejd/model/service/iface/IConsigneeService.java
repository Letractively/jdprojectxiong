package com.ejd.model.service.iface;

import java.util.List;

import com.ejd.model.exception.ConsigneeException;
import com.ejd.web.bo.Consignee;

public interface IConsigneeService {
	public Consignee getConsigneeById(Integer id) throws ConsigneeException;
	public List<Consignee> getConsigneeByStakeholderId(Integer stakeholderId) throws ConsigneeException;
	public List<Consignee> getAllConsignee() throws ConsigneeException;
	public Consignee addConsignee(Consignee consignee) throws ConsigneeException;
	public boolean delConsigneeById(Integer id) throws ConsigneeException;
	public boolean delConsigneeByStakeholderId(Integer stakeholderId) throws ConsigneeException;
	public Consignee updateConsignee(Consignee consignee) throws ConsigneeException;
	public Consignee saveConsignee(Consignee consignee) throws ConsigneeException;
	public Consignee saveOrUpdateConsignee(Consignee consignee) throws ConsigneeException;

}
