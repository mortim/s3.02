package com.cosmopolis.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cosmopolis.batiments.MaisonBatiment;

public class BatimentTest {
    MaisonBatiment maison;

    @BeforeEach
    public void init(){
        maison = new MaisonBatiment();
    }

    @Test
    public void batimentTest(){
        assertEquals(maison.getLanding(), 0);
        maison.setPrice(5000);
        assertTrue(5000 == maison.getPrice());
        maison.setMinMaxResidents(1, 5);
        assertTrue(1 == maison.getMinResidents());
        assertTrue(5 == maison.getMaxResidents());
    }
}
