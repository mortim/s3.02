package com.cosmopolis.batiments;

public class PostePoliceBatiment extends Batiment  {
    public PostePoliceBatiment(){
        super(3000, 5, 10, 2000, 30, "poste de police");
    }

    public String toString(){
        return super.toString() + ", ce bâtiment possède également un passif, qui baisse le taux de cambriolages.";
    }
}
