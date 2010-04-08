package com.ejd.web.bo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Stakeholder entity.
 * 
 * @author MyEclipse Persistence Tools
 */
public class Stakeholder extends AbstractStakeholder implements
		java.io.Serializable {
	
	List<Person> conatctMans = new ArrayList<Person>();
	List<Address> addresses = new ArrayList<Address>();
	List<Bank> banks = new ArrayList<Bank>();
	// Constructors

	/** default constructor */
	public Stakeholder() {
	}
	public Stakeholder(String userId, String fullname,
			String status, String type) {
		super(userId, fullname, status, type);
	}
	/** minimal constructor */
	public Stakeholder(String userId, String mnemonicchars, String shortname, String fullname,
			String status, String type) {
		super(userId, mnemonicchars, shortname, fullname, status, type);
	}

	/** full constructor */
	public Stakeholder(String userId, String userPassword, String mnemonicchars, String shortname, String fullname,
			String province, String city, String county, String phone,
			String tax, String url, String remarks, String status, String type,
			String taxaccounts) {
		super(userId, userPassword, mnemonicchars, shortname, fullname, province, city, county,
				phone, tax, url, remarks, status, type, taxaccounts);
	}

	public List<Person> getConatctMans() {
		return conatctMans;
	}

	public void setConatctMans(List<Person> conatctMans) {
		this.conatctMans = conatctMans;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Bank> getBanks() {
		return banks;
	}

	public void setBanks(List<Bank> banks) {
		this.banks = banks;
	}

}
