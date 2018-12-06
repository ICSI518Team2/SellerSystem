/* ICSI518 Team2 project - Student Mart Website
 * Description:
 * Item entity for Seller System and Buyer part.
 * This table will be updated by the seller and in the main page the buyer
 * could check the search the items from this table.
 * Author: Yunwei Jiang
 * */
package com.fusemachine.inventory.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String sellerId;
	private String category;
	private String cost_price;
	private String itemName;
	private Integer quantity;
	private String selling_price;
	private Boolean status;
	private String description;
	private String image_path;
	
	public Item() {
		//this.image_path = "D:\\";
		super();
	}


	public Item( String seller_id,String category,String cost_price,String item_name, 
			Integer quantity,String selling_price, 
			 Boolean status,String description,String image_path) {
		super();
		//this.id = id;
		this.sellerId = seller_id;
		this.itemName = item_name;
		this.category = category;
		this.cost_price = cost_price;
		this.selling_price = selling_price;
		this.quantity = quantity;
		this.status = status;
		this.image_path = image_path;
		this.description = description;
	}

	@Column(name="id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="seller_id", length = 45)
	public String getSeller_id() {
		return sellerId;
	}

	public void setSeller_id(String seller_id) {
		this.sellerId = seller_id;
	}
	
	
	@Column(name="category")
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	@Column(name="cost_price")
	public String getCost_price() {
		return cost_price;
	}

	public void setCost_price(String cost_price) {
		this.cost_price = cost_price;
	}
	
	@Column(name="item_name")
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	@Column(name="quantity")
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	@Column(name="selling_price")
	public String getSelling_price() {
		return selling_price;
	}

	public void setSelling_price(String selling_price) {
		this.selling_price = selling_price;
	}
	
	@Column(name="status")
	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	@Column(name="description",length = 2000)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name="image_path")
	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}
	
	
}
