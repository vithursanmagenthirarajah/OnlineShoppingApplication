package com.DeliveryService.Delivery.Controller;


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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DeliveryService.Delivery.Controller.ResourceNotFoundException;
import com.DeliveryService.Delivery.Controller.DeliveryDetail;


@RestController
@RequestMapping(value = "/API/SpringBoot")
@CrossOrigin("*")
public class DeliveryController {
	
	@Autowired
	private DeliveryRepository DeliveryRepository;
	
	@GetMapping("/GetDetails")
	public List<DeliveryDetail> getAllItems(){
		return DeliveryRepository.findAll();
	}		
	

	@DeleteMapping("/GetDetails/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteDelivery(@PathVariable Long id){
		
		DeliveryDetail Detail = DeliveryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Item not exist with id :" + id));
		
		DeliveryRepository.delete(Detail);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
		@PostMapping("/Delivery")
		public String createDeliveryDetail(@RequestBody DeliveryDetail DeliveryDetail) {
			DeliveryRepository.save(DeliveryDetail);
			return "success";
		}
		
}
