package com.cosmopolis.batiments;

public class OfficeToursismeBatiment extends Batiment {
    public OfficeToursismeBatiment(){
        super(2000, 2, 6, 1000, 25);
    }

    public String toString(){
        return super.toString() + ", ce bâtiment possède également un passif, qui régularise le tourisme.";
    }
}
