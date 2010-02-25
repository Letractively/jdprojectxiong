package com.ejd.model.service.iface;
import java.util.List;
import com.ejd.web.bo.Product;
import com.ejd.web.vo.product.ProductPrice;
import com.ejd.web.vo.product.base.RangeParam;
import com.ejd.model.exception.ProductException;


public interface IProductService {

	public Product getProductById(Integer id) throws ProductException;
	public Product getProductByCode(String code) throws ProductException;
	public List<Product> getAllProduct() throws ProductException;
	public Product addProduct(Product product) throws ProductException;
	public boolean delProductById(Integer id) throws ProductException;
	public boolean delProductByCode(String code) throws ProductException;
	public Product updateProduct(Product product) throws ProductException;
	public Product saveProduct(Product product) throws ProductException;
	public Product saveOrUpdateProduct(Product product) throws ProductException;
	//public List<Product> getKitchenApplianceProductByCriteria(String primaryCategoryCode, String secondCategoryCode, String brandCode, RangeParam priceRange) throws ProductException;
	public List<Product> getPSBPF1F2ProductByCriteria(String primaryCategoryCode, String secondCategoryCode, String brandCode, RangeParam priceRange, RangeParam f1Range, RangeParam f2Range) throws ProductException;
	public List<Product> getPSBPF1F2F6ProductByCriteria(String primaryCategoryCode, String secondCategoryCode, String brandCode, RangeParam priceRange, RangeParam f1,RangeParam f2, String f6) throws ProductException;
	public List<Product> getPSBPF6F7ProductByCriteria(String primaryCategoryCode, String secondCategoryCode, String brandCode, RangeParam priceRange, String f6, String f7) throws ProductException;
	public List<Product> getPSBPF1ProductByCriteria(String primaryCategoryCode, String secondCategoryCode, String brandCode, RangeParam priceRange, RangeParam f1) throws ProductException;
	public List<Product> getPSBPF6ProductByCriteria(String primaryCategoryCode, String secondCategoryCode, String brandCode, RangeParam priceRange, String f6) throws ProductException;
	public List<Product> getPSBPProductByCriteria(String primaryCategoryCode, String secondCategoryCode, String brandCode, RangeParam priceRange) throws ProductException;
	public List<Product> getPSBPF1F6ProductByCriteria(String primaryCategoryCode, String secondCategoryCode, String brandCode, RangeParam priceRange, RangeParam f1, String f6) throws ProductException;
	public List<Product> getPSBPF1F6F7ProductByCriteria(String primaryCategoryCode, String secondCategoryCode, String brandCode, RangeParam priceRange, RangeParam f1, String f6, String f7) throws ProductException;
	public List<Product> getPSBPF1F2F6F7ProductByCriteria(String primaryCategoryCode, String secondCategoryCode, String brandCode, RangeParam priceRange, RangeParam f1, RangeParam f2, String f6, String f7) throws ProductException;
	public List<Product> getPSBPF1F2F3F4F5F6F7F8F9F10ProductByCriteria(String primaryCategoryCode, String secondCategoryCode, String brandCode, RangeParam priceRange, RangeParam f1, RangeParam f2, RangeParam f3, RangeParam f4, RangeParam f5, String f6, String f7, String f8, String f9, String f10) throws ProductException;
	public List<String> getBrandCodeListByCategory(String primaryCategoryCode, String secondCategoryCode) throws ProductException;
}
