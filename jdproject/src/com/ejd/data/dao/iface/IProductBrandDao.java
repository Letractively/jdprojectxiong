package com.ejd.data.dao.iface;

import java.util.List;

import com.ejd.web.bo.Productbrand;

public interface IProductBrandDao {
	public Productbrand getProductBrandById(Integer id);
	public Productbrand getProductBrandByName(String brandName);
	public List<Productbrand> getAllProductBrand();
	public Productbrand addProductBrand(Productbrand productBrand);
	public boolean delProductBrandById(Integer id);
	public boolean delProductBrandByName(String brandName);
	public Productbrand updateProductBrand(Productbrand productBrand);
	public Productbrand saveProductBrand(Productbrand productBrand);
	public Productbrand saveOrUpdateProductBrand(Productbrand productBrand);
}
