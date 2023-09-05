package com.cosmopolis.tests;

import static org.junit.Assert.assertEquals;

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
    }
}
