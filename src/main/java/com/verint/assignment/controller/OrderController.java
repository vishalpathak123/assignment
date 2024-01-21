package com.verint.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verint.assignment.entity.OrderDetails;
import com.verint.assignment.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	private final OrderService orderService;

	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	// Endpoint for retrieving order details by OrderId
	@GetMapping("/{orderId}")
	public ResponseEntity<?> getOrderDetails(@PathVariable String orderId) {

		OrderDetails orderDetails = orderService.getOrderDetails(orderId);

		if (orderDetails != null) {
			return ResponseEntity.ok(orderDetails);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	public ResponseEntity<?> getOrderDetails() {

		List<OrderDetails> orders = orderService.getOrders();

		return ResponseEntity.ok(orders);

	}
}
