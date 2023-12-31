package com.cosmopolis;

import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.cosmopolis.batiments.AbriBatiment;
import com.cosmopolis.batiments.Batiment;
import com.cosmopolis.batiments.PostePoliceBatiment;
import com.cosmopolis.batiments.CasernePompierBatiment;
import com.cosmopolis.batiments.CommerceBatiment;
import com.cosmopolis.batiments.EcoleBatiment;
import com.cosmopolis.batiments.ImmeubleBatiment;
import com.cosmopolis.batiments.IndustrieBatiment;
import com.cosmopolis.batiments.LaboratoireBatiment;
import com.cosmopolis.batiments.MaisonBatiment;

public class Ville {

    public static final double RESEARCH_POINTS_TO_WIN = 1000.0;

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
    public double research = 0.0;

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
        this.residents = Math.max(0, residents);
    }

    public double getResearch() {
        return research;
    }

    public void setResearch(double research) {
        this.research = research;
    }

    public void addResearch(double count) {
        setResearch(getResearch() + count);
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
                + getMoney() + "€";
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
            res+=list.get(i).getMaxResidents();
        }
        return res;
    }

    /**
     * @param choice Le numéro du bâtiment
     * @return Renvoie un entier entre 0 et 2.
     * 0 = tout est bon
     * 1 = pas assez d'argent
     * 2 = bâtiment pas découvert
     */
    public int buy(int choice) {
        Batiment[] batiments = new Batiment[]{
            new MaisonBatiment(),
            new CommerceBatiment(),
            new ImmeubleBatiment(),
            new IndustrieBatiment(),
            new EcoleBatiment(),
            new AbriBatiment(),
            new PostePoliceBatiment(),
            new CasernePompierBatiment(),
            new LaboratoireBatiment(),
        };

        Batiment batiment = batiments[choice-1];
        int count = getTotalBatiments(batiment.getClass().getSimpleName());
        if(this.residents >= batiment.getLanding()){
            if (this.money >= batiment.getTotalPrice(count)) {
                this.bats.add(batiment);
                Random rd = new Random();
                setResidents((batiment.getMinResidents() + rd.nextInt(batiment.getMaxResidents() - batiment.getMinResidents())) + getResidents());
                removeMoney(batiment.getTotalPrice(count));
                return 0;
            } else
                return 1;
        }
        return 2;
    }

    public int disaster(int percent){
        int tmp = (int) this.bats.size()/percent;
        Random rd = new Random();
        for (int i = 0; i<tmp; i++) {
            this.bats.remove(rd.nextInt(this.bats.size()));
        }
        return tmp;
    }
    

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeObject(this.name);
        out.writeObject(this.week);
        out.writeObject(this.money);
        out.writeObject(this.totalMoneySpent);
        out.writeObject(this.residents);
        out.writeObject(this.popularity);
        out.writeObject(this.research);
        out.writeObject(this.bats);
    }

    @SuppressWarnings("unchecked")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        this.name = (String)in.readObject();
        this.week = (int)in.readObject();
        this.money = (float)in.readObject();
        this.totalMoneySpent = (int)in.readObject();
        this.residents = (int)in.readObject();
        this.popularity = (double)in.readObject();
        this.research = (int)in.readObject();
        this.bats = (ArrayList<Batiment>)in.readObject();
    }

    public double ecoleParHabitants() {
        return ((1.0 + getTotalBatiments("EcoleBatiment")) / (double) getResidents()) * 1000.0;
    }
    
    public double abriParHabitants() {
        return ((1.25 + getTotalBatiments("AbriBatiment")) / (double) getResidents()) * 1000.0;
    }
    
    public double policeParHabitants() {
        return ((1.25 + getTotalBatiments("PostePoliceBatiment")) / (double) getResidents()) * 1000.0;
    }
    
    public double pompiersParHabitants() {
        return ((1.25 + getTotalBatiments("CasernePompierBatiment")) / (double) getResidents()) * 1000.0;
    }
    

    public boolean canWin() {
        return getResearch() > Ville.RESEARCH_POINTS_TO_WIN;
    }

    public double getResearchPointsForWeek() {
        // return 10.0;
        return getTotalBatiments("LaboratoireBatiment") * 8.0 * Math.min(ecoleParHabitants(), 1.0);
    }

    public int getTotalBar() {
        int total = 0;
        for (Batiment bat : getBats()) {
            total += bat.getBarHab();
        }
        return total;
    }
}
