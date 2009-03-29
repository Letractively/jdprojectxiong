package com.ejd.model.service.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateObjectRetrievalFailureException;

import com.ejd.model.exception.ProductBrandException;
import com.ejd.model.service.iface.IProductBrandService;
import com.ejd.web.bo.Productbrand;
import com.ejd.data.dao.iface.IProductBrandDao;

public class ProductBrandServiceImpl implements IProductBrandService {
	private IProductBrandDao productBrandDao;

	
	public IProductBrandDao getProductBrandDao() {
		return productBrandDao;
	}

	public void setProductBrandDao(IProductBrandDao productBrandDao) {
		this.productBrandDao = productBrandDao;
	}

	public Productbrand addProductBrand(Productbrand productBrand)
			throws ProductBrandException {
		// TODO Auto-generated method stub
		try {
			return productBrandDao.addProductBrand(productBrand);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductBrandException("error");
		}
		
	}

	public boolean delProductBrandById(Integer id)
			throws ProductBrandException {
		// TODO Auto-generated method stub
		try {
			return productBrandDao.delProductBrandById(id);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductBrandException("error");
		}
	}

	public boolean delProductBrandByName(String brandName)
			throws ProductBrandException {
		// TODO Auto-generated method stub
		try {
			return productBrandDao.delProductBrandByName(brandName);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductBrandException("error");
		}
	}

	public List<Productbrand> getAllProductBrand()
			throws ProductBrandException {
		// TODO Auto-generated method stub
		try {
			return productBrandDao.getAllProductBrand();
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductBrandException("error");
		}
	}

	public Productbrand getProductBrandById(Integer id)
			throws ProductBrandException {
		// TODO Auto-generated method stub
		try {
			return productBrandDao.getProductBrandById(id);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductBrandException("error");
		}
	}

	public Productbrand getProductBrandByName(String brandName)
			throws ProductBrandException {
		// TODO Auto-generated method stub
		try {
			return productBrandDao.getProductBrandByName(brandName);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductBrandException("error");
		}
	}

	public Productbrand saveOrUpdateProductBrand(
			Productbrand productBrand) throws ProductBrandException {
		// TODO Auto-generated method stub
		try {
			return productBrandDao.saveOrUpdateProductBrand(productBrand);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductBrandException("error");
		}
	}

	public Productbrand saveProductBrand(Productbrand productBrand)
			throws ProductBrandException {
		// TODO Auto-generated method stub
		try {
			return productBrandDao.saveProductBrand(productBrand);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductBrandException("error");
		}
	}

	public Productbrand updateProductBrand(Productbrand productBrand)
			throws ProductBrandException {
		// TODO Auto-generated method stub
		try {
			return productBrandDao.updateProductBrand(productBrand);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductBrandException("error");
		}
	}

}
