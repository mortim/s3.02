package com.cosmopolis.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.cosmopolis.Utils;
import com.cosmopolis.Ville;

public class Fusee extends Fenetre {

    public Ville ville;
    private final String DANS_L_ESPACE = "/com/cosmopolis/dessins/decollage_fusee/4.txt";
    // -- Décollage
    private final String PRET_AU_DECOLLAGE = "/com/cosmopolis/dessins/decollage_fusee/1.txt";
    private final String DECOLLAGE = "/com/cosmopolis/dessins/decollage_fusee/2.txt";
    private final String EN_TRAIN_DE_DECOLLER_1 = "/com/cosmopolis/dessins/decollage_fusee/3a.txt";
    private final String EN_TRAIN_DE_DECOLLER_2 = "/com/cosmopolis/dessins/decollage_fusee/3b.txt";
    private final String EN_TRAIN_DE_DECOLLER_3 = "/com/cosmopolis/dessins/decollage_fusee/3b-1.txt";
    // --- Crash
    private String EN_TRAIN_DE_CRASHER_1 = "/com/cosmopolis/dessins/crash_fusee/0.txt";
    private final String EN_TRAIN_DE_CRASHER_2 = "/com/cosmopolis/dessins/crash_fusee/0a.txt"; 
    private final String FLAMME_1 = "/com/cosmopolis/dessins/crash_fusee/4.txt";
    private String FLAMME_2 = "/com/cosmopolis/dessins/crash_fusee/4a.txt";
    private final String FUSEE_SUR_TERRE = "/com/cosmopolis/dessins/crash_fusee/5.txt";
    private final String EXPLOSION_1 = "/com/cosmopolis/dessins/crash_fusee/6.txt";
    private final String EXPLOSION_2 = "/com/cosmopolis/dessins/crash_fusee/7.txt";
    private final String EXPLOSION_3 = "/com/cosmopolis/dessins/crash_fusee/8.txt";

    public enum State {
        NONE,
        PLAY,
        END
    }

    public State state = State.NONE;

    public Fusee(Ville ville) {
        this.ville = ville;
    }


    public void update() throws IOException, InterruptedException {
        println(Utils.BLUE_BOLD);
        if(state == State.NONE) {
            println("Envoyer une fusée ?");
            println("Cela vous coûtera 100 000€");
            println("Appuyez sur " + Utils.WHITE_BOLD + "[F]" + Utils.RESET);
            return;
        }
        
        
        if(state == State.PLAY) {
            // if(success) {
            this.decollage();
            if(ville.canWin()) {
                this.succes();
            } else {
                this.crash();
            }
            // } else {
            //     this.decollage();
            // }
        } else if(state == State.END) {
            if(ville.canWin()) {
                Utils.printTxt(DANS_L_ESPACE);
            } else {
                Utils.printTxt(EXPLOSION_3);
                println("Réesayer ? Cela vous coûtera  100 000€");
                println("Appuyez sur [F]");
            }
        }
    };

    public void succes() throws IOException, InterruptedException {
        Utils.printTxt(DANS_L_ESPACE);
        state = State.END;
    }

    public void affichageAlterne(String a, String b, int nombre) throws IOException, InterruptedException { 
        for(int i = 0; i < nombre; i++) {
            clearMyScreen();
            if(i%2 == 0)
                Utils.printTxt(a);
            else
                Utils.printTxt(b);
            Thread.sleep(100);
        }
    }

    public void decollage() throws IOException, InterruptedException {
        println("Décollage dans...");
        
        for(int i = 3; i >= 1; i--) {
            clearMyScreen();
            println("Décollage dans..." + i);
            Utils.printTxt(PRET_AU_DECOLLAGE);
            Thread.sleep(1000);
        }

        clearMyScreen();
        Utils.printTxt(DECOLLAGE);

        clearMyScreen();
        Utils.printTxt(EN_TRAIN_DE_DECOLLER_1);
        Thread.sleep(500);
        
        this.affichageAlterne(EN_TRAIN_DE_DECOLLER_2, EN_TRAIN_DE_DECOLLER_3, 50);
    }

    public void crash() throws IOException, InterruptedException {
        clearMyScreen();
        Utils.printTxt(EN_TRAIN_DE_CRASHER_1);
        Thread.sleep(500);

        clearMyScreen();
        Utils.printTxt(EN_TRAIN_DE_CRASHER_2);
        Thread.sleep(500);

        this.affichageAlterne(FLAMME_1, FLAMME_2, 20);

        clearMyScreen();
        Utils.printTxt(FUSEE_SUR_TERRE);
        Thread.sleep(300);

        clearMyScreen();
        Utils.printTxt(EXPLOSION_1);
        Thread.sleep(150);

        clearMyScreen();
        Utils.printTxt(EXPLOSION_2);
        Thread.sleep(200);

        clearMyScreen();
        Utils.printTxt(EXPLOSION_3);
        state = State.END;

    }

    public void send() {
        state = State.PLAY;
    }

}

