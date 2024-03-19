package com.restaurentservice1.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurentservice1.model.Category;
import com.restaurentservice1.model.MenuItem;

@Repository
public interface menuItemrepo extends JpaRepository<MenuItem, Integer>{
	List<MenuItem> findByRestaurant_RestaurantId(Integer restaurantId);

	List<MenuItem> findByCategory(Category category);
}