package com.example.enstorstark.items;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.enstorstark.util.ApkUtility;

public class Beer implements Parcelable {

    private double price;
    private double size;
    private double strength;

    public Beer(double price, double size, double strength) {
        this.price = price;
        this.size = size;
        this.strength = strength;
    }

    // protected constructor used when recreating object from Parcel
    protected Beer(Parcel in) {
        price = in.readDouble();
        size = in.readDouble();
        strength = in.readDouble();
    }

    public static final Creator<Beer> CREATOR = new Creator<Beer>() {
        @Override
        public Beer createFromParcel(Parcel in) {
            return new Beer(in);
        }

        @Override
        public Beer[] newArray(int size) {
            return new Beer[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeDouble(price);
        parcel.writeDouble(size);
        parcel.writeDouble(strength);
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

    public double getApk() {
        return ApkUtility.calculateApk(this);
    }
}
