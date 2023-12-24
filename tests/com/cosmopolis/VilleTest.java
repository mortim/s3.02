package com.cosmopolis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cosmopolis.batiments.Batiment;
import com.cosmopolis.batiments.IndustrieBatiment;

public class VilleTest {

    public Ville v;

    @BeforeEach
    void init(){
        v = new Ville("test");
        v.setMoney(360000000);
    }
    @Test
    void testBuy() {
        assertEquals(v.buy(4), 2);
        v.setResidents(250);
        assertEquals(v.buy(4), 0);
        ArrayList<Batiment> bats = new ArrayList<>();
        bats.add(new IndustrieBatiment());
        assertTrue(v.getBats().get(0).getPrice() == bats.get(0).getPrice());
        assertTrue(v.getBats().get(0).getMaxResidents() == bats.get(0).getMaxResidents());
        assertTrue(v.getBats().get(0).getMinResidents() == bats.get(0).getMinResidents());
        assertTrue(v.getBats().get(0).getLanding() == bats.get(0).getLanding());
    }
    @Test
    void testGettersSetters(){
        v.setResidents(250);
        v.buy(2);
        assertEquals(1, v.getBats().size());
        v.buy(1);
        assertEquals(2, v.getBats().size());
        v.setPopularity(5);
        assertTrue(5 == v.getPopularity());
        v.setName("test1");
        assertEquals("test1", v.getName());
        v.setWeek(4);
        assertTrue(4 == v.getWeek());
        v.setMoney(3000);
        assertTrue(3000 == v.getMoney());
        v.setTotalMoneySpent(12000);
        assertTrue(12000 == v.getTotalMoneySpent());
        v.setResidents(11);
        assertTrue(11 == v.getResidents());
        v.setResearch(10);
        assertTrue(10 == v.getResearch());
        assertTrue(1 == v.getTotalBatiments("MaisonBatiment"));
        assertTrue(1 == v.getTotalBatiments("CommerceBatiment"));
    }

    @Test
    void testMoney(){
        v.setMoney(100);
        v.addMoney(500);
        assertTrue(600 == v.getMoney());
        v.removeMoney(200);
        assertTrue(400 == v.getMoney());
    }

    @Test
    void testIncrementWeek(){
        v.setWeek(0);
        v.incrementWeek();
        v.incrementWeek();
        assertTrue(2 == v.getWeek());
    }

}
