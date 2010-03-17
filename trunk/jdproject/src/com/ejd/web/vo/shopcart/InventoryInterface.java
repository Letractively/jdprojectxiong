package com.ejd.web.vo.shopcart;

import java.util.ArrayList;

/**
 * Simple interface to describe an inventory model. Not really need for this
 * example but it fun to play with generics.
 *
 * @since 1.7
 */
public interface InventoryInterface {
    public ArrayList<InventoryItem> getInventory();
    public double getInventoryPriceTotal();
    public void addInventoryItem(InventoryItem newItem);
    public void removeInventoryItem(InventoryItem newItem, boolean removeItemOnZero);
    public void recalculateIventory();
}

