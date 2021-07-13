package com.springboot.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.project.exception.ResourceNotFoundException;
import com.springboot.project.model.Item;
import com.springboot.project.repository.ItemRepository;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/API/SpringBoot/")
public class ItemController {

	@Autowired
	private ItemRepository ItemRepository;
	
	// get all Items
	@GetMapping("/Items")
	public List<Item> getAllItems(){
		return ItemRepository.findAll();
	}		
	
	// create Item rest api
	@PostMapping("/Items")
	public Item createItem(@RequestBody Item Item) {
		return ItemRepository.save(Item);
	}
	
	// get Item by id rest api
	@GetMapping("/Items/{id}")
	public ResponseEntity<Item> getItemById(@PathVariable Long id) {
		Item Item = ItemRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Item not exist with id :" + id));
		return ResponseEntity.ok(Item);
	}
	
	// update Item rest api
	
	@PutMapping("/Items/{id}")
	public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item ItemDetails){
		Item Item = ItemRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Item not exist with id :" + id));
		
		Item.setItemName(ItemDetails.getItemName());
		Item.setQty(ItemDetails.getQty());
		Item.setPrice(ItemDetails.getPrice());
		Item.setDescription(ItemDetails.getDescription());
		
		Item updatedItem = ItemRepository.save(Item);
		return ResponseEntity.ok(updatedItem);
	}
	
	// delete Item rest api
	@DeleteMapping("/Items/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteItem(@PathVariable Long id){
		Item Item = ItemRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Item not exist with id :" + id));
		
		ItemRepository.delete(Item);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
