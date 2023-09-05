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



    //arrive tous les 7 tours
    double v0 = ville.getResidents()*random.nextDouble(-1.1,-1.2);
    int Mourrants = (int) v0;
    RandomEvent Morts = new RandomEvent(Mourrants,"La vie est courte non ? Certain de vos habitant sont décédés.",ville);

    //arrive tous les 7 tours
    double v1 = ville.getResidents()*random.nextDouble(1.1,1.4);
    int Arrivant = (int) v1;
    RandomEvent Arrivees = new RandomEvent(Arrivant,"Votre ville semble attirer de nouvelles personnes ! De nouveaux Habitants arrivent.",ville);

    //probabilité que ça arrive à chaque tour : 5%
    double v2 = ville.getResidents()*random.nextDouble(1.8,2.2);
    int Touristes = (int) v2;
    RandomEvent Tourisme = new RandomEvent(Touristes,"Votre ville est si belle qu'elle acceuille des touristes ! Attention au facteur de surpopulation.",ville);

    //arrive si la population qui s'ajoute du tour en jeu est égale à la population du tour précédent
    double v3 = ville.getResidents()*random.nextDouble(-1.4,-1.8);
    int Surpopilation = (int) v3;
    RandomEvent Surpeuplement = new RandomEvent(Touristes,"Votre ville à dépassé son seuil de peuplement. Une grosse mortalité s'en est suivie.",ville);

    //probabilité que ça arrive à chaque tour : 5%
    double v4 = ville.getResidents()*random.nextDouble(-1.2,-1.5);
    int Tempetes = (int) v4;
    RandomEvent Tempete = new RandomEvent(Tempetes,"Une Tempete sans précédent vient de toucher votre ville. Les dégâts sont considérables...",ville);

    //probabilité que ça arrive à chaque tour : 5%
    double v5 = ville.getResidents()*random.nextDouble(1.4,1.6);
    int BonVivres = (int) v5;
    RandomEvent BonVivre = new RandomEvent(BonVivres,"Il fait bon vivre dans votre ville ! De nombreuses personnes décident de s'installer.",ville);

}
