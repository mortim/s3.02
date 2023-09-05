package com.cosmopolis.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cosmopolis.Ville;
import com.cosmopolis.batiments.Batiment;
import com.cosmopolis.batiments.IndustrieBatiment;

public class VilleTest {

    public Ville v;

    @BeforeEach
    void init(){
        v = new Ville("test");
        v.setMoney(360000000);
    }

    /*
     * Teste la fonction buy (considère que les String ne sont pas identiques)
     */
    @Test
    void testBuy() {
        v.buy(4);
        ArrayList<Batiment> bats = new ArrayList<>();
        bats.add(new IndustrieBatiment());
        assertEquals(v.getBats(), bats);
    }

    /*
     * Teste les getters de la classe Ville
     */
    @Test
    void testGetters(){
        v.buy(2);
        assertEquals(1, v.getTotalShops());
        v.buy(1);
        assertEquals(1, v.getTotalHouses());
        for (int i = 0; i <15; i++) {
            v.buy(1);
        }
        assertEquals(16, v.getTotalHouses());
    }

}
