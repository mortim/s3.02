package com.cosmopolis.batiments;

public class CasernePompierBatiment extends Batiment {
    public CasernePompierBatiment(){
        super(3000, 5, 10, 2000, 30);
    }

    public String toString(){
        return super.toString() + ", ce bâtiment possède également un passif, qui baisse le taux d'incendies.";
    }
}
