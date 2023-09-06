package com.cosmopolis;

import java.util.ArrayList;
import java.util.List;
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

    private List<Batiment> bats = new ArrayList<>();

    public String getName() {
        return name;
    }

    public List<Batiment> getBats() {
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

    public int getTotalBatiments(String name) {
        int tmp = 0;
        for (int i = 0; i < this.bats.size(); i++) {
            if(this.bats.get(i).getClass().getSimpleName().equals(name)) tmp++;
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
        List<Batiment> list = getBats();
        for(int i=0; i<list.size(); i++){
            res+=list.get(i).getBarHab();
        }
        return res;
    }

    public int disaster(){
        int tmp = (int) this.bats.size()/10;
        Random rd = new Random();
        for (int i = 0; i<tmp; i++) {
            this.bats.remove(rd.nextInt(this.bats.size()));
        }
        return tmp;
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
            setResidents((batiment.getMinResidents() + rd.nextInt(batiment.getMaxResidents() - batiment.getMinResidents())) + getResidents());
            removeMoney(batiment.getPrice());
            return true;
        } else
            return false;
    }
}
