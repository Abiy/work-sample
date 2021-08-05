package com.play.fair;

import com.play.fair.data.Product;
import com.play.fair.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class PlayFairApplication {

	private static final Logger log = LoggerFactory.getLogger(PlayFairApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PlayFairApplication.class, args);
	}


	@Bean
	public CommandLineRunner demo(ProductRepository repository) {
		return (args) -> {

			Product product = new Product();
			product.setProductName("Lebron");
			product.setProductDescription("Kick ass Lebron 2021 Collectable");
			product.setCreatedOn(LocalDateTime.now());
			product.setUpdatedOn(LocalDateTime.now());
			product.setCreatedBy("Mele");
			product.setUpdatedBy("Mele");

			Product product2 = new Product();
			product2.setProductName("Kwhi");
			product2.setProductDescription("Kick ass Kwhi 2021 Collectable");
			product2.setCreatedOn(LocalDateTime.now());
			product2.setUpdatedOn(LocalDateTime.now());
			product2.setCreatedBy("Abiy");
			product2.setUpdatedBy("Abiy");
			product2.setProductImage("http://leanord.com/photo123.png");
			//product.setProductId(1L);

			// save a few customers
			repository.save(product);
			repository.save(product2);


			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Product customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Product customer = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByProductName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			log.info("");
		};
	}

}
