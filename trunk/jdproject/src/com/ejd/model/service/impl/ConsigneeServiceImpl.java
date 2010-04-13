package com.ejd.model.service.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateObjectRetrievalFailureException;

import com.ejd.data.dao.iface.IConsigneeDao;
import com.ejd.model.exception.ConsigneeException;
import com.ejd.model.service.iface.IConsigneeService;
import com.ejd.web.bo.Consignee;

public class ConsigneeServiceImpl implements IConsigneeService {
	
	private IConsigneeDao consigneeDao;

	public IConsigneeDao getConsigneeDao() {
		return consigneeDao;
	}

	public void setConsigneeDao(IConsigneeDao consigneeDao) {
		this.consigneeDao = consigneeDao;
	}

	public Consignee addConsignee(Consignee consignee)
			throws ConsigneeException {
		// TODO Auto-generated method stub
		try {
			return consigneeDao.addConsignee(consignee);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ConsigneeException("error");
		}
	}

	public boolean delConsigneeById(Integer id) throws ConsigneeException {
		// TODO Auto-generated method stub
		try {
			return consigneeDao.delConsigneeById(id);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ConsigneeException("error");
		}
	}

	public boolean delConsigneeByStakeholderId(Integer stakeholderId)
			throws ConsigneeException {
		// TODO Auto-generated method stub
		try {
			return consigneeDao.delConsigneeByStakeholderId(stakeholderId);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ConsigneeException("error");
		}
	}

	public List<Consignee> getAllConsignee() throws ConsigneeException {
		// TODO Auto-generated method stub
		try {
			return consigneeDao.getAllConsignee();
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ConsigneeException("error");
		}
	}

	public Consignee getConsigneeById(Integer id) throws ConsigneeException {
		// TODO Auto-generated method stub
		try {
			return consigneeDao.getConsigneeById(id);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ConsigneeException("error");
		}
	}

	public List<Consignee> getConsigneeByStakeholderId(Integer stakeholderId)
			throws ConsigneeException {
		// TODO Auto-generated method stub
		try {
			return consigneeDao.getConsigneeByStakeholderId(stakeholderId);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ConsigneeException("error");
		}
	}

	public Consignee saveConsignee(Consignee consignee)
			throws ConsigneeException {
		// TODO Auto-generated method stub
		try {
			return consigneeDao.saveConsignee(consignee);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ConsigneeException("error");
		}
	}

	public Consignee saveOrUpdateConsignee(Consignee consignee)
			throws ConsigneeException {
		// TODO Auto-generated method stub
		try {
			return consigneeDao.saveOrUpdateConsignee(consignee);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ConsigneeException("error");
		}
	}

	public Consignee updateConsignee(Consignee consignee)
			throws ConsigneeException {
		// TODO Auto-generated method stub
		try {
			return consigneeDao.updateConsignee(consignee);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ConsigneeException("error");
		}
	}

}
