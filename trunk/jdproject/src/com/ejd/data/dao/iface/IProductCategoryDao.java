package com.ejd.data.dao.iface;

import java.util.List;
import com.ejd.web.bo.Productcategory;
public interface IProductCategoryDao {
	public Productcategory getProductCategoryById(Integer id);
	public Productcategory getProductCategoryByName(String categoryName);
	public List<Productcategory> getAllProductCategory();
	public Productcategory addProductCategory(Productcategory productCategory);
	public boolean delProductCategoryById(Integer id);
	public boolean delProductCategoryByName(String categoryName);
	public Productcategory updateProductCategory(Productcategory productCategory);
	public Productcategory saveProductCategory(Productcategory productCategory);
	public Productcategory saveOrUpdateProductCategory(Productcategory productCategory);
}
