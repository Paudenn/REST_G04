package edu.upc.dsa.models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    public User user;
    public List<Product> productList;


    public Order(User user) {
        this.user = user;
        this.productList = new ArrayList<Product>();
    }

    public Order(){}

    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }


    public void addLP(Product product) {

        productList.add(product);
    }

    @Override
    public String toString() {
        return "Order{" +
                "user=" + user +
                ", productList=" + productList +
                '}';
    }
}
