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
                int v = (int)(ville.getResidents()* 1.1 + (r.nextDouble() + (1.4 - 1.1)));
                ville.setResidents(v);
                msg = "Votre ville semble attirer de nouvelles personnes ! "+v+" habitants arrivent.";
                break;
            case MOURRANT:
                int v1 = (int)(ville.getResidents()* 0.9 + (r.nextDouble() + (0.7 - (0.9))));
                ville.setResidents(v1);
                msg = "La vie est courte non ? "+v1+" de vos habitants sont décédés.";
                break;
            case TOURISTE:
                int v2 = (int)(ville.getResidents()* 1.8 + (r.nextDouble() + (2.2 - 1.8)));
                ville.setResidents(v2);
                msg = "Votre ville est si belle qu'elle accueille "+v2+" touristes ! Attention au facteur de surpopulation.";
                break;
            case SURPOPULATION:
                int v3 = (int)(ville.getResidents()* 0.6 + (r.nextDouble() + (0.2 - (0.6))));
                ville.setResidents(v3);
                msg = "Votre ville à dépassé son seuil de peuplement. C'est désastreux, "+v3+" de vos habitants sont morts.";
                break;
            case TEMPETE:
                int v4 = (int)(ville.getResidents()* 0.8 + (r.nextDouble() + (0.5 - (0.8))));
                ville.setResidents(v4);
                int v5=ville.disaster(20);
                msg = "Une Tempête sans précédent vient de toucher votre ville. \r\nLes dégâts sont considérables... Vous perdez "+v5+" batiments et "+v4+" de vos habitants sont morts.";
                break;
            case BONVIVRE:
                int v6 = (int)(ville.getResidents()* 1.4 + (r.nextDouble() + (-1.5 - (-1.4))));
                ville.setResidents(v6);
                msg = "Il fait bon vivre dans votre ville ! "+v6+" personnes décident de s'installer.";
                break;
            case SEISME:
                int v7 = (int)(ville.getResidents()* 0.7 + (r.nextDouble() + (0.6 - (0.7))));
                ville.setResidents(v7);
                int v8 = ville.disaster(10);
                msg = "Un terrible séisme s'est abatut sur votre ville ! \r\nLes dégâts sont considérables... Vous perdez "+v8+" batiments et "+v7+" de vos habitants sont morts.";
                break;
            
            case INCENDIE:
                int v9 = (int)(ville.getResidents()* -0.8 + (r.nextDouble() + (0.6 - (0.8))));
                ville.setResidents(v9);
                int v10 = ville.disaster(30);
                msg = "Un incendie vient de se déclencher dans votre ville ! Les dégâts sont considérables... Vous perdez "+v10+" batiments et "+v9+" de vos habitants sont morts.";
                break;
            case BRAQUAGE:
                int v11 = (int)(ville.getMoney() * 0.9 + (r.nextDouble() + (0.8 - (0.9))));
                double v12 = ville.getMoney();
                ville.setMoney(v11);
                msg = "Un groupe de cambrioleur, qui convoitait votre patrimoine, est parvenu à chapparder votre argent ! Vous perdez "+(v12-v11)+"$.";
                break;
        }
        return msg;
    }
}