package com.ejd.web.bo;

/**
 * AbstractPerson entity provides the base persistence definition of the Person
 * entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public abstract class AbstractPerson extends java.lang.Object implements
		java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer age;
	private String sex;
	private String phone;
	private String tax;
	private String mobile;
	private String email;
	private String address;
	private String principalship;
	private String remark;
	private Integer sortOrder;

	// Constructors

	/** default constructor */
	public AbstractPerson() {
	}

	/** minimal constructor */
	public AbstractPerson(String name) {
		this.name = name;
	}

	/** full constructor */
	public AbstractPerson(String name, Integer age, String sex, String phone,
			String tax, String mobile, String email, String address,
			String principalship, String remark,
			Integer sortOrder) {
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.phone = phone;
		this.tax = tax;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.principalship = principalship;
		this.remark = remark;
		this.sortOrder = sortOrder;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTax() {
		return this.tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPrincipalship() {
		return this.principalship;
	}

	public void setPrincipalship(String principalship) {
		this.principalship = principalship;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getSortOrder() {
		return this.sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

}