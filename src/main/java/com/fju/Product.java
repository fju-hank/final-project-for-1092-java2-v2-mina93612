package com.fju;

public class Product {
    int id;
    String name;
    int price;

    public Product(int id,String name, int price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "PRODUCT:" + id +"/"+ name +"/"+ price;
    }
}