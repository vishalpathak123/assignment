package com.verint.assignment.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.verint.assignment.entity.Item;

@Repository
public class ItemRepository {

	private List<Item> itemList = new ArrayList<>();

	private List<Item> itemList() {
		if (itemList.isEmpty()) {

			for (int i = 1; i <= 10; i++) {
				Item item = new Item(i, "ImageUrl" + i, "ItemName" + i, "ItemDescription" + i, 20.0 * i, 10.0);
				itemList.add(item);
			}
		}
		return itemList;
	}

	public List<Item> getItems() {
		return itemList();
	}

	public Item save(Item i) {
		Item item = new Item();
		item.setItemId(i.getItemId());
		item.setDescription(i.getDescription());
		item.setDiscountPercentage(i.getDiscountPercentage());
		item.setName(i.getName());
		item.setPrice(i.getPrice());
		item.setImageUrl(i.getImageUrl());
		itemList.add(item);
		return item;
	}

	public Item findItemById(int itemId) {
		// TODO Auto-generated method stub
		return itemList().stream().filter(i -> i.getItemId() == itemId).findFirst().get();
	}

}
