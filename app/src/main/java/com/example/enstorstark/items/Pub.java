package com.example.enstorstark.items;

import com.example.enstorstark.util.ApkUtility;

public class Pub {

    private String name;
    private Beer beer;

    public Pub(String name) {
        this.name = name;
    }

    public void setBeer(double price, double size, double strength) {
        this.beer = new Beer(price, size, strength);
    }

    public String name() {
        return name;
    }

    public double getApk() {
        return ApkUtility.calculateApk(beer);
    }
}
