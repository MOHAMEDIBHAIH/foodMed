package com.example.food2.Domain;

import java.io.Serializable;

public class FoodDomain implements Serializable {
    private String title;
    private int pic;
    private String description;
    private Double fee;
    private int numberInCart;

    public FoodDomain(String title, int pic, String description, Double fee, int numberInCart) {
        this.title = title;
        this.pic = pic;
        this.description = description;
        this.fee = fee;
        this.numberInCart = numberInCart;
    }



    public FoodDomain(String title, int pic, Double fee, String description) {
        this.title = title;
        this.pic = pic;
        this.fee = fee;
        this.description=description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }
}
