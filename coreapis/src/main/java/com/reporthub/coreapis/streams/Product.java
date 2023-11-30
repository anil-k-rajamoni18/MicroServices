package com.reporthub.coreapis.streams;


import lombok.Builder;


@Builder
public class Product {
    private String name;
    private Double price;
    private Integer availableQuality;
    private boolean outOfStock;
}
