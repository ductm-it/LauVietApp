package com.example.myshop.model;

import java.io.Serializable;

public class DonHang implements Serializable {
    public  int Id;
    public  int id_customer;
    public String date_order;
    public  float total;


    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public DonHang(int id, int id_customer, String date_order, float total) {
        Id = id;
        this.id_customer = id_customer;
        this.date_order = date_order;
        this.total = total;

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public String getDate_order() {
        return date_order;
    }

    public void setDate_order(String date_order) {
        this.date_order = date_order;
    }


}
