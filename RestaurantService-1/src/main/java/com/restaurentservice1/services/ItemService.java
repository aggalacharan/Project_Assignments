package com.restaurentservice1.services;

import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import com.restaurentservice.exceptions.ItemException;
import com.restaurentservice1.model.Category;
import com.restaurentservice1.model.MenuItem;

public interface ItemService {
	
	public MenuItem addItem(MenuItem item)throws ItemException;
	
	public MenuItem updateItem(MenuItem item)throws ItemException;
	
	public MenuItem viewItem(Integer itemId)throws ItemException;
	
	public MenuItem removeItem(Integer itemId)throws ItemException;
	
	public List<MenuItem> viewAllItems()throws ItemException;

	public MenuItem addItemToRestaurant(MenuItem item, Integer restaurantId) throws ItemException;

	public List<MenuItem> getMenuItemsByRestaurantId(Integer restaurantId);
	public List<MenuItem> getMenuItemsByCategory(Category category);

	//menuItem addItem(menuItem item) throws com.restaurentservice1.services.ItemException;

	

}
