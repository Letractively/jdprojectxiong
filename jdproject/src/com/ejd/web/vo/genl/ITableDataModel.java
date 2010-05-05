package com.ejd.web.vo.genl;

import javax.faces.model.DataModel;
import com.ejd.common.datapage.DataPage;


public interface ITableDataModel<T> {
	public int getTotalCount();   //this is used for auto generate data of one page;
	public DataPage<T> getDataPage(int startRow, int pageSize);//this is used for auto generate data of one page;
	public DataModel getDataModel();//this is used for auto generate data of one page;
	public DataModel getCurrDataModel();//this model get data ,you  must get data from DB first,it's used for scroll page;
		   
}
