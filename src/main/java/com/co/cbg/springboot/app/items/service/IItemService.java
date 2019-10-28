package com.co.cbg.springboot.app.items.service;

import java.util.List;

import com.co.cbg.springboot.app.items.models.Item;

public interface IItemService {
	
	public List<Item> findAll();
	public Item findById(Long id, Integer cantidad);

}
