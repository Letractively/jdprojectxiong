package com.ejd.model.service.iface;
import java.util.List;
import com.ejd.web.bo.Productcategory;
import com.ejd.model.exception.ProductCategoryException;


public interface IProductCategoryService {

	public Productcategory getProductCategoryById(Integer id) throws ProductCategoryException;
	public Productcategory getProductCategoryByName(String categoryName) throws ProductCategoryException;
	public List<Productcategory> getAllProductCategory() throws ProductCategoryException;
	public Productcategory addProductCategory(Productcategory productCategory) throws ProductCategoryException;
	public boolean delProductCategoryById(Integer id) throws ProductCategoryException;
	public boolean delProductCategoryByName(String categoryName) throws ProductCategoryException;
	public Productcategory updateProductCategory(Productcategory productCategory) throws ProductCategoryException;
	public Productcategory saveProductCategory(Productcategory productCategory) throws ProductCategoryException;
	public Productcategory saveOrUpdateProductCategory(Productcategory productCategory) throws ProductCategoryException;
}
