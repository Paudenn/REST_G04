package edu.upc.dsa.models;

public class ProductTO {
    private String name;
    private int q;

    public ProductTO() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQ() {
        return q;
    }

    public void setQ(int q) {
        this.q = q;
    }

    public ProductTO(String name) {
        this.name = name;
    }
}
