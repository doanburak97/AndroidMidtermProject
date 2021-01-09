package com.doanburak.hepsiburadaapp;

import java.io.Serializable;

public class Product implements Serializable {

    private String description;
    private int oldPrice;
    private int newPrice;
    private int rating;
    private int image;

    public Product(String description, int oldPrice, int newPrice, int rating, int image){

        this.description = description;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.rating = rating;
        this.image = image;

    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(int oldPrice) {
        this.oldPrice = oldPrice;
    }

    public int getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(int newPrice) {
        this.newPrice = newPrice;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
