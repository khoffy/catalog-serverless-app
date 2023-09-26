package com.khoffylabs;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import com.khoffylabs.controller.PingController;
import com.khoffylabs.entities.Product;
import com.khoffylabs.repositories.ProductRepository;


@SpringBootApplication
// We use direct @Import instead of @ComponentScan to speed up cold starts
// @ComponentScan(basePackages = "com.khoffylabs.controller")
//@Import({ PingController.class })
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            productRepository.save(Product.builder()
                .id(UUID.randomUUID().toString())
                .name("Computer")
                .price(4300)
                .build());
        
            productRepository.save(Product.builder()
                .id(UUID.randomUUID().toString())
                .name("Printer")
                .price(1200)
                .build());
            
            productRepository.save(Product.builder()
                .id(UUID.randomUUID().toString())
                .name("Smart Phone")
                .price(800)
                .build());
        };
    }
}