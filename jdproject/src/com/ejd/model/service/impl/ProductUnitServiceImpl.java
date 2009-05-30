package com.ejd.model.service.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateObjectRetrievalFailureException;

import com.ejd.model.exception.ProductUnitException;
import com.ejd.model.service.iface.IProductUnitService;
import com.ejd.web.bo.Productunit;
import com.ejd.data.dao.iface.IProductUnitDao;

public class ProductUnitServiceImpl implements IProductUnitService {
	private IProductUnitDao productUnitDao;

	
	public IProductUnitDao getProductUnitDao() {
		return productUnitDao;
	}

	public void setProductUnitDao(IProductUnitDao productUnitDao) {
		this.productUnitDao = productUnitDao;
	}

	public Productunit addProductUnit(Productunit productUnit)
			throws ProductUnitException {
		// TODO Auto-generated method stub
		try {
			return productUnitDao.addProductUnit(productUnit);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductUnitException("error");
		}
		
	}

	public boolean delProductUnitById(Integer id)
			throws ProductUnitException {
		// TODO Auto-generated method stub
		try {
			return productUnitDao.delProductUnitById(id);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductUnitException("error");
		}
	}

	public boolean delProductUnitByName(String unitName)
			throws ProductUnitException {
		// TODO Auto-generated method stub
		try {
			return productUnitDao.delProductUnitByName(unitName);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductUnitException("error");
		}
	}

	public List<Productunit> getAllProductUnit()
			throws ProductUnitException {
		// TODO Auto-generated method stub
		try {
			return productUnitDao.getAllProductUnit();
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductUnitException("error");
		}
	}

	public Productunit getProductUnitById(Integer id)
			throws ProductUnitException {
		// TODO Auto-generated method stub
		try {
			return productUnitDao.getProductUnitById(id);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductUnitException("error");
		}
	}

	public Productunit getProductUnitByName(String unitName)
			throws ProductUnitException {
		// TODO Auto-generated method stub
		try {
			return productUnitDao.getProductUnitByName(unitName);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductUnitException("error");
		}
	}

	public Productunit saveOrUpdateProductUnit(
			Productunit productUnit) throws ProductUnitException {
		// TODO Auto-generated method stub
		try {
			return productUnitDao.saveOrUpdateProductUnit(productUnit);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductUnitException("error");
		}
	}

	public Productunit saveProductUnit(Productunit productUnit)
			throws ProductUnitException {
		// TODO Auto-generated method stub
		try {
			return productUnitDao.saveProductUnit(productUnit);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductUnitException("error");
		}
	}

	public Productunit updateProductUnit(Productunit productUnit)
			throws ProductUnitException {
		// TODO Auto-generated method stub
		try {
			return productUnitDao.updateProductUnit(productUnit);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductUnitException("error");
		}
	}

}
