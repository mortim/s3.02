package com.cosmopolis.evenements;

import com.cosmopolis.Ville;

import java.util.Random;

public class RandomEvent {

    Random random = new Random();
    private Ville ville;
    private int addHabitants=0;
    private String message="";

    public RandomEvent(int hab, String msg, Ville ville){
        this.addHabitants=hab;
        this.message=msg;
        this.ville=ville;
    }

    public int getHabitants(){return this.addHabitants;}



    public String createEvent(double i1, double i2, String msg){
        
        double v0 = ville.getResidents()* i1 + (random.nextDouble() + (i2 - i1));
        int variable = (int) v0;
        ville.setResidents(variable);
        return msg;
    }

    //arrive tous les 7 tours
    String Arrivant = createEvent(1.1, 1.4, "Votre ville semble attirer de nouvelles personnes ! De nouveaux Habitants arrivent.");

    //arrive tous les 7 tours
    String Mourrant = createEvent(-1.1, -1.3, "La vie est courte non ? Certain de vos habitant sont décédés.");

    //probabilité que ça arrive à chaque tour : 5%
    String Touristes = createEvent(1.8,2.2,"Votre ville est si belle qu'elle acceuille des touristes ! Attention au facteur de surpopulation.");

    //arrive si la population qui s'ajoute du tour en jeu est égale à la population du tour précédent
    String Surpopulation = createEvent(-1.4,-1.8, "Votre ville à dépassé son seuil de peuplement. Une grosse mortalité s'en est suivie.");

    //arrive si la population qui s'ajoute du tour en jeu est égale à la population du tour précédent
    String Tempete = createEvent(-1.2,-1.5,"Une Tempete sans précédent vient de toucher votre ville. Les dégâts sont considérables...");

    //arrive si la population qui s'ajoute du tour en jeu est égale à la population du tour précédent
    String BonVivre = createEvent(1.4,-1.5,"Il fait bon vivre dans votre ville ! De nombreuses personnes décident de s'installer.");


}
