package com.cosmopolis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.cosmopolis.batiments.Batiment;
import com.cosmopolis.batiments.CommerceBatiment;
import com.cosmopolis.batiments.EcoleBatiment;
import com.cosmopolis.batiments.ImmeubleBatiment;
import com.cosmopolis.batiments.IndustrieBatiment;
import com.cosmopolis.batiments.LaboratoireBatiment;
import com.cosmopolis.batiments.MaisonBatiment;

public class Ville {

    Ville(String name) {
        this.name = name;
        this.batsMap.put(new MaisonBatiment(), 0);
        this.batsMap.put(new CommerceBatiment(), 0);
        this.batsMap.put(new ImmeubleBatiment(), 0);
        this.batsMap.put(new IndustrieBatiment(), 0);
        this.batsMap.put(new EcoleBatiment(), 0);
        this.batsMap.put(new LaboratoireBatiment(), 0);

    }
    private String name;

    /**
     * Le nombre de semaines depuis le début de la partie
     */
    private int week = 0;

    /**
     * Le nombre total d'argents
     */
    private float money = 0;

    /**
     * Le nombre total d'argents depensés
     */
    private int totalMoneySpent = 0;
    
    /**
     * Le nombre total d'habitants
     */
    private int residents = 0;
    

    /**
     * Le nombre de points de recherches du joueur
     */
    private int research = 0;
    
    private int totalHouses = 0;
    private int totalShops = 0;
    private int totalBuildings = 0;
    private int totalFactories = 0;
    private int totalSchools = 0;
    private int totalLaboratories = 0;
    
    private Map<Batiment, Integer> batsMap = new HashMap<>();

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    
    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }
    
    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }
    
    public int getTotalMoneySpent() {
        return totalMoneySpent;
    }
    
    public void setTotalMoneySpent(int totalMoneySpent) {
        this.totalMoneySpent = totalMoneySpent;
    }
    
    public int getResidents() {
        return residents;
    }
    
    public void setResidents(int residents) {
        this.residents = residents;
    }
    
    public int getResearch() {
        return research;
    }
    
    public void setResearch(int research) {
        this.research = research;
    }
    
    public int getTotalHouses() {
        return totalHouses;
    }
    
    public void setTotalHouses(int totalHouses) {
        this.totalHouses = totalHouses;
    }
    
    public int getTotalShops() {
        return totalShops;
    }
    
    public void setTotalShops(int totalShops) {
        this.totalShops = totalShops;
    }
    
    public int getTotalBuildings() {
        return totalBuildings;
    }

    public void setTotalBuildings(int totalBuildings) {
        this.totalBuildings = totalBuildings;
    }
    
    public int getTotalFactories() {
        return totalFactories;
    }
    
    public void setTotalFactories(int totalFactories) {
        this.totalFactories = totalFactories;
    }
    
    public int getTotalSchools() {
        return totalSchools;
    }
    
    public void setTotalSchools(int totalSchools) {
        this.totalSchools = totalSchools;
    }

    public int getTotalLaboratories() {
        return totalLaboratories;
    }

    public void setTotalLaboratories(int totalLaboratories) {
        this.totalLaboratories = totalLaboratories;
    }

    public String toString() {
        return "Ville de " + getName() + ", Semaine " + getWeek() + " avec " + getResidents() + " habitants, " + getMoney() + "$";
    }
    
    public void addMoney(float amount) {
        setMoney(getMoney() + amount);
    }

    public void incrementWeek() {
        setWeek(getWeek() + 1);
    }
    
    public boolean buy(int choice){
        /*
         * Maison 1
         * Commerces 2
         * Immeuble
         * Industrie
         * Laboratoire
         */

        Batiment batiment = ((Batiment[])batsMap.keySet().toArray())[choice-1];

        if(this.money>=batiment.getPrice()) {
            this.batsMap.put(batiment, this.batsMap.get(batiment)+1);

            Random rd = new Random();
            setResidents((batiment.getMinhab() + rd.nextInt(batiment.getMaxhab()-batiment.getMinhab())) + getResidents());
            return true;
        } else 
            return false;
    }
}
