package com.fusemachine.inventory.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fusemachine.inventory.domain.Item;
//import com.fusemachine.inventory.domain.Product;
import com.fusemachine.inventory.domain.Product;

public interface ItemRepository extends JpaRepository<Item,Integer> 
{
	//List<Item> findByItemName(String itemName);
	//public Page<Item> findByItemName(String itemName, Pageable pageable);
	//public Page<Item> findByItemNameLikeIgnoreCase(String itemName, Pageable pageable);
	//List<Item> findByProduct_name(String product_name);
	//public Page<Item> findByProduct_name(String product_name, Pageable pageable);
	//public Page<Item> findByProduct_nameLikeIgnoreCase(String product_name, Pageable pageable);
}
