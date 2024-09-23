package com.ch07.shop;

import com.ch07.entity.shop.Customer;
import com.ch07.repository.shop.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void selectCustomers() {
        List<Customer> customers = customerRepository.selectCustomers();
        System.out.println(customers);
    }

    @Test
    public void selectCustomer() {
        Customer customer = customerRepository.selectCustomer("a101");
        System.out.println(customer);
    }

    @Test
    public void searchCustomer() {
        List<Customer> customers1 = customerRepository.searchCustomer("황수빈", 24);
        List<Customer> customers2 = customerRepository.searchCustomer("황수빈", 26);

        System.out.println("customers1:" + customers1);
        System.out.println("customers2:" + customers2);
    }

    @Test
    public void searchKeyword() {
        List<Customer> customers1 = customerRepository.searchKeyword("황수빈");
        List<Customer> customers2 = customerRepository.searchKeyword("동래");

        System.out.println(customers1);
        System.out.println(customers2);
    }

    @Test
    public void selectProjectionCustomer() {
        List<Customer> customer = customerRepository.selectProjectionCustomer();
        System.out.println(customer);
    }
}