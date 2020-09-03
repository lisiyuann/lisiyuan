package com.example.demo.model;

import lombok.Data;

@Data
public class Shuju {
    private String biaoti;
    private String date;

    public void setbiaoti(String biaoti) {
        { this.biaoti  = biaoti; }
    }

    public String getbiaoti() {
        return biaoti;
    }

    public void setdate(String date) {
        this.date  = date;
    }

    public String getdate() {
        return date;
    }



}