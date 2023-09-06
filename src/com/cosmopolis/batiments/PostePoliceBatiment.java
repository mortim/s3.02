package com.cosmopolis.batiments;

public class PostePoliceBatiment extends Batiment  {
    public PostePoliceBatiment(){
        super(3000, 20, 30, 1000, 30, "poste de police");
    }

    public String toString(){
        return super.toString() + ", ce bâtiment possède également un passif, qui baisse le taux de cambriolages.";
    }
}
