package com.ejd.web.vo.image;

import java.io.Serializable;

public class ImageData implements Serializable {
	private String name;

	public ImageData(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
