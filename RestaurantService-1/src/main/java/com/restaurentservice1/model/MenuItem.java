package com.restaurentservice1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter 
@Setter
@ToString
@Entity
public class MenuItem{	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private Long Id;
	private Integer itemId;
	@Column(unique = false) // allow dupilicate values
	private String itemName;
	private String Description;
	private Double cost;
	private String itemImage;
	private Category category;
    @ManyToOne
    @JoinColumn(name = "restaurant_id") // Specify the foreign key column
    @JsonIgnoreProperties("itemList")
    private Restaurant restaurant;
    public MenuItem() {
    }
	
	public MenuItem(
			//Long id,
		Integer itemId, String itemName, Integer quantity,String Description, Double cost, String itemImage,Category category,Restaurant restaurant ) {
		//this.Id=id;
		this.itemId = itemId;
		this.itemName = itemName;
		this.Description = Description;
		this.cost = cost;
		this.category=category;
		this.itemImage=itemImage;
		this.restaurant=restaurant;
	}
	
	
	
//	public Long getId() {
//		return Id;
//	}
//	public void setId(Long id) {
//		Id = id;
//	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public String getItemImage() {
		return itemImage;
	}
	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
}