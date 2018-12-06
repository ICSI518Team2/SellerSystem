package com.fusemachine.inventory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fusemachine.inventory.domain.Item;
//import com.fusemachine.inventory.domain.Product;
import com.fusemachine.inventory.repository.ItemRepository;
//import com.fusemachine.inventory.repository.ProductRepository;
import com.fusemachine.inventory.service.ItemService;

@Service
@Primary
public class ItemServiceJpaImpl implements ItemService{
	@Autowired
	ItemRepository itemrepository;
	@Override
	public List<Item> findAll() {
		// TODO Auto-generated method stub
		
		
		return this.itemrepository.findAll();
	}

	@Override
	public Item findById(Integer id) {
		// TODO Auto-generated method stub
		return this.itemrepository.findById(id).get();
	}

	@Override
	public Item insert(Item item) {
		// TODO Auto-generated method stub
		
		return this.itemrepository.save(item);

	}

	@Override
	public Item edit(Item item) {
		
		return this.itemrepository.save(item);
		}



	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		this.itemrepository.deleteById(id);;
	}

	@Override
	public Page<Item> findAllItems(Integer page, Integer size) {
		// TODO Auto-generated method stub
		Pageable pageable = new PageRequest(page, size);
		return this.itemrepository.findAll(pageable);

	}

	@Override
	public Page<Item> getSearchItems(String name, Integer page,
			Integer size) {
		// TODO Auto-generated method stub
		Pageable pageable = new PageRequest(page, size);
		return this.itemrepository.findByItemNameLikeIgnoreCase(name, pageable);

	}
	
	@Override
	public Page<Item> getSearchItemsBySellerID(String sellerId, Integer page,
			Integer size) {
		// TODO Auto-generated method stub
		Pageable pageable = new PageRequest(page, size);
		return this.itemrepository.findBySellerIdLikeIgnoreCase(sellerId, pageable);

	}

}
