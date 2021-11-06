package edu.upc.dsa.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    public String name;
    public String id;
    public List<Order> orderList;


    public User(String name, List<Order> orderList,String id) {
        this.name = name;
        this.orderList = orderList;
        this.id = id;
    }
    public User(String name, String id) {
        this.name = name;
        this.id = id;
        orderList = new ArrayList<>();
    }
    public User(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrderList() {
        return orderList;
    }


    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

}
