package com.ch07.repository.shop.impl;

import com.ch07.entity.shop.Product;
import com.ch07.entity.shop.QProduct;
import com.ch07.repository.shop.custom.ProductRepositoryCustom;
import com.ch07.repository.shop.custom.ProductRepositoryCustom;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
//ProductRepository 확장 인터페이스
public class ProductRepositoryImpl implements ProductRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    private QProduct qProduct = QProduct.product;

    @Override
    public List<Product> selectProducts(){
        return queryFactory.select(qProduct)
             .from(qProduct).fetch();
    }

    @Override
    public Product selectProduct(int prodno) {
        return queryFactory
                .selectFrom(qProduct)
                .where(qProduct.prodNO.eq(prodno))
                .fetchOne();
    }

    @Override
    //prodNameCondition, int priceCondition
    public List<Product> searchProduct(String prodNameCondition, int priceCondition){
        // QueryDSL 동적 쿼리 Builder 생성
        BooleanBuilder builder = new BooleanBuilder();

        if(prodNameCondition != null){
            builder.and(qProduct.prodName.eq(prodNameCondition));
        }
        // int라서 0보다 크면으로 적음
        if(priceCondition > 0){
                builder.and(qProduct.price.goe(priceCondition)); //
        }
        return queryFactory
            .selectFrom(qProduct)
                .where(builder)
                .fetch();
    }

    @Override
    public List<Product> searchKeyword(String keyword){
        BooleanExpression express = qProduct
                .prodName.containsIgnoreCase(keyword)
                .or(qProduct.company.containsIgnoreCase(keyword));

        return queryFactory
                .selectFrom(qProduct)
                .where(express)
                .fetch();
    }
}
