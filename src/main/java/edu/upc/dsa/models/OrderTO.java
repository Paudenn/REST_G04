package edu.upc.dsa.models;

import java.util.ArrayList;
import java.util.List;

public class OrderTO {

    private String user;
    private List<ProductTO> products;

    public OrderTO() {
        this.products = new ArrayList<ProductTO>();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<ProductTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductTO> products) {
        this.products = products;
    }

    public OrderTO(Order order) {
        this();
        this.user = order.user.name;
        for (Product p: order.productList) {
            this.products.add(new ProductTO(p.name));
        }
    }
}
