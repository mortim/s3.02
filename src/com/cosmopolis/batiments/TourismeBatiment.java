package com.cosmopolis.batiments;

public class TourismeBatiment extends Batiment {
    public TourismeBatiment(){
        super(2000, 2, 6, 1000, 25, "offices de tourismes");
    }

    public String toString(){
        return super.toString() + ", ce bâtiment possède également un passif, qui régularise le tourisme.";
    }
}
