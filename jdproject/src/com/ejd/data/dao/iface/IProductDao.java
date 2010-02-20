package com.ejd.data.dao.iface;

import java.util.List;

import com.ejd.model.exception.ProductException;
import com.ejd.web.bo.Product;
import com.ejd.web.vo.product.ProductPrice;
import com.ejd.web.vo.product.base.RangeParam;

public interface IProductDao {
	public Product getProductById(Integer id);
	public Product getProductByCode(String code);
	public List<Product> getAllProduct();
	public Product addProduct(Product product);
	public boolean delProductById(Integer id);
	public boolean delProductByCode(String brandCode);
	public Product updateProduct(Product product);
	public Product saveProduct(Product product);
	public Product saveOrUpdateProduct(Product product);
	public List<Product> getPSBPF1F2ProductByCriteria(String primaryCategoryCode, String secondCategoryCode, String brandCode, RangeParam priceRange, RangeParam volumeRange, RangeParam powerRange);
	public List<Product> getPSBPF6F7ProductByCriteria(String primaryCategoryCode, String secondCategoryCode, String brandCode, RangeParam priceRange, String panelType, String fitting);
	public List<Product> getPSBPF1ProductByCriteria(String primaryCategoryCode, String secondCategoryCode, String brandCode, RangeParam priceRange, RangeParam volumeRange);
	public List<Product> getPSBPF6ProductByCriteria(String primaryCategoryCode, String secondCategoryCode, String brandCode, RangeParam priceRange, String hotType);
	public List<Product> getPSBPProductByCriteria(String primaryCategoryCode, String secondCategoryCode, String brandCode, RangeParam priceRange);
	public List<Product> getPSBPF1F6ProductByCriteria(String primaryCategoryCode, String secondCategoryCode, String brandCode, RangeParam priceRange, RangeParam volumeRange, String f6);
	public List<Product> getPSBPF1F2F6ProductByCriteria(String primaryCategoryCode, String secondCategoryCode, String brandCode, RangeParam priceRange, RangeParam volumeRange, RangeParam f2, String f6);
	
	
	public List<String> getBrandCodeListByCategory(String primaryCategory, String secondCategory);
}
