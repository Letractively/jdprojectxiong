package com.ejd.web.bo;

/**
 * Person entity.
 * 
 * @author MyEclipse Persistence Tools
 */
public class Person extends AbstractPerson implements java.io.Serializable {

	// Constructors
	Stakeholder stakeholder;
	/** default constructor */
	public Person() {
	}

	/** minimal constructor */
	public Person(String name, Integer stakeholderId) {
		super(name, stakeholderId);
	}

	/** full constructor */
	public Person(String name, Integer age, String sex, String phone,
			String tax, String mobile, String email, String address,
			String principalship, String remark, Integer stakeholderId,
			Integer sortOrder) {
		super(name, age, sex, phone, tax, mobile, email, address,
				principalship, remark, stakeholderId, sortOrder);
	}

	public Stakeholder getStakeholder() {
		return stakeholder;
	}

	public void setStakeholder(Stakeholder stakeholder) {
		this.stakeholder = stakeholder;
	}

}
