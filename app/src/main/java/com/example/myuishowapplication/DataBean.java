package com.example.myuishowapplication;

public class DataBean {

    private String description;
    private int int_num;

    public DataBean(int int_num, String description) {
        this.description = description;
        this.int_num = int_num;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getInt_num() {
        return int_num;
    }

    public void setInt_num(int int_num) {
        this.int_num = int_num;
    }
}
