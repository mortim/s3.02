package com.cosmopolis.tests;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import com.cosmopolis.Ville;
import com.cosmopolis.RandomEvent;

public class RandomEventTest {
    
    public RandomEvent r;
    public Ville v;

    @BeforeEach
    void init(){
        v = new Ville("test nom");
        v.setResidents(15);
        r = new RandomEvent(15, "message", v);
    }

    @Test
    void testGet(){
        assertTrue(15 == r.getHabitants());
    }

    @Test
    void testCreateEvent(){
        r.createEvent(1.4,-1.5, "test message1");
        assertTrue(15 < r.getVille().getResidents());
    }
}
