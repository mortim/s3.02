package com.cosmopolis;
public class Ville {

    Ville(String name) {
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
    
    private int totalHouses = 0;
    private int totalShops = 0;
    private int totalBuildings = 0;
    private int totalFactories = 0;
    private int totalSchools = 0;
    private int totalLaboratories = 0;

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
}
