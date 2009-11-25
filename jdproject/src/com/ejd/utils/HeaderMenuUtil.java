package com.ejd.utils;

import java.util.List;

import com.ejd.web.vo.richfaces.header.MenuItem;

public final class HeaderMenuUtil {
	
	public static MenuItem getMenuItemByName(String name, List<MenuItem> items) {//name items must need
		MenuItem result = new MenuItem();
		for (MenuItem tempItem:items) {
			if (name.equals(tempItem.getName())) {
				result = tempItem;
				break;
			}
		}
		return result;
	}

}
