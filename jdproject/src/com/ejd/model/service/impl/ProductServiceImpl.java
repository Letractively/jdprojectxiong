package com.ejd.model.service.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateObjectRetrievalFailureException;

import com.ejd.data.dao.iface.IProductDao;
import com.ejd.model.exception.ProductBrandException;
import com.ejd.model.exception.ProductException;
import com.ejd.model.service.iface.IProductService;
import com.ejd.web.bo.Product;
import com.ejd.web.vo.product.ProductPrice;
import com.ejd.web.vo.product.base.RangeParam;

public class ProductServiceImpl implements IProductService {

	private IProductDao productDao;
	
	public IProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(IProductDao productDao) {
		this.productDao = productDao;
	}

	public Product addProduct(Product product) throws ProductException {
		// TODO Auto-generated method stub
		try {
			return productDao.addProduct(product);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductException("error");
		}
	}

	public boolean delProductByCode(String code) throws ProductException {
		// TODO Auto-generated method stub
		try {
			return productDao.delProductByCode(code);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductException("error");
		}
	}

	public boolean delProductById(Integer id) throws ProductException {
		// TODO Auto-generated method stub
		try {
			return productDao.delProductById(id);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductException("error");
		}
	}

	public List<Product> getAllProduct() throws ProductException {
		// TODO Auto-generated method stub
		try {
			return productDao.getAllProduct();
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductException("error");
		}
	}

	public Product getProductByCode(String code) throws ProductException {
		// TODO Auto-generated method stub
		try {
			return productDao.getProductByCode(code);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductException("error");
		}
	}

	public Product getProductById(Integer id) throws ProductException {
		// TODO Auto-generated method stub
		try {
			return productDao.getProductById(id);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductException("error");
		}
	}

	public Product saveOrUpdateProduct(Product product) throws ProductException {
		// TODO Auto-generated method stub
		try {
			return productDao.saveOrUpdateProduct(product);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductException("error");
		}
	}

	public Product saveProduct(Product product) throws ProductException {
		// TODO Auto-generated method stub
		try {
			return productDao.saveProduct(product);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductException("error");
		}
	}

	public Product updateProduct(Product product) throws ProductException {
		// TODO Auto-generated method stub
		try {
			return productDao.updateProduct(product);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductException("error");
		}
	}
	/*public List<Product> getKitchenApplianceProductByCriteria(String primaryCategoryCode, String secondCategoryCode, String brandCode, RangeParam priceRange) throws ProductException {
		try {
			return productDao.getKitchenApplianceProductByCriteria(primaryCategoryCode, secondCategoryCode, brandCode, priceRange);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductException("error");
		}
	}*/
	public List<Product> getPSBPF1F2ProductByCriteria(String primaryCategoryCode, String secondCategoryCode, String brandCode, RangeParam priceRange, RangeParam f1, RangeParam f2) throws ProductException {
		try {
			return productDao.getPSBPF1F2ProductByCriteria(primaryCategoryCode, secondCategoryCode, brandCode, priceRange, f1, f2);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductException("error");
		}
	}
	public List<Product> getPSBPF6F7ProductByCriteria(String primaryCategoryCode, String secondCategoryCode, String brandCode, RangeParam priceRange, String f6, String f7) throws ProductException {
		try {
			return productDao.getPSBPF6F7ProductByCriteria(primaryCategoryCode, secondCategoryCode, brandCode, priceRange, f6, f7);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductException("error");
		}
	}
	public List<Product> getPSBPF1ProductByCriteria(String primaryCategoryCode, String secondCategoryCode, String brandCode, RangeParam priceRange, RangeParam f1) throws ProductException {
		try {
			return productDao.getPSBPF1ProductByCriteria(primaryCategoryCode, secondCategoryCode, brandCode, priceRange, f1);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductException("error");
		}
	}
	public List<Product> getPSBPF6ProductByCriteria(String primaryCategoryCode, String secondCategoryCode, String brandCode, RangeParam priceRange, String f6) throws ProductException {
		try {
			return productDao.getPSBPF6ProductByCriteria(primaryCategoryCode, secondCategoryCode, brandCode, priceRange, f6);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductException("error");
		}
	}
	public List<Product> getPSBPProductByCriteria(String primaryCategoryCode, String secondCategoryCode, String brandCode, RangeParam priceRange) throws ProductException {
		try {
			return productDao.getPSBPProductByCriteria(primaryCategoryCode, secondCategoryCode, brandCode, priceRange);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductException("error");
		}
	}
	public List<Product> getPSBPF1F6ProductByCriteria(String primaryCategoryCode, String secondCategoryCode, String brandCode, RangeParam priceRange, RangeParam f1, String f6) throws ProductException {
		try {
			return productDao.getPSBPF1F6ProductByCriteria(primaryCategoryCode, secondCategoryCode, brandCode, priceRange, f1,f6);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductException("error");
		}
	}
	public List<Product> getPSBPF1F6F7ProductByCriteria(String primaryCategoryCode, String secondCategoryCode, String brandCode, RangeParam priceRange, RangeParam f1, String f6, String f7) throws ProductException {
		try {
			return productDao.getPSBPF1F6F7ProductByCriteria(primaryCategoryCode, secondCategoryCode, brandCode, priceRange, f1, f6, f7);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductException("error");
		}
	}
	public List<Product> getPSBPF1F2F6F7ProductByCriteria(String primaryCategoryCode, String secondCategoryCode, String brandCode, RangeParam priceRange, RangeParam f1, RangeParam f2, String f6, String f7) throws ProductException {
		try {
			return productDao.getPSBPF1F2F6F7ProductByCriteria(primaryCategoryCode, secondCategoryCode, brandCode, priceRange, f1, f2, f6, f7);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductException("error");
		}
	}
	public List<Product> getPSBPF1F2F3F4F5F6F7F8F9F10ProductByCriteria(String primaryCategoryCode, String secondCategoryCode, String brandCode, RangeParam priceRange, RangeParam f1, RangeParam f2, RangeParam f3, RangeParam f4, RangeParam f5, String f6, String f7, String f8, String f9, String f10) throws ProductException {
		try {
			return productDao.getPSBPF1F2F3F4F5F6F7F8F9F10ProductByCriteria(primaryCategoryCode, secondCategoryCode, brandCode, priceRange, f1, f2, f3, f4, f5, f6, f7, f8, f9 ,f10);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductException("error");
		}
	}
	public List<Product> getPSBPF1F2F6ProductByCriteria(String primaryCategoryCode, String secondCategoryCode, String brandCode, RangeParam priceRange, RangeParam f1, RangeParam f2, String f6) throws ProductException {
		try {
			return productDao.getPSBPF1F2F6ProductByCriteria(primaryCategoryCode, secondCategoryCode, brandCode, priceRange, f1,f2,f6);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductException("error");
		}
	}
	
	
	
	public List<String> getBrandCodeListByCategory(String primaryCategoryCode, String secondCategoryCode) throws ProductException {
		if (null == primaryCategoryCode || "".equals(primaryCategoryCode)) {
			return null;
		}
		try {
			return productDao.getBrandCodeListByCategory(primaryCategoryCode, secondCategoryCode);
			
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new ProductException("error");
		}
	}

}
