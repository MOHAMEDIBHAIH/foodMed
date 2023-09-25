package com.example.food2.products;

public class product {
    String name;
    int id;
    double fee;

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }





    public product(String name, int id,double fee) {
        this.name = name;
        this.id = id;
        this.fee=fee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
