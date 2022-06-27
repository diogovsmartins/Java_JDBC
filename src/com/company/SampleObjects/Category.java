package com.company.SampleObjects;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private int id;
    private String name;
    private List<Product> productList = new ArrayList<>();

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void add(Product product) {
        productList.add(product);
    }

    public List<Product> getProducts() {
        return productList;
    }
}
