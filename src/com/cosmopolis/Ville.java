package com.cosmopolis;

import java.util.ArrayList;
import java.util.Random;

import com.cosmopolis.batiments.Batiment;
import com.cosmopolis.batiments.CommerceBatiment;
import com.cosmopolis.batiments.EcoleBatiment;
import com.cosmopolis.batiments.ImmeubleBatiment;
import com.cosmopolis.batiments.IndustrieBatiment;
import com.cosmopolis.batiments.LaboratoireBatiment;
import com.cosmopolis.batiments.MaisonBatiment;

public class Ville {

    public Ville(String name) {
        this.name = name;
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

    private double popularity = 0.5;

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    /**
     * Le nombre de points de recherches du joueur
     */
    private int research = 0;

    private ArrayList<Batiment> bats = new ArrayList<>();

    public String getName() {
        return name;
    }

    public ArrayList<Batiment> getBats() {
        return bats;
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
        int tmp = 0;
        for (int i = 0; i < this.bats.size(); i++) {
            if(this.bats.get(i).getClass().equals(new MaisonBatiment().getClass())) tmp++;
        }
        return tmp;
    }

    public int getTotalShops() {
        int tmp = 0;
        for (int i = 0; i < this.bats.size(); i++) {
            if(this.bats.get(i).getClass().equals(new CommerceBatiment().getClass())) tmp++;
        }
        return tmp;
    }

    public int getTotalBuildings() {
        int tmp = 0;
        for (int i = 0; i < this.bats.size(); i++) {
            if(this.bats.get(i).getClass().equals(new ImmeubleBatiment().getClass())) tmp++;
        }
        return tmp;
    }

    public int getTotalFactories() {
        int tmp = 0;
        for (int i = 0; i < this.bats.size(); i++) {
            if(this.bats.get(i).getClass().equals(new IndustrieBatiment().getClass())) tmp++;
        }
        return tmp;
    }

    public int getTotalSchools() {
        int tmp = 0;
        for (int i = 0; i < this.bats.size(); i++) {
            if(this.bats.get(i).getClass().equals(new EcoleBatiment().getClass())) tmp++;
        }
        return tmp;
    }

    public int getTotalLaboratories() {
        int tmp = 0;
        for (int i = 0; i < this.bats.size(); i++) {
            if(this.bats.get(i).getClass().equals(new LaboratoireBatiment().getClass())) tmp++;
        }
        return tmp;
    }

    public String toString() {
        return "Ville de " + getName() + ", Semaine " + getWeek() + " avec " + getResidents() + " habitants, "
                + getMoney() + "$";
    }

    public void addMoney(float amount) {
        setMoney(getMoney() + amount);
    }

    public void incrementWeek() {
        setWeek(getWeek() + 1);
    }

    public void removeMoney(float amount){
        setMoney(money - amount);
    }

    public int nombreMaxHab(){
        int res=0;
        ArrayList<Batiment> list = getBats();
        for(int i=0; i<list.size(); i++){
            res+=list.get(i).getBarHab();
        }
        return res;
    }

    public boolean buy(int choice) {
        ArrayList<Batiment> batiments = new ArrayList<>();
        batiments.add(new MaisonBatiment());
        batiments.add(new CommerceBatiment());
        batiments.add(new ImmeubleBatiment());
        batiments.add(new IndustrieBatiment());
        batiments.add(new EcoleBatiment());
        batiments.add(new LaboratoireBatiment());
        /*
         * Maison 1
         * Commerces 2
         * Immeuble
         * Industrie
         * Laboratoire
         */

        Batiment batiment = batiments.get(choice-1);
        if (this.money >= batiment.getPrice()) {
            this.bats.add(batiment);
            Random rd = new Random();
            setResidents((batiment.getMinhab() + rd.nextInt(batiment.getMaxhab() - batiment.getMinhab())) + getResidents());
            removeMoney(batiment.getPrice());
            return true;
        } else
            return false;
    }
}
