package com.example.WebTask.Order;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.Assert.*;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class OrderServiceTest {
	
	@MockBean
	private ItemRepository repo;
	
	@InjectMocks
	private OrderService service;
	
	@Test
	public void testValidateItems() {
		List<String> list = new ArrayList<>();
		list.add("item4");
		list.add("item3");
		
		Item item4 = new Item(4L,"item4", false, 75);
		Item item3 = new Item(3L,"item3", false, 500);
		List<Item> itemList= new ArrayList<>();
		itemList.add(item4);
		itemList.add(item3);
		
		Mockito.when(repo.findByNames(list)).thenReturn(itemList);
		
		boolean result = service.validateItemsExistence(list);
		assertEquals(item4.isAvailable()&&item3.isAvailable(), result);
	}
	
	@Test
	public void testValidateTotalPrice() {
		List<String> list = new ArrayList<>();
		list.add("item4");
		list.add("item3");
		
		Item item4 = new Item(4L,"item4", false, 75);
		Item item3 = new Item(3L,"item3", false, 500);
		List<Item> itemList= new ArrayList<>();
		itemList.add(item4);
		itemList.add(item3);
		
		Mockito.when(repo.findByNames(list)).thenReturn(itemList);
		
		float result = service.validateTotalPrice(list);
		assertEquals(575, result,  0.05f);
	}
	
	// **Note: I tested the endpoint on the postman
}
