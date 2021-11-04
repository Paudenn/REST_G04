package edu.upc.dsa;

import edu.upc.dsa.models.Order;
import edu.upc.dsa.models.User;
import edu.upc.dsa.models.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Queue;

public interface ProductManager {
    List<Product> getProductsByPrice();
    void doOrder(Order order);
    void serveOrder();
    List<Order> getOrdersByUser(User user);
    List<Product> getProductsBySales();
    void addProduct(Product product);

    int getNumProducts();
    void addUser(User user);
    HashMap<String,User> getUser();
    int getOrderAmount();
    List<Product> getProductsList();
    Queue<Order> getOrdersList();
    int getSellsnum();
}
