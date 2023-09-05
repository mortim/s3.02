package com.cosmopolis;


import java.util.Random;

public class RandomEvent {

    Random random = new Random();
    private Ville ville;
    private int addHabitants=0;
    private String message;

    public RandomEvent(int hab, String msg, Ville ville){
        this.addHabitants=hab;
        this.message=msg;
        this.ville = ville;
    }

    public int getHabitants(){return this.addHabitants;}

    public Ville getVille(){return this.ville;}

    public String createEvent(double i1, double i2, String msg){
        double v0 = ville.getResidents() * i1 + (random.nextDouble() - (i2 - i1));
        int variable = (int) v0;
        ville.setResidents(variable);
        return msg;
    }
}
