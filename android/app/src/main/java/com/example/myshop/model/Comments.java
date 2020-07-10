package com.example.myshop.model;

import java.io.Serializable;

public class Comments implements Serializable {
    private int id_comments;
    private int id_product;
    private int id_customer;
    private String comments;

    public Comments(int id_comments, int id_product, int id_customer, String comments) {
        this.id_comments = id_comments;
        this.id_product = id_product;
        this.id_customer = id_customer;
        this.comments = comments;
    }

    public int getId_comments() {
        return id_comments;
    }

    public void setId_comments(int id_comments) {
        this.id_comments = id_comments;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
