package com.parkgw.apis.model;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_Id;

    @Column(length = 80, nullable = false)
    private String name;

    @Column
    private String description;

    @Column
    private int listPrice;

    @Column
    private int price;


    @Builder
    public Product(String name, String description, int listPrice, int price) {
        this.name = name;
        this.description = description;
        this.listPrice = listPrice;
        this.price = price;
    }
    public Product() {

    }

    @Override
    public String toString() {
        return String.format(
                "Product[product_Id=%d, name='%s', description='%s', listPrice=%d, price=%d]",
                this.product_Id, this.name, this.description, this.listPrice, this.price
        );
    }
}
