package com.ejd.web.vo.richfaces.header;

import java.util.List;

public class Menu {
	MenuItem mainMenu;
	List<MenuItem> subMenu;
	public MenuItem getMainMenu() {
		return mainMenu;
	}
	public void setMainMenu(MenuItem mainMenu) {
		this.mainMenu = mainMenu;
	}
	public List<MenuItem> getSubMenu() {
		return subMenu;
	}
	public void setSubMenu(List<MenuItem> subMenu) {
		this.subMenu = subMenu;
	}
	public Menu() {
		super();
	}
	public Menu(MenuItem mainMenu, List<MenuItem> subMenu) {
		super();
		this.mainMenu = mainMenu;
		this.subMenu = subMenu;
	}

}
