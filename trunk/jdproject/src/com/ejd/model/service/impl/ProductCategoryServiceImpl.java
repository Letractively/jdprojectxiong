package com.ejd.model.service.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateObjectRetrievalFailureException;

import com.ejd.model.exception.ProductCategoryException;
import com.ejd.model.service.iface.IProductCategoryService;
import com.ejd.web.bo.Productcategory;
import com.ejd.data.dao.iface.IProductCategoryDao;

public class ProductCategoryServiceImpl implements IProductCategoryService {
	private IProductCategoryDao productCategoryDao;

	
	public IProductCategoryDao getProductCategoryDao() {
		return productCategoryDao;
	}

	public void setProductCategoryDao(IProductCategoryDao productCategoryDao) {
		this.productCategoryDao = productCategoryDao;
	}

	public Productcategory addProductCategory(Productcategory productCategory)
			throws ProductCategoryException {
		// TODO Auto-generated method stub
		try {
			return productCategoryDao.addProductCategory(productCategory);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductCategoryException("error");
		}
		
	}

	public boolean delProductCategoryById(Integer id)
			throws ProductCategoryException {
		// TODO Auto-generated method stub
		try {
			return productCategoryDao.delProductCategoryById(id);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductCategoryException("error");
		}
	}

	public boolean delProductCategoryByName(String categoryName)
			throws ProductCategoryException {
		// TODO Auto-generated method stub
		try {
			return productCategoryDao.delProductCategoryByName(categoryName);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductCategoryException("error");
		}
	}

	public List<Productcategory> getAllProductCategory()
			throws ProductCategoryException {
		// TODO Auto-generated method stub
		try {
			return productCategoryDao.getAllProductCategory();
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductCategoryException("error");
		}
	}

	public Productcategory getProductCategoryById(Integer id)
			throws ProductCategoryException {
		// TODO Auto-generated method stub
		try {
			return productCategoryDao.getProductCategoryById(id);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductCategoryException("error");
		}
	}

	public Productcategory getProductCategoryByName(String categoryName)
			throws ProductCategoryException {
		// TODO Auto-generated method stub
		try {
			return productCategoryDao.getProductCategoryByName(categoryName);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductCategoryException("error");
		}
	}

	public Productcategory saveOrUpdateProductCategory(
			Productcategory productCategory) throws ProductCategoryException {
		// TODO Auto-generated method stub
		try {
			return productCategoryDao.saveOrUpdateProductCategory(productCategory);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductCategoryException("error");
		}
	}

	public Productcategory saveProductCategory(Productcategory productCategory)
			throws ProductCategoryException {
		// TODO Auto-generated method stub
		try {
			return productCategoryDao.saveProductCategory(productCategory);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductCategoryException("error");
		}
	}

	public Productcategory updateProductCategory(Productcategory productCategory)
			throws ProductCategoryException {
		// TODO Auto-generated method stub
		try {
			return productCategoryDao.updateProductCategory(productCategory);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductCategoryException("error");
		}
	}

}
