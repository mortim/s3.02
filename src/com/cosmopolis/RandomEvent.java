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




    double v0 = ville.getResidents()*random.nextDouble(-1.1,-1.2);
    int Mourrants = (int) v0;
    RandomEvent Morts = new RandomEvent(Mourrants,"La vie est courte non ? Certain de vos habitant sont décédés.",ville);

    double v1 = ville.getResidents()*random.nextDouble(1.1,1.4);
    int Arrivant = (int) v1;
    RandomEvent Arrivees = new RandomEvent(Arrivant,"Votre ville semble attirer de nouvelles personnes ! De nouveaux Habitants arrivent.",ville);

    double v2 = ville.getResidents()*random.nextDouble(1.8,2.2);
    int Touristes = (int) v2;
    RandomEvent Tourisme = new RandomEvent(Touristes,"Votre ville est si belle qu'elle acceuille des touristes ! Attention au facteur de surpopulation.",ville);


    double v3 = ville.getResidents()*random.nextDouble(-1.4,-1.8);
    int Surpopilation = (int) v3;
    RandomEvent Surpeuplement = new RandomEvent(Touristes,"Votre ville à dépassé son seuil de peuplement. Une grosse mortalité s'en est suivie.",ville);

}
