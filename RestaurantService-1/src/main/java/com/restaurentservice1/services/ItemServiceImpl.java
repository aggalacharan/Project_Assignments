package com.restaurentservice1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurentservice.exceptions.ItemException;
import com.restaurentservice1.model.Category;
import com.restaurentservice1.model.Restaurant;
import com.restaurentservice1.model.MenuItem;
import com.restaurentservice1.repo.menuItemrepo;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	menuItemrepo itemDAO;
	@Autowired
	RestaurantService restservice;

	
	
	@Override
	public MenuItem addItem(MenuItem item) throws ItemException {
		Optional<MenuItem> opt = itemDAO.findById(item.getItemId());
		if(opt.isPresent()) {
			throw new ItemException("Item already exists..");
		}else {
			return itemDAO.save(item);
		}
	}



	@Override
	public MenuItem updateItem(MenuItem item) throws ItemException {
		Optional<MenuItem> opt = itemDAO.findById(item.getItemId());
		if(opt.isPresent()) {
			return itemDAO.save(item);
		}else {
			throw new ItemException("No such Item found..");
		}
	}



	@Override
	public MenuItem viewItem(Integer itemId) throws ItemException {
		Optional<MenuItem> opt = itemDAO.findById(itemId);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			throw new ItemException("No Item found with ID: "+itemId);
		}
	}



	@Override
	public MenuItem removeItem(Integer itemId) throws ItemException {
		Optional<MenuItem> opt = itemDAO.findById(itemId);
		if(opt.isPresent()) {
			MenuItem item = opt.get();
			itemDAO.delete(item);
			return item;
		}else {
			throw new ItemException("No Item found with ID: "+itemId);
		}
	}



	@Override
	public List<MenuItem> viewAllItems() throws ItemException {
		List<MenuItem> items = itemDAO.findAll();
		if(items.size() > 0) {
			return items;
		}else {
			throw new ItemException("No Item exists..");
		}
	}
	
	//modified code

    // Method to add a menuItem to a specific Restaurant
	@Override
    public MenuItem addItemToRestaurant(MenuItem item, Integer restaurantId) throws ItemException {
        // Retrieve the Restaurant using restaurantId
        Restaurant restaurant = restservice.findRestaurantById(restaurantId);
        if (restaurant == null) {
            throw new ItemException("Restaurant with ID " + restaurantId + " not found");
        }
        item.setRestaurant(restaurant);
        return itemDAO.save(item);
    }

    // Method to get menuItems based on restaurantId
	@Override
    public List<MenuItem> getMenuItemsByRestaurantId(Integer restaurantId) {
        return itemDAO.findByRestaurant_RestaurantId(restaurantId);
    }



	@Override
	public List<MenuItem> getMenuItemsByCategory(Category category) {
		return itemDAO.findByCategory(category);
	}
	

}
