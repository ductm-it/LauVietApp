package com.example.myshop.model;

public class LoaiSP {
    public  int Id;
    public  String name;
    public  String  image;

    public LoaiSP(int id, String name, String image) {
        Id = id;
        this.name = name;
        this.image = image;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
