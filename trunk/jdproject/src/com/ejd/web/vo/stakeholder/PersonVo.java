package com.ejd.web.vo.stakeholder;

import java.io.Serializable;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;


public class PersonVo implements Serializable {
	private static final long serialVersionUID = -3639047543048763052L;
	private Integer id;
	@NotEmpty
	@Length(min=2,max=20)
	private String name;
	private Integer age;
	private String sex;
	private String phone;
	private String tax;
	private String mobile;
	private String email;
	private String address;
	private String principalship;
	@Length(min=0,max=200)
	private String remark;
	private Integer sortOrder;
	private boolean selected;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTax() {
		return tax;
	}
	public void setTax(String tax) {
		this.tax = tax;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPrincipalship() {
		return principalship;
	}
	public void setPrincipalship(String principalship) {
		this.principalship = principalship;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public PersonVo() {
		
	}
	public PersonVo(String name) {
		super();
		this.name = name;
		this.sortOrder = 1;
		this.selected = Boolean.FALSE;
	}
	public PersonVo(String name,Integer sortOrder,boolean selected) {
		super();
		this.name = name;
		this.sortOrder = sortOrder;
		this.selected = selected;
	}
	public PersonVo(String address, Integer age, String email, String mobile,
			String name, String phone, String principalship, String remark,
			boolean selected, String sex, Integer sortOrder, String tax) {
		super();
		this.address = address;
		this.age = age;
		this.email = email;
		this.mobile = mobile;
		this.name = name;
		this.phone = phone;
		this.principalship = principalship;
		this.remark = remark;
		this.selected = selected;
		this.sex = sex;
		this.sortOrder = sortOrder;
		this.tax = tax;
	}
	public PersonVo(Integer id,String address, Integer age, String email, String mobile,
			String name, String phone, String principalship, String remark,
			boolean selected, String sex, Integer sortOrder, String tax) {
		super();
		this.id = id;
		this.address = address;
		this.age = age;
		this.email = email;
		this.mobile = mobile;
		this.name = name;
		this.phone = phone;
		this.principalship = principalship;
		this.remark = remark;
		this.selected = selected;
		this.sex = sex;
		this.sortOrder = sortOrder;
		this.tax = tax;
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonVo other = (PersonVo) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
