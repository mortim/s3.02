package com.cosmopolis.batiments;

public class AbriBatiment extends Batiment {
    public AbriBatiment(){
        super(2000, 2, 6, 1000, 25, "abris");
    }

    public String toString(){
        return super.toString() + ", ce bâtiment possède également un passif, qui baisse le taux de mortalité lors des tempêtes.";
    }
}
