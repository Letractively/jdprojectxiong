package com.ejd.model.service.iface;
import java.util.List;
import com.ejd.web.bo.Productunit;
import com.ejd.model.exception.ProductUnitException;


public interface IProductUnitService {

	public Productunit getProductUnitById(Integer id) throws ProductUnitException;
	public Productunit getProductUnitByName(String unitName) throws ProductUnitException;
	public List<Productunit> getAllProductUnit() throws ProductUnitException;
	public Productunit addProductUnit(Productunit productUnit) throws ProductUnitException;
	public boolean delProductUnitById(Integer id) throws ProductUnitException;
	public boolean delProductUnitByName(String unitName) throws ProductUnitException;
	public Productunit updateProductUnit(Productunit productUnit) throws ProductUnitException;
	public Productunit saveProductUnit(Productunit productUnit) throws ProductUnitException;
	public Productunit saveOrUpdateProductUnit(Productunit productUnit) throws ProductUnitException;
}
