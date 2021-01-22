package com.zs.domain;

public class goods {
    private Double price;
    private String name;
    private int count;

    public goods(Double price, String name, int count) {
        this.price = price;
        this.name = name;
        this.count = count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
