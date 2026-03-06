package com.example.enstorstark.util;

import com.example.enstorstark.items.Beer;

public class ApkUtility {

    public static double calculateApk(Beer beer) {
        double millilitersOfAlcohol = beer.size() * beer.strength();
        return millilitersOfAlcohol / beer.price();
    }
}
