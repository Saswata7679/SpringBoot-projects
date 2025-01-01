package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod(){
        //create product
        Product product = new Product();
        product.setName("product 1");
        product.setDescription("Product 1 description");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("product1.png");

        //save product
        Product saveObject = productRepository.save(product);
        //display product info
        System.out.println(saveObject.getId());
        System.out.println(saveObject.toString());
    }

    @Test
    void  updateUsingSaveMethod(){
        //find or retrive an entity by id
        Long id = 1L;
        Product product =productRepository.findById(id).get();

        //Update info
        product.setName("updated product 1");
        product.setDescription("updated Product 1 description");
        productRepository.save(product);
    }

    @Test
    void  findByaidMethod(){
        //find or retrive an entity by id
        Long id = 1L;
        Product product =productRepository.findById(id).get();

        System.out.println(product.toString());

    }

    @Test
    void saveAllMethod(){
        //create product
        Product product2 = new Product();
        product2.setName("product 2");
        product2.setDescription("Product 2 description");
        product2.setSku("200ABC");
        product2.setPrice(new BigDecimal(100));
        product2.setActive(true);
        product2.setImageUrl("product2.png");

        //create product
        Product product3 = new Product();
        product3.setName("product 3");
        product3.setDescription("Product 3 description");
        product3.setSku("300ABC");
        product3.setPrice(new BigDecimal(100));
        product3.setActive(true);
        product3.setImageUrl("product3.png");

        productRepository.saveAll(List.of(product2,product3));
        
    }

}
