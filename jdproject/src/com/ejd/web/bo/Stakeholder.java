package com.ejd.web.bo;

import java.util.HashSet;
import java.util.Set;

/**
 * Stakeholder entity.
 * 
 * @author MyEclipse Persistence Tools
 */
public class Stakeholder extends AbstractStakeholder implements
		java.io.Serializable {
	
	Set<Person> conatctMans = new HashSet<Person>();
	Set<Address> addresses = new HashSet<Address>();
	Set<Bank> banks = new HashSet<Bank>();
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
	public Stakeholder(String userId, String mnemonicchars, String shortname, String fullname,
			String province, String city, String county, String phone,
			String tax, String url, String remarks, String status, String type,
			String taxaccounts) {
		super(userId, mnemonicchars, shortname, fullname, province, city, county,
				phone, tax, url, remarks, status, type, taxaccounts);
	}

	public Set<Person> getConatctMans() {
		return conatctMans;
	}

	public void setConatctMans(Set<Person> conatctMans) {
		this.conatctMans = conatctMans;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public Set<Bank> getBanks() {
		return banks;
	}

	public void setBanks(Set<Bank> banks) {
		this.banks = banks;
	}

}
