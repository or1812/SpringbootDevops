package com.devopsproject.myapp;

import lombok.Data;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;


@Data
public class Product {
    private static final Logger logger = Logger.getLogger("Product");
    private UUID uid; // default value = null
    private String name; // default value = null
    private double price; // default value = 0.0


    public Product(String productName, double productPrice){
        name = productName;
        price = productPrice;
        logger.log(Level.WARNING,"Created");
    }



    public static void main(String[] args) {
    /*
    primitive type values:
    byte
    short
    int
    long
    float
    double
    boolean
    char
     */
        int num = 10;;
        boolean condition = true;
        String name = "Alice";

        Product laptop = new Product("Laptop",1000);



    }
}
