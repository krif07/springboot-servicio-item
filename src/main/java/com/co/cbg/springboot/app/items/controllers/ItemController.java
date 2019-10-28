package com.co.cbg.springboot.app.items.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.co.cbg.springboot.app.items.models.Item;
import com.co.cbg.springboot.app.items.service.IItemService;

@RestController
public class ItemController {
	
	@Autowired
	private IItemService itemService;
	
	@GetMapping(value = "/listar")
	public List<Item> listar(){
		return itemService.findAll();
	}
	
	@GetMapping(value = "/ver/{id}/cantidad/{cantidad}")
	public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
		return itemService.findById(id, cantidad);
	}
}
