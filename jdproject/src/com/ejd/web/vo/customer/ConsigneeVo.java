package com.ejd.web.vo.customer;

import com.ejd.web.bo.AbstractConsignee;

public class ConsigneeVo extends AbstractConsignee {
	
	public ConsigneeVo(){
		
	}

	public ConsigneeVo(boolean selected){
		this.setSelected(selected);
		
	}
}
