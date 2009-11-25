package com.ejd.data.dao.iface;

import java.util.List;

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
	public List<Product> getKitchenApplianceProductByCriteria(String primaryCategoryCode, String secondCategoryCode, String brandCode, RangeParam priceRange);
	public List<String> getBrandCodeListByCategory(String primaryCategory, String secondCategory);
}
