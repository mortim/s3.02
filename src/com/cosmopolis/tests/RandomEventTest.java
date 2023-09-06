package com.cosmopolis.tests;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import com.cosmopolis.Ville;
import com.cosmopolis.evenements.Evenement;
import com.cosmopolis.evenements.RandomEvent;

public class RandomEventTest {
    
    public RandomEvent r;
    public Ville v;

    public RandomEventTest(){
        v = new Ville("test");
        v.setResidents(15);
        r = new RandomEvent(v, Evenement.MOURRANT);
    }

    @Test
    public void testGet(){
        assertEquals(15, v.getResidents());
    }

    @Test
    public void testCreateEvent(){
        r.createEvent();
        assertTrue(15 > v.getResidents());
    }
}
