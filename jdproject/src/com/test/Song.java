package com.test;


import java.util.ArrayList;
import java.util.Iterator;

import org.richfaces.model.TreeNode;

public class Song implements TreeNode {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7155620465939481885L;
	private long id;
	private String title;
	private String genre;
	private int trackNumber;
	private boolean checkIt=Boolean.FALSE;
	

	public Song(long id,String title,String genre,int num) {
		this.id=id;
		this.title=title;
		this.genre=genre;
		this.trackNumber=num;
		this.checkIt = Boolean.FALSE;
	}	
	
	public Song(long id) {
		this.id = id;
	}
	
	public void addChild(Object identifier, TreeNode child) {
		throw new UnsupportedOperationException("Songs do not have children");
	}

	public TreeNode getChild(Object id) {
		throw new UnsupportedOperationException("Songs do not have children");
	}

	public Iterator getChildren() {
		// TODO: Fix me!
		return new ArrayList().iterator(); // work around limitation for TreeNode
	}

	public Object getData() {
		return this;
	}

	public TreeNode getParent() {
		return null;
	}

	public boolean isLeaf() {
		return true;
	}

	public void removeChild(Object id) {
		throw new UnsupportedOperationException("Songs do not have children");
	}

	public void setData(Object data) {
	}

	public void setParent(TreeNode parent) {
		
	}


	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getTrackNumber() {
		return trackNumber;
	}

	public void setTrackNumber(int trackNumber) {
		this.trackNumber = trackNumber;
	}

	public long getId() {
		return id;
	}
	public String getType() {
		return "song";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + trackNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Song other = (Song) obj;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (trackNumber != other.trackNumber)
			return false;
		return true;
	}

	public boolean getCheckIt() {
		return checkIt;
	}

	public void setCheckIt(boolean checkIt) {
		this.checkIt = checkIt;
	}

}
