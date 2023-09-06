package com.cosmopolis.batiments;

public class CasernePoliceBatiment extends Batiment  {
    public CasernePoliceBatiment(){
        super(3000, 5, 10, 2000, 30);
    }

    public String toString(){
        return super.toString() + ", ce bâtiment possède également un passif, qui baisse le taux de cambriolages.";
    }
}
