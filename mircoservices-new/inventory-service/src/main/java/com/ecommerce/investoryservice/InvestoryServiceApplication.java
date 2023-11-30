package com.ecommerce.investoryservice;

import com.ecommerce.investoryservice.model.Inventory;
import com.ecommerce.investoryservice.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class InvestoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvestoryServiceApplication.class, args);
	}




	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setSkuCode("iphone_air");
			inventory.setQuantity(10);

			Inventory inventory1 = new Inventory();
			inventory1.setSkuCode("iphone_12");
			inventory1.setQuantity(50);

			List<Inventory> inventoryList = new ArrayList<>();
			inventoryList.add(inventory);inventoryList.add(inventory1);

			inventoryRepository.saveAll(inventoryList);
		};
	}
}
