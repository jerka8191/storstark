package com.example.enstorstark.items;

public class Beer {

    private double price;
    private double size;
    private double strength;

    public Beer(double price, double size, double strength) {
        this.price = price;
        this.size = size;
        this.strength = strength;
    }

    public double price() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double size() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double strength() { return strength; }

    public void setStrength(double strength) { this.strength = strength; }
}
