package com.cosmopolis;
public class Utils {
    public static float getBuildingPrice(int basePrice, int count) {
        return (float) (basePrice * Math.pow(1.15, count));
    }
}
