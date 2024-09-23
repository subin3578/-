package com.ch07.shop;

import com.ch07.entity.board.Article;
import com.ch07.entity.board.Comment;
import com.ch07.entity.board.File;
import com.ch07.entity.board.User;
import com.ch07.entity.shop.Customer;
import com.ch07.entity.shop.Order;
import com.ch07.entity.shop.OrderItem;
import com.ch07.entity.shop.Product;
import com.ch07.repository.board.UserRepository;
import com.ch07.repository.shop.CustomerRepository;
import com.ch07.repository.shop.OrderItemRepository;
import com.ch07.repository.shop.OrderRepository;
import com.ch07.repository.shop.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@SpringBootTest
public class ShopRepositoryTest {

    @Autowired private OrderItemRepository orderItemRepository;
    @Autowired private OrderRepository orderRepository;
    @Autowired private CustomerRepository customerRepository;
    @Autowired private ProductRepository productRepository;

    // 등록
    // 테스트 1 -  Customer 등록
    @Test
    void insertCustomerTest() {

        Customer customer = Customer.builder()
                .custId("A102")
                .name("황수빈")
                .hp("010-7334-2080")
                .addr("부산시 동래구")
                .age(24)
                .build();
        customerRepository.save(customer);
    }

    // 테스트 2 - product 등록
    @Test
    void insertProductTest() {
        Product product = Product.builder()
                .prodName("새우깡")
                .price(1200)
                .stock(10000)
                .company("농심")
                .build();
        productRepository.save(product);
    }

    // 테스트 3 - order 등록
    @Test
    void insertOrderTest() {
        Customer customer = Customer.builder()
                .custId("A103")
                .build();

        Order order = Order.builder()
                .customer(customer)
                .orderPrice(2400)
                .orderStatus(1)
                .build();

        orderRepository.save(order);
    }

    // 테스트 3 - order item등록
    @Test
    void insertOrderItemTest() {

        Product product = Product.builder()
                .prodNO(1)
                .build();
        Order order = Order.builder()
                .orderNo(4)
                .build();


        OrderItem orderItem = OrderItem.builder()
                .order(order)
                .product(product)
                .count(4)
                .build();

        orderItemRepository.save(orderItem);
    }

    // 조회
    @Test
    void selectCustomerTest() {
        List<Customer> customers = customerRepository.findAll();
        for(Customer customer : customers){
            System.out.println(customer);
        }
    }
    @Test
    void selectProductsTest() {
        List<Product> products = productRepository.findAll();
        for(Product product : products){
            System.out.println(product);
        }
    }
    @Transactional
    @Test
    void selectOrdersTest() {
        List<Order> orders = orderRepository.findAll();
        for(Order order : orders){
            System.out.println(order);
        }
    }
    @Transactional
    @Test
    void selectOrderItemsTest() {
        List<OrderItem> orderItems = orderItemRepository.findAll();
        for(OrderItem orderItem : orderItems){
            System.out.println(orderItem);
        }
    }
}
