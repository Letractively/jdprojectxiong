package com.ejd.web.vo.stakeholder;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;

public class AddressVo {
	private Integer id;
	@NotEmpty
	@Length(min=2,max=100)
	private String address;
	private String zip;
	@NotEmpty
	@Length(min=2,max=20)
	private String desc;
	private Integer sortOrder;
	private boolean selected;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Integer getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public AddressVo() {
		
	}
	public AddressVo(String address, String desc) {
		super();
		this.address = address;
		this.desc = desc;
		this.sortOrder =1;
		this.selected = Boolean.FALSE;
	}
	public AddressVo(String address, String zip, String desc, Integer sortOrder, boolean selected) {
		super();
		this.address = address;
		this.zip = zip;
		this.desc = desc;
		this.sortOrder = sortOrder;
		this.selected = selected;
	}
}
