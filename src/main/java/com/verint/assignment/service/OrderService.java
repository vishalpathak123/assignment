package com.verint.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verint.assignment.entity.OrderDetails;
import com.verint.assignment.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;

	public OrderDetails getOrderDetails(String orderId) {
		// TODO Auto-generated method stub
		return orderRepository.findByOrderId(orderId);
	}

	public void save(OrderDetails order) {
		orderRepository.save(order);
	}

	public List<OrderDetails> getOrders() {
		// TODO Auto-generated method stub
		return orderRepository.getAllOrders();
	}

}
