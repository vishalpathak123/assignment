package com.verint.assignment.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verint.assignment.entity.Item;
import com.verint.assignment.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;

	public Item findItemById(int itemId) {
		// TODO Auto-generated method stub
		return itemRepository.findItemById(itemId);
	}
	
	public List<Item> getPage(int page, int pageSize) {
		List<Item> list = itemRepository.getItems();
	    if(pageSize <= 0 || page <= 0) {
	        throw new IllegalArgumentException("invalid page size: " + pageSize);
	    }
	    
	    int index = (page - 1) * pageSize;
	    if(list == null || list.size() <= index){
	        return Collections.emptyList();
	    }
	    
	    return list.subList(index, Math.min(index + pageSize, list.size()));
	}

	public List<Item> getItems() {
		// TODO Auto-generated method stub
		return itemRepository.getItems();
	}
}


