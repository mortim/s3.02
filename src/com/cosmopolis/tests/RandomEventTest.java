package com.cosmopolis.tests;


import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import com.cosmopolis.Ville;
import com.cosmopolis.evenements.Evenement;
import com.cosmopolis.evenements.RandomEvent;

public class RandomEventTest {
    
    public RandomEvent r;
    public Ville v;

    @BeforeEach
    void init(){
        v = new Ville("test nom");
        v.setResidents(15);
        r = new RandomEvent(v, Evenement.MOURRANT);
    }

    @Test
    void testGet(){
        assertTrue(15 == v.getResidents());
    }

    @Test
    void testCreateEvent(){
        r.createEvent();
        assertTrue(15 > v.getResidents());
    }
}
