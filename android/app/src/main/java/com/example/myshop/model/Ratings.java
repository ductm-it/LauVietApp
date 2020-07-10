package com.example.myshop.model;
import java.io.Serializable;
public class Ratings implements Serializable{
    public int id_ratings;
    public int id_customer;
    public int id_product;
    public int star;

    public Ratings(int id_ratings, int id_customer, int id_product, int star) {
        this.id_ratings = id_ratings;
        this.id_customer = id_customer;
        this.id_product = id_product;
        this.star = star;
    }

    public int getId_ratings() {
        return id_ratings;
    }

    public void setId_ratings(int id_ratings) {
        this.id_ratings = id_ratings;
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }
}
