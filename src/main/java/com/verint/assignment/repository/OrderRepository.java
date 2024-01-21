package com.verint.assignment.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.verint.assignment.entity.OrderDetails;

@Repository
public class OrderRepository {

	private List<OrderDetails> orderList = new ArrayList<>();

	private List<OrderDetails> orderList() {
		if (orderList.isEmpty()) {

			for (int i = 1; i <= 10; i++) {
				OrderDetails order = new OrderDetails();
				order.setOrderId("order" + i);
				order.setAddress("Address" + i);
				order.setCreditCardNumber("number" + i);
				order.setDescription("Desc " + i);
				order.setItemId(i);
				order.setFullName("Name " + i);
				order.setPrice(i*100);
				order.setDiscountPercentage(10);
				order.setEmail("order"+i+"@gmail.com");
				orderList.add(order);
			}
		}
		return orderList;
	}

	public OrderDetails save(OrderDetails o) {
		OrderDetails order = new OrderDetails();
		order.setItemId(o.getItemId());
		order.setDescription(o.getDescription());
		order.setDiscountPercentage(o.getDiscountPercentage());
		order.setFullName(o.getFullName());
		order.setPrice(o.getPrice());
		order.setAddress(o.getAddress());
		order.setCreditCardNumber(o.getCreditCardNumber());
		order.setPhoneNumber(o.getPhoneNumber());
		order.setOrderId(o.getOrderId());
		order.setEmail(o.getEmail());
		orderList.add(order);
		return order;
	}

	public OrderDetails findByOrderId(String orderId) {
		// TODO Auto-generated method stub
		return orderList().stream().filter(o -> o.getOrderId().equals(orderId)).findFirst().get();
	}

	public List<OrderDetails> getAllOrders() {
		// TODO Auto-generated method stub
		return orderList();
	}

}
