package com.ejd.web.vo.shopcart;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ejd.utils.HeaderMenuUtil;
import com.ejd.web.vo.richfaces.header.MenuItem;

public class Inventory implements InventoryInterface {

	private ArrayList<InventoryItem> inventory;
    // total value of inventory
    private Double inventoryPriceTotal = 0.0;
    private Integer inventoryQuantityTotal = 0;
    private boolean haveSelected;
    private Map<String,InventoryCategory> categoryInfo;
    
    public Inventory() {
        inventory = new ArrayList();
    }
	public void addInventoryItem(InventoryItem newItem) {
		boolean found = false;
        // if iventory item exist increment quantity count. 
        InventoryItem item;
        for(int i= 0, max= inventory.size(); i < max; i++){
            item = (InventoryItem)inventory.get(i);
            if (item.getCode().equals(newItem.getCode())) {
                item.incrementQuantity();
                found = true;
                break;
            }
        }

        // add item if not found in inventory.
        if (!found) {
            inventory.add(newItem);
            newItem.incrementQuantity();
        }

        // update invenory
        recalculateIventory();

	}
	public boolean addOnlyOneInventoryItem(InventoryItem newItem) {
		boolean found = false;
        // if iventory item exist increment quantity count. 
        InventoryItem item;
        for(int i= 0, max= inventory.size(); i < max; i++){
            item = (InventoryItem)inventory.get(i);
            if (item.getCode().equals(newItem.getCode())) {
                found = true;
                break;
            }
        }

        // add item if not found in inventory.
        if (!found) {
            inventory.add(newItem);
            newItem.incrementQuantity();
        }

        // update invenory
        recalculateIventory();
        return found;

	}

	public ArrayList<InventoryItem> getInventory() {
		// TODO Auto-generated method stub
		return inventory;
	}
	public void setInventory(ArrayList<InventoryItem> inventoryList){
		this.inventory=inventoryList;
	}

	public double getInventoryPriceTotal() {
		// TODO Auto-generated method stub
		return inventoryPriceTotal;
	}
	
	public void setInventoryPriceTotal(Double inventoryPriceTotal) {
		this.inventoryPriceTotal = inventoryPriceTotal;
	}
	public int getInventoryQuantityTotal() {
        return inventoryQuantityTotal;
    }
	
	public void setInventoryQuantityTotal(Integer inventoryQuantityTotal) {
		this.inventoryQuantityTotal = inventoryQuantityTotal;
	}
	
	public void setHaveSelected(boolean haveSelected) {
		this.haveSelected = haveSelected;
	}
	public boolean isHaveSelected() {
		boolean result = false;
		if (null != this.getInventory()) {
			for (InventoryItem tempInventoryItem:inventory) {
				if (tempInventoryItem.isSelected()) {
					result = true;
				}
				if (result) {
					break;
				}
			}
		}
		return result;
	}
	public Map<String, InventoryCategory> getCategoryInfo() {
		return categoryInfo;
	}
	public void setCategoryInfo(Map<String, InventoryCategory> categoryInfo) {
		this.categoryInfo = categoryInfo;
	}
	public void removeInventoryItem(InventoryItem newItem,boolean removeItemOnZero) {
		// TODO Auto-generated method stub
		InventoryItem foundItem = null;
        InventoryItem item;
        for(int i= 0, max= inventory.size(); i < max; i++){
            item = (InventoryItem)inventory.get(i);
            if (item.getCode().equals(newItem.getCode())) {
                item.decrementQuantity();
                foundItem = item;
                break;
            }
        }

        // remove the item if qauntity is less then zero and is allowd by
        // removeItemOnZero
        if (removeItemOnZero && foundItem != null && foundItem.getSalesQuantity() <= 0) {
            inventory.remove(foundItem);
        }

        // update invenory
        recalculateIventory();

	}
	private void recalculateIventory() {
        inventoryPriceTotal = 0.0;
        inventoryQuantityTotal = 0;
        categoryInfo = new HashMap<String,InventoryCategory>();
        InventoryItem item;
        for(int i= 0, max= inventory.size(); i < max; i++){
            item = (InventoryItem)inventory.get(i);
            inventoryPriceTotal += item.getSalesPrice() * item.getSalesQuantity();
            inventoryQuantityTotal += item.getSalesQuantity();
            InventoryCategory tempInventoryCategory =(InventoryCategory)this.getCategoryInfo().get(item.getPrimaryCategoryCode());
            if (null == tempInventoryCategory) {
            	InventoryCategoryItem tempPrimaryCategoryItem = new InventoryCategoryItem();
            	tempPrimaryCategoryItem.setIdFirst(item.getPrimaryCategoryCode());
            	tempPrimaryCategoryItem.setSalesQuantity(item.getSalesQuantity());
            	tempPrimaryCategoryItem.setSalesTotalAmount(item.getSubTotal());
            	InventoryCategoryItem tempSecondCategoryItem = new InventoryCategoryItem();
            	tempSecondCategoryItem.setIdFirst(item.getPrimaryCategoryCode());
            	tempSecondCategoryItem.setIdSecond(item.getSecondCategoryCode());
            	tempSecondCategoryItem.setSalesQuantity(item.getSalesQuantity());
            	tempSecondCategoryItem.setSalesTotalAmount(item.getSubTotal());
            	List<InventoryCategoryItem> tempsecondCategoryItem = new ArrayList<InventoryCategoryItem>();
            	tempsecondCategoryItem.add(tempSecondCategoryItem);
            	InventoryCategory curInventoryCategory = new InventoryCategory();
            	curInventoryCategory.setPrimaryCategory(tempPrimaryCategoryItem);
            	curInventoryCategory.setSecondCategory(tempsecondCategoryItem);
            	this.getCategoryInfo().put(item.getPrimaryCategoryCode(), curInventoryCategory);
            	
            } else {
            	Integer tempQuantity = tempInventoryCategory.getPrimaryCategory().getSalesQuantity() + item.getSalesQuantity();
            	Double tempAmount = tempInventoryCategory.getPrimaryCategory().getSalesTotalAmount() + item.getSubTotal();
            	tempInventoryCategory.getPrimaryCategory().setSalesQuantity(tempQuantity);
            	tempInventoryCategory.getPrimaryCategory().setSalesTotalAmount(tempAmount);
            	ArrayList<InventoryCategoryItem> tempSecondCategory =(ArrayList<InventoryCategoryItem>) tempInventoryCategory.getSecondCategory();
            	if (null !=tempSecondCategory && !tempSecondCategory.isEmpty()) {
            		boolean exist = false;
            		InventoryCategoryItem curLoopCategoryItem = null;
            		for (int j = 0; j < tempSecondCategory.size() ; j++) {
            			curLoopCategoryItem = tempSecondCategory.get(j);
            			if (curLoopCategoryItem.getIdFirst().equals(item.getPrimaryCategoryCode()) && curLoopCategoryItem.getIdSecond().equals(item.getSecondCategoryCode())) {
            				exist = true;
            				break;
            			}
            		}
            		if (exist) {
            			updateSecondCategoryItem(curLoopCategoryItem,item);
            			
            		}
            		if (!exist) {
            			addSecondCategoryItem(tempInventoryCategory.getSecondCategory(),item);
            		}
            		
            	} else {
            		addSecondCategoryItem(tempInventoryCategory.getSecondCategory(),item);
            	}
            }
        }
        if (null != this.getCategoryInfo()) {
        	Collection inventoryCategory = this.getCategoryInfo().values();
        	Iterator it = inventoryCategory.iterator();            
            while (it.hasNext()) {
            	InventoryCategory obj = (InventoryCategory)(it.next());
            	InventoryCategoryItem primaryCategory = obj.getPrimaryCategory();
            	MenuItem mainMenuItem = HeaderMenuUtil.getMainMenuItemByIdFirst(primaryCategory.getIdFirst());
            	primaryCategory.setName(mainMenuItem.getName());
            	primaryCategory.setLabel(mainMenuItem.getLabel());
            	List<InventoryCategoryItem> secondCategory = obj.getSecondCategory();
            	Iterator subit = secondCategory.iterator();            
                while (subit.hasNext()) {
                	InventoryCategoryItem subSecondCategoryItem =(InventoryCategoryItem) subit.next();
                	MenuItem subMenuItem = HeaderMenuUtil.getSubMenuEachByIdFirstAndIdSecond(subSecondCategoryItem.getIdFirst(), subSecondCategoryItem.getIdSecond());
                	subSecondCategoryItem.setName(subMenuItem.getName());
                	subSecondCategoryItem.setLabel(subMenuItem.getLabel());
                }
            }
        }
    }
	private void addSecondCategoryItem(List<InventoryCategoryItem> curSecondCategory,InventoryItem curCategoryItem) {
		InventoryCategoryItem newInventoryCategoryItem = new InventoryCategoryItem();
		newInventoryCategoryItem.setIdFirst(curCategoryItem.getPrimaryCategoryCode());
		newInventoryCategoryItem.setIdSecond(curCategoryItem.getSecondCategoryCode());
		newInventoryCategoryItem.setSalesQuantity(curCategoryItem.getSalesQuantity());
		newInventoryCategoryItem.setSalesTotalAmount(curCategoryItem.getSubTotal());
		curSecondCategory.add(newInventoryCategoryItem);
	}
	private void updateSecondCategoryItem(InventoryCategoryItem curSecondCategoryItem,InventoryItem curCategoryItem) {
		Integer tempQuantity = curSecondCategoryItem.getSalesQuantity() + curCategoryItem.getSalesQuantity();
    	Double tempAmount = curSecondCategoryItem.getSalesTotalAmount() + curCategoryItem.getSubTotal();
    	curSecondCategoryItem.setSalesQuantity(tempQuantity);
    	curSecondCategoryItem.setSalesTotalAmount(tempAmount);
		
	}

}
