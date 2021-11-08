package edu.upc.dsa.models;

public class Product {
    public String name;
    double price;
    int amount;
    int sells;

    public Product(String name, double price, int amount){
        this.name = name;
        this.price = price;
        this.amount = amount;

    }
    public Product(){}

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }
    public  int getSells(){
        return sells;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
