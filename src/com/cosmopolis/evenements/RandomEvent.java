package com.cosmopolis.evenements;

import com.cosmopolis.Ville;

import java.util.Random;

public class RandomEvent {

    private Ville ville;
    private Evenement evenement;

    public RandomEvent(Ville ville, Evenement evenement){
        this.ville = ville;
        this.evenement = evenement;
    }

    public String createEvent() {
        Random r = new Random();
        String msg = "";
        switch(this.evenement) {
            case ARRIVANT:
                ville.setResidents((int)(ville.getResidents()* 1.1 + (r.nextDouble() + (1.4 - 1.1))));
                msg = "Votre ville semble attirer de nouvelles personnes ! De nouveaux Habitants arrivent.";
                break;
            case MOURRANT:
                ville.setResidents((int)(ville.getResidents()* -1.1 + (r.nextDouble() + (1.3 - (-1.1)))));
                msg = "La vie est courte non ? Certain de vos habitants sont décédés.";
                break;
            case TOURISTE:
                ville.setResidents((int)(ville.getResidents()* 1.8 + (r.nextDouble() + (2.2 - 1.8))));
                msg = "Votre ville est si belle qu'elle acceuille des touristes ! Attention au facteur de surpopulation.";
                break;
            case SURPOPULATION:
                ville.setResidents((int)(ville.getResidents()* -1.4 + (r.nextDouble() + (-1.8 - (-1.4)))));
                msg = "Votre ville à dépassé son seuil de peuplement. Une grosse mortalité s'en est suivie.";
                break;
            case TEMPETE:
                ville.setResidents((int)(ville.getResidents()* -1.2 + (r.nextDouble() + (-1.5 - (-1.2)))));
                msg = "Une Tempete sans précédent vient de toucher votre ville. Les dégâts sont considérables...";
                break;
            case BONVIVRE:
                ville.setResidents((int)(ville.getResidents()* 1.4 + (r.nextDouble() + (-1.5 - (-1.4)))));
                msg = "Il fait bon vivre dans votre ville ! De nombreuses personnes décident de s'installer.";
                break;
            case SEISME:{
                ville.setResidents((int)(ville.getResidents()* -1.3 + (r.nextDouble() + (-1.6 - (-1.3)))));
                msg = "Un terrible séisme s'est abatut sur votre ville ! Les dégâts sont considérables...";
                break;
            }
        }
        return msg;
    }
}