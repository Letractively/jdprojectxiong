package com.ejd.web.vo.richfaces.header;

public class MenuItem {
	private String idFirst;
	private String idSecond;
	private String name;
	private String description;
	
	public String getIdFirst() {
		return idFirst;
	}
	public void setIdFirst(String idFirst) {
		this.idFirst = idFirst;
	}
	public String getIdSecond() {
		return idSecond;
	}
	public void setIdSecond(String idSecond) {
		this.idSecond = idSecond;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public MenuItem() {
		super();
	}
	public MenuItem(String idFirst, String idSecond, String name,
			String description) {
		super();
		this.idFirst = idFirst;
		this.idSecond = idSecond;
		this.name = name;
		this.description = description;
	}
	
}
