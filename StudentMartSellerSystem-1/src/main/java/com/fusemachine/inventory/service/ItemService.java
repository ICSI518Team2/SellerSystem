package com.fusemachine.inventory.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.fusemachine.inventory.domain.Item;
//import com.fusemachine.inventory.domain.Product;

public interface ItemService {
	List<Item> findAll();
	public Page<Item> findAllItems(Integer page, Integer size);
	public Page<Item> getSearchItems(String name, Integer page, Integer size);
    Item findById(Integer id);
    Item insert(Item item);
    Item edit(Item item);
    void deleteById(Integer id);	
}
