package com.ejd.data.dao.iface;

import java.util.List;

import com.ejd.web.bo.Productunit;

public interface IProductUnitDao {
	public Productunit getProductUnitById(Integer id);
	public Productunit getProductUnitByName(String unitName);
	public List<Productunit> getAllProductUnit();
	public Productunit addProductUnit(Productunit productUnit);
	public boolean delProductUnitById(Integer id);
	public boolean delProductUnitByName(String unitName);
	public Productunit updateProductUnit(Productunit productUnit);
	public Productunit saveProductUnit(Productunit productUnit);
	public Productunit saveOrUpdateProductUnit(Productunit productUnit);
}
