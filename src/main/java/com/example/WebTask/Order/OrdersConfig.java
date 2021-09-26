package com.example.WebTask.Order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class OrdersConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(ItemRepository repository) {
		return args -> {
			Item item1 = new Item("item1", true, 1000);
			Item item2 = new Item("item2", true, 100);
			Item item3 = new Item("item3", false, 500);
			Item item4 = new Item("item4", false, 75);
			Item item5 = new Item("item5", true, 1000);
						
			List<Item> ItemList = new ArrayList<>();
			ItemList.add(item1);
			ItemList.add(item2);
			ItemList.add(item3);
			ItemList.add(item4);
			ItemList.add(item5);
			
			repository.saveAll(ItemList);
		};
	}

}
