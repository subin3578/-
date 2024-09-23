package com.ch07.shop;

import com.ch07.dto.CustomerDTO;
import com.ch07.dto.ProductAggDTO;
import com.ch07.entity.shop.*;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.apache.catalina.util.CustomObjectInputStream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// 확장해서 Test하는 방법과 다르게 직접 해보기
@SpringBootTest
public class ShopQueryDslTest {
    @Autowired
    private JPAQueryFactory queryFactory;

    // 주입할 필요 없음 싱글톤으로 정의 되어 있음
    private QCustomer qCustomer =QCustomer.customer;
    private QProduct qProduct =QProduct.product;
    private QOrder qOrder =QOrder.order;
    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Test // selectProducts
    void test01() {
        List<Product> products = jpaQueryFactory
                .selectFrom(qProduct)
                .fetch();
        System.out.println("-----------------products---------------");
        for(Product product : products) {
            System.out.println(product);
        }
    }

    @Test // select Projections.fields
    void test02() {
         List<Product> products = jpaQueryFactory
                .select(
                        Projections.fields(
                                Product.class,
                                qProduct.prodNO,
                                qProduct.prodName,
                                qProduct.price
                        )
                )
                .from(qCustomer)
                .fetch();
        System.out.println(products);
    }
    @Test // where eq , ne
    void test03() {
        List<Customer> Customers1 = jpaQueryFactory.selectFrom(qCustomer).where(qCustomer.name.eq("황수빈")).fetch();
        List<Customer> Customers2 = jpaQueryFactory.selectFrom(qCustomer).where(qCustomer.name.ne("황수빈")).fetch();

        System.out.println("Customers1:"+Customers1);
        System.out.println("Customers2:"+Customers2);
    }
    @Test // where gt, goe
    void test04() {
        List<Customer> customers1 =
                jpaQueryFactory.selectFrom(qCustomer).where(qCustomer.age.gt(30)).fetch();
        List<Customer> customers2 = jpaQueryFactory.selectFrom(qCustomer).where(qCustomer.age.eq(30)).fetch();
        List<Customer> customers3 = jpaQueryFactory.selectFrom(qCustomer).where(qCustomer.age.ne(30)).fetch();
        List<Customer> customers4 = jpaQueryFactory.selectFrom(qCustomer).where(qCustomer.age.goe(30)).fetch();

        System.out.println("customers1 = " + customers1);
        System.out.println("customers2 = " + customers2);
        System.out.println("customers3 = " + customers3);
        System.out.println("customers4 = " + customers4);

    }
    @Test // Where 'in'
    void test05() {
        List<Customer> customers = jpaQueryFactory
                .selectFrom(qCustomer)
                .where(qCustomer.addr.in("서울","김해"))
                .fetch();
        System.out.println("customers = " + customers);
    }
    @Test// Where 'like'
    void test06() {
        List<Customer> customers = jpaQueryFactory
                .selectFrom(qCustomer)
                .where(qCustomer.name.like("%빈"))
                .fetch();

        System.out.println("customers = " + customers);
    }

    @Test // orderBy
    void test07() {
        List<Product> products = jpaQueryFactory
                .selectFrom(qProduct)
                .where(qProduct.stock.gt(0))
                .orderBy(qProduct.price.desc())
                .fetch();

        System.out.println("customers = " + products);
    }
    @Test // orderBy - offset limit
    void test08() {
        List<Product> products = jpaQueryFactory
                .selectFrom(qProduct)
                .where(qProduct.stock.gt(0))
                .orderBy(qProduct.price.asc())
                .offset(0)
                .limit(3)
                .fetch();

        System.out.println("products = " + products);
    }
    @Test // 짐계함수 - sum, avg, max, min 
    void test09() {
        ProductAggDTO product = jpaQueryFactory
                .select(
                        Projections.fields(
                                ProductAggDTO.class,
                                qProduct.price.sum().as("priceSum"),
                                qProduct.price.avg().as("priceAvg"),
                                qProduct.price.max().as("priceMax"),
                                qProduct.price.min().as("priceMin")
                        )
                )
                .from(qProduct)
                .fetchOne();

        System.out.println("product = " + product);

    }
    @Test // groupBy having
    void test10() {
        List<CustomerDTO> customerDTOs = jpaQueryFactory
                .select(
                        Projections.fields(
                                CustomerDTO.class,
                                qOrder.customer.custId,
                                qOrder.customer.name,
                                qOrder.customer.custId.count().as("orderCount")
                        )
                )
                .from(qOrder)
                .where(qOrder.orderStatus.eq(1))
                .groupBy(qOrder.customer.custId)
                .having(qOrder.customer.custId.count().goe(2))
                .fetch();

        System.out.println("customerDTOs = " + customerDTOs);

    }

    @Transactional
    @Test // Join on
    void test11() {

        List<Tuple> result = jpaQueryFactory
                .select(qOrder, qCustomer)
                .from(qOrder)
                .join(qCustomer)
                .on(qOrder.customer.eq(qCustomer))
                .fetch();

        System.out.println("result = " + result);

    }
    @Test
    void test12() {

    }
    @Test
    void test13() {

    }

}
