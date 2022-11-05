package fr.dovi.inventoryservice;

import fr.dovi.inventoryservice.entities.Product;
import fr.dovi.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(InventoryServiceApplication.class, args);
  }

  @Bean
  CommandLineRunner start(ProductRepository productRepository){
    return args -> {
      productRepository.save(new Product(null, "Ballons", 120.00, 15));
      productRepository.save(new Product(null, "Crampons", 200.00, 10));

      productRepository.findAll().forEach(p -> {
        System.out.println(p.toString());
      });
    };
  }

}
