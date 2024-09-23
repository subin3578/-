package com.ch07.shop;

import com.ch07.entity.shop.Product;
import com.ch07.repository.shop.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void selectProducts(){
        List<Product> products = productRepository.selectProducts();
        System.out.println("---------------------------products----------------------------");
        for(Product product : products){
            System.out.println(product);
        }
    }
    @Test
    public void selectProduct(){
        Product product = productRepository.selectProduct(2);
        System.out.println(product);
    }

    @Test
    public void searchProduct(){
        List<Product> Products1 = productRepository.searchProduct("새우깡",1200);
        List<Product> Products2 = productRepository.searchProduct("콘칩",2000);

        System.out.println("Products1:"+Products1);
        System.out.println("Products2:"+Products2);
    }
@Test
    public void searchKeyword(){
        List<Product> Products1 = productRepository.searchKeyword("초코파이");
        List<Product> Products2 = productRepository.searchKeyword("농심");

    System.out.println("Product1: "+Products1);
    System.out.println("Product2: "+Products2);
    }
}
