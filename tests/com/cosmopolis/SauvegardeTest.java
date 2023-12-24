package com.cosmopolis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SauvegardeTest {
    
    public Ville v;
    public Sauvegarde save;

    @BeforeEach
    void init(){
        save = new Sauvegarde("/tmp/titi.dat");
        v = new Ville("test");
        v.setMoney(10000);
        v.setResidents(50);
        v.setWeek(5);
    }

    @Test
    void sauvegardeLireTest(){
        save.sauvegarder(v);
    }
}
