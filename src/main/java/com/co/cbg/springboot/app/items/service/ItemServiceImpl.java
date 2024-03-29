package com.co.cbg.springboot.app.items.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.co.cbg.springboot.app.items.models.Item;
import com.co.cbg.springboot.app.items.models.Producto;

@Service
public class ItemServiceImpl implements IItemService{

	/*
	 * Se puede anotar con Autowired porque está registrado como un Bean en AppConfig
	 * */
	@Autowired
	private RestTemplate clienteRestProducto;
	
	@Override
	public List<Item> findAll() {		
		
		List<Producto> productos = Arrays.asList(clienteRestProducto.getForObject("http://localhost:8001/listar", Producto[].class));
		return productos.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());
		Producto producto = clienteRestProducto.getForObject("http://localhost:8001/ver/{id}", Producto.class, pathVariables);
		return new Item(producto, cantidad);
	}

}