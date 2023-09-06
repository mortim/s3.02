package com.cosmopolis.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cosmopolis.Sauvegarde;
import com.cosmopolis.Ville;

public class SauvegardeTest {
    
    public Ville v;
    public Sauvegarde save;

    @BeforeEach
    void init(){
        save = new Sauvegarde("test.dat");
        v = new Ville("test name");
        v.setMoney(10000);
        v.setResidents(50);
        v.setWeek(5);
    }

    @Test
    void sauvegardeLireTest(){
        save.sauvegarder(v);
        assertTrue(v.equals(save.lire()));
    }
}
