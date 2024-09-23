package com.ch07.repository.shop.custom;

import com.ch07.entity.shop.Customer;
import com.ch07.entity.shop.Product;

import java.util.List;

public interface ProductRepositoryCustom {
    public List<Product> selectProducts();

    public Product selectProduct(int prodNo);

    public List<Product> searchProduct(String prodNameCondition, int priceCondition);

    public List<Product> searchKeyword(String keyword);
}
