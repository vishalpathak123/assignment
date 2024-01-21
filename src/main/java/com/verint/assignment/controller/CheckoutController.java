package com.verint.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verint.assignment.dto.CheckoutDTO;
import com.verint.assignment.entity.Item;
import com.verint.assignment.service.CheckoutService;
import com.verint.assignment.service.ItemService;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

	private final ItemService itemService;

	private final CheckoutService checkoutService;

	@Autowired
	public CheckoutController(ItemService itemService, CheckoutService checkoutService) {
		this.checkoutService = checkoutService;
		this.itemService = itemService;
	}

	@PostMapping("/submit")
	public ResponseEntity<String> submitCheckoutForm(@Validated @RequestBody CheckoutDTO checkoutDTO) {
		Item item = itemService.findItemById(checkoutDTO.getItemId());
		if (item == null) {
			return ResponseEntity.badRequest().body("Invalid ItemId");
		}

		String orderId = checkoutService.saveOrder(checkoutDTO);

		return ResponseEntity.ok(orderId);
	}

}
