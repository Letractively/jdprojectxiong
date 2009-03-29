package com.ejd.model.service.iface;
import java.util.List;
import com.ejd.web.bo.Productbrand;
import com.ejd.model.exception.ProductBrandException;


public interface IProductBrandService {

	public Productbrand getProductBrandById(Integer id) throws ProductBrandException;
	public Productbrand getProductBrandByName(String categoryName) throws ProductBrandException;
	public List<Productbrand> getAllProductBrand() throws ProductBrandException;
	public Productbrand addProductBrand(Productbrand productBrand) throws ProductBrandException;
	public boolean delProductBrandById(Integer id) throws ProductBrandException;
	public boolean delProductBrandByName(String categoryName) throws ProductBrandException;
	public Productbrand updateProductBrand(Productbrand productBrand) throws ProductBrandException;
	public Productbrand saveProductBrand(Productbrand productBrand) throws ProductBrandException;
	public Productbrand saveOrUpdateProductBrand(Productbrand productBrand) throws ProductBrandException;
}
