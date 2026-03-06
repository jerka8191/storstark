package com.example.enstorstark.appdata;

import com.example.enstorstark.items.Pub;

import java.util.ArrayList;
import java.util.List;

public class PlaceholderData {

    // remove all this when database exists
    public static List<Pub> get() {
        ArrayList<Pub> data = new ArrayList<>();
        String[] names = {"The Red Lion", "Old Town", "Silverkällan"};
        double price = 54.0;
        double size = 400.0;
        double strength = 0.05;
        int i = 0;
        while (i < names.length) {
            Pub temp = new Pub(names[i]);
            temp.setBeer(price, size, strength);
            data.add(temp);
            price -= 4.0;
            i++;
        }
        return data;
    }
}
