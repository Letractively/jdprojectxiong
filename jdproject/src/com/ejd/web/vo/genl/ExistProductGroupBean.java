package com.ejd.web.vo.genl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import net.sf.cglib.beans.BeanCopier;

import com.ejd.model.exception.ProductBrandException;
import com.ejd.model.exception.ProductCategoryException;
import com.ejd.model.service.iface.IProductBrandService;
import com.ejd.model.service.iface.IProductCategoryService;
import com.ejd.model.service.iface.IProductService;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.bo.Productbrand;
import com.ejd.web.bo.Productcategory;
import com.ejd.web.vo.genl.productnavigation.ProductGroup;
import com.ejd.web.vo.product.ProductPrice;
import com.ejd.web.vo.productbrand.ProductBrand;
import com.ejd.web.vo.productcategory.ProductCategory;

public class ExistProductGroupBean {
	public IProductCategoryService productCategoryService;
	public IProductBrandService productBrandService;
	private ProductGroup phoneProductGroup;
	private ProductGroup cameraProductGroup;
	private ProductGroup televisionProductGroup;
	public ExistProductGroupBean() throws ProductCategoryException,ProductBrandException {
		super();
		if (null == this.getProductCategoryService()) {
			this.setProductCategoryService((IProductCategoryService)SpringFacesUtil.getSpringBean("productCategoryService"));
		}
		if (null == this.getProductBrandService()) {
			this.setProductBrandService((IProductBrandService)SpringFacesUtil.getSpringBean("productBrandService"));
		}
		init();
	}
	public IProductCategoryService getProductCategoryService() {
		return productCategoryService;
	}
	public void setProductCategoryService(
			IProductCategoryService productCategoryService) {
		this.productCategoryService = productCategoryService;
	}
	public IProductBrandService getProductBrandService() {
		return productBrandService;
	}
	public void setProductBrandService(IProductBrandService productBrandService) {
		this.productBrandService = productBrandService;
	}
	
	public ProductGroup getPhoneProductGroup() {
		return phoneProductGroup;
	}
	public void getPhoneProductGroupBySearch() throws ProductCategoryException,ProductBrandException{
		if (null == this.getPhoneProductGroup()) {
			this.setPhoneProductGroup(new ProductGroup());
		}
		if (null == this.getCameraProductGroup()) {
			this.setCameraProductGroup(new ProductGroup());
		}
		if (null == this.getTelevisionProductGroup()) {
			this.setTelevisionProductGroup(new ProductGroup());
		}
		Productcategory phoneProductCategory= this.getProductCategoryService().getProductCategoryByName("手机");
		ProductCategory phonePrimaryCategory = new ProductCategory();
		BeanCopier copyPhone = BeanCopier.create(Productcategory.class, ProductCategory.class, false);
		copyPhone.copy(phoneProductCategory, phonePrimaryCategory, null);
		this.getPhoneProductGroup().setPrimaryCategory(phonePrimaryCategory);
		this.getPhoneProductGroup().setSecondCategorys(this.getSecondCategorysList(phonePrimaryCategory));
		this.getPhoneProductGroup().setBrands(this.getBrandsList(phonePrimaryCategory));
		this.getPhoneProductGroup().setPrices(this.getProductPriceList(phonePrimaryCategory));
		Productcategory cameraProductCategory= this.getProductCategoryService().getProductCategoryByName("数码相机");
		ProductCategory cameraPrimaryCategory = new ProductCategory();
		BeanCopier copyCamera = BeanCopier.create(Productcategory.class, ProductCategory.class, false);
		copyCamera.copy(cameraProductCategory, cameraPrimaryCategory, null);
		this.getCameraProductGroup().setPrimaryCategory(cameraPrimaryCategory);
		this.getCameraProductGroup().setSecondCategorys(this.getSecondCategorysList(cameraPrimaryCategory));
		this.getCameraProductGroup().setBrands(this.getBrandsList(cameraPrimaryCategory));
		this.getCameraProductGroup().setPrices(this.getProductPriceList(cameraPrimaryCategory));
		Productcategory televisionProductCategory= this.getProductCategoryService().getProductCategoryByName("平板电视");
		ProductCategory televisionPrimaryCategory = new ProductCategory();
		BeanCopier copyTelevision = BeanCopier.create(Productcategory.class, ProductCategory.class, false);
		copyTelevision.copy(televisionProductCategory, televisionPrimaryCategory, null);
		this.getTelevisionProductGroup().setPrimaryCategory(televisionPrimaryCategory);
		this.getTelevisionProductGroup().setSecondCategorys(this.getSecondCategorysList(televisionPrimaryCategory));
		this.getTelevisionProductGroup().setBrands(this.getBrandsList(televisionPrimaryCategory));
		this.getTelevisionProductGroup().setPrices(this.getProductPriceList(televisionPrimaryCategory));
	}
	public void setPhoneProductGroup(ProductGroup phoneProductGroup) {
		this.phoneProductGroup = phoneProductGroup;
	}
	public ProductGroup getCameraProductGroup() {
		return cameraProductGroup;
	}
	public void setCameraProductGroup(ProductGroup cameraProductGroup) {
		this.cameraProductGroup = cameraProductGroup;
	}
	public ProductGroup getTelevisionProductGroup() {
		return televisionProductGroup;
	}
	public void setTelevisionProductGroup(ProductGroup televisionProductGroup) {
		this.televisionProductGroup = televisionProductGroup;
	}
	private List<ProductCategory> getSecondCategorysList(ProductCategory primaryCategory) throws ProductCategoryException {
		List<ProductCategory> result = new ArrayList<ProductCategory>();
		List<Integer> intResult = new ArrayList<Integer>();
		String sqlCategory = "select distinct secondcategoryid from product where primarycategoryid = ?";
		SessionFactory sf =(SessionFactory) SpringFacesUtil.getSpringBean("sessionFactory");
		Session session = sf.openSession();
		try {
			SQLQuery sqlQuery=session.createSQLQuery(sqlCategory);
			sqlQuery.setInteger(0,primaryCategory.getId());
			session.beginTransaction();
			intResult =(List<Integer>)sqlQuery.list();
			session.flush();
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			} finally {
				  session.close();
			}
		if (null != intResult && !intResult.isEmpty()) {
			for (Integer id:intResult) {
				Productcategory productCategory = this.getProductCategoryService().getProductCategoryById(id);
				ProductCategory secondCategory = new ProductCategory();
				BeanCopier copy = BeanCopier.create(Productcategory.class, ProductCategory.class, false);
				copy.copy(productCategory, secondCategory, null);
				result.add(secondCategory);
			}
			
		}
		return result;
	}
	private List<ProductBrand> getBrandsList(ProductCategory primaryCategory) throws ProductBrandException {
		List<ProductBrand> result = new ArrayList<ProductBrand>();
		List<Integer> intResult = new ArrayList<Integer>();
		String sqlBrand = "select distinct brandid from product where primarycategoryid = ?";
		SessionFactory sf =(SessionFactory) SpringFacesUtil.getSpringBean("sessionFactory");
		Session session = sf.openSession();
		try {
			SQLQuery sqlQuery=session.createSQLQuery(sqlBrand);
			sqlQuery.setInteger(0,primaryCategory.getId());
			session.beginTransaction();
			intResult =(List<Integer>)sqlQuery.list();
			session.flush();
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			} finally {
				  session.close();
			}
		if (null != intResult && !intResult.isEmpty()) {
			for (Integer id:intResult) {
				Productbrand productBrand = this.getProductBrandService().getProductBrandById(id);
				ProductBrand tempCategory = new ProductBrand();
				BeanCopier copy = BeanCopier.create(Productbrand.class, ProductBrand.class, false);
				copy.copy(productBrand, tempCategory, null);
				result.add(tempCategory);
			}
			
		}
		return result;
	}
	private List<ProductPrice> getProductPriceList(ProductCategory primaryCategory) throws ProductBrandException {
		List<ProductPrice> result = new ArrayList<ProductPrice>();
		List<Double> doubleResult = new ArrayList<Double>();
		String sqlProductPrice = "SELECT distinct retailprice FROM ejd.product p where p.primarycategoryid = ? group by retailprice order by retailprice asc";
		SessionFactory sf =(SessionFactory) SpringFacesUtil.getSpringBean("sessionFactory");
		Session session = sf.openSession();
		try {
			SQLQuery sqlQuery=session.createSQLQuery(sqlProductPrice);
			sqlQuery.setInteger(0,primaryCategory.getId());
			session.beginTransaction();
			doubleResult = sqlQuery.list();
			session.flush();
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			} finally {
				  session.close();
			}
		if (null != doubleResult && !doubleResult.isEmpty()) {
			Map<String,Double> doubleMap = new HashMap<String,Double>();
			for (int i=0; i < doubleResult.size(); i++) {
				doubleMap.put(String.valueOf(i), doubleResult.get(i));
			}
			if (doubleResult.size()<=5) {
				ProductPrice tempProductPrice = null;
				for (int i = 0; i < doubleResult.size(); i++) {
					if (i==0) {
						//do nothing;
					} else if (i == doubleResult.size()-1){
						tempProductPrice = new ProductPrice(doubleMap.get(String.valueOf(i)),new Double(999999999),">="+String.valueOf(doubleMap.get(String.valueOf(i)).intValue()));
					} else {
						tempProductPrice = new ProductPrice(doubleMap.get(String.valueOf(i-1)),doubleMap.get(i),String.valueOf(doubleMap.get(String.valueOf(i-1)).intValue())+"--" + String.valueOf(doubleMap.get(String.valueOf(i)).intValue()));
					}
					if (null != tempProductPrice) {
						result.add(tempProductPrice);
					}
				}
			}
			
		}
		return result;
	}
	
	private void init() throws ProductCategoryException,ProductBrandException{
		this.getPhoneProductGroupBySearch();
	}
}
