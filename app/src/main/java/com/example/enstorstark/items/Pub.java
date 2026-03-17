package com.example.enstorstark.items;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.enstorstark.util.ApkUtility;

public class Pub implements Parcelable {

    private String name;
    private Beer beer;

    public Pub(String name) {
        this.name = name;
    }

    // protected constructor used to create object from parcel
    protected Pub(Parcel in) {
        name = in.readString();
        beer = in.readParcelable(Beer.class.getClassLoader());
    }

    public void setBeer(double price, double size, double strength) {
        this.beer = new Beer(price, size, strength);
    }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(name);
        out.writeParcelable(beer, flags);
    }

    public static final Parcelable.Creator<Pub> CREATOR = new Parcelable.Creator<>() {
        public Pub createFromParcel(Parcel in) {
            return new Pub(in);
        }
        public Pub[] newArray(int size) {
            return new Pub[size];
        }
    };

    public String name() {
        return name;
    }

    public Beer beer() { return beer; }
}
