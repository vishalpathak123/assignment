package com.verint.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verint.assignment.dto.CheckoutDTO;
import com.verint.assignment.entity.Item;
import com.verint.assignment.entity.OrderDetails;

@Service
public class CheckoutService {
	@Autowired
	private ItemService itemService;

	@Autowired
	private OrderService orderService;
	
	public String saveOrder(CheckoutDTO c) {
		// TODO Auto-generated method stub

		OrderDetails order = new OrderDetails();
		String orderId = generateOrderId();
		order.setOrderId(orderId);
		order.setItemId(c.getItemId());
		order.setFullName(c.getFullName());
		order.setAddress(c.getAddress());
		order.setCreditCardNumber(c.getCreditCardNumber());
		order.setPhoneNumber(c.getPhoneNumber());
		order.setEmail(c.getEmail());
		Item item = itemService.findItemById(c.getItemId());
		order.setPrice(item.getPrice());
		order.setDescription(item.getDescription());
		order.setDiscountPercentage(item.getDiscountPercentage());
		orderService.save(order);
		return orderId;
	}

	private String generateOrderId() {
		return java.util.UUID.randomUUID().toString();
	}

}
