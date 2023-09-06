package com.cosmopolis.batiments;

public class CasernePompierBatiment extends Batiment {
    public CasernePompierBatiment(){
        super(3000, 5, 10, 1000, 30, "casernes de pompiers");
    }

    public String toString(){
        return super.toString() + ", ce bâtiment possède également un passif, qui baisse le taux d'incendies.";
    }
}
