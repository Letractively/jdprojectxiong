package com.ejd.model.service.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateObjectRetrievalFailureException;

import com.ejd.data.dao.iface.IStakeholderDao;
import com.ejd.model.exception.StakeholderException;
import com.ejd.model.service.iface.IStakeholderService;
import com.ejd.web.bo.Stakeholder;

public class StakeholderServiceImpl implements IStakeholderService {

	private IStakeholderDao stakeholderDao;
	
	public IStakeholderDao getStakeholderDao() {
		return stakeholderDao;
	}

	public void setStakeholderDao(IStakeholderDao stakeholderDao) {
		this.stakeholderDao = stakeholderDao;
	}

	public boolean delStakeholderById(Integer id) throws StakeholderException {
		// TODO Auto-generated method stub
		try {
			return stakeholderDao.delStakeholderById(id);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new StakeholderException("error");
		} 
	}

	public boolean delStakeholderByUserId(String userId)
			throws StakeholderException {
		// TODO Auto-generated method stub
		try {
			return stakeholderDao.delStakeholderByUserId(userId);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new StakeholderException("error");
		} 
	}

	public Stakeholder getStakeholderById(Integer id)
			throws StakeholderException {
		// TODO Auto-generated method stub
		try {
			return stakeholderDao.getStakeholderById(id);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new StakeholderException("error");
		} 
	}

	public Stakeholder getStakeholderByUserId(String userId)
			throws StakeholderException {
		// TODO Auto-generated method stub
		try {
			return stakeholderDao.getStakeholderByUserId(userId);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new StakeholderException("error");
		} 
	}

	public List<Stakeholder> getStakeholdersByFullName(String fullName)
			throws StakeholderException {
		// TODO Auto-generated method stub
		try {
			return stakeholderDao.getStakeholdersByFullName(fullName);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new StakeholderException("error");
		} 
	}

	public List<Stakeholder> getStakeholdersByMnemonicchars(String mnemonicchars)
			throws StakeholderException {
		// TODO Auto-generated method stub
		try {
			return stakeholderDao.getStakeholdersByMnemonicchars(mnemonicchars);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new StakeholderException("error");
		} 
	}

	public List<Stakeholder> getStakeholdersByShortName(String shortName)
			throws StakeholderException {
		// TODO Auto-generated method stub
		try {
			return stakeholderDao.getStakeholdersByShortName(shortName);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new StakeholderException("error");
		} 
	}

	public List<Stakeholder> getStakeholdersByType(String type)
			throws StakeholderException {
		// TODO Auto-generated method stub
		try {
			return stakeholderDao.getStakeholdersByType(type);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new StakeholderException("error");
		} 
	}

	public Stakeholder saveOrUpdateStakeholder(Stakeholder stakeholder)
			throws StakeholderException {
		// TODO Auto-generated method stub
		try {
			return stakeholderDao.saveOrUpdateStakeholder(stakeholder);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new StakeholderException("error");
		} 
	}

	public Stakeholder saveStakeholder(Stakeholder stakeholder)
			throws StakeholderException {
		// TODO Auto-generated method stub
		try {
			return stakeholderDao.saveStakeholder(stakeholder);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new StakeholderException("error");
		} 
	}

	public Stakeholder updateStakeholder(Stakeholder stakeholder)
			throws StakeholderException {
		// TODO Auto-generated method stub
		try {
			return stakeholderDao.updateStakeholder(stakeholder);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new StakeholderException("error");
		} 
	}

}
