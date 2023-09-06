package com.cosmopolis.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.cosmopolis.Utils;

public class Fusee extends Fenetre {
    private final String DANS_L_ESPACE = "src/com/cosmopolis/dessins/decollage_fusee/4.txt";
    // -- Décollage
    private final String PRET_AU_DECOLLAGE = "src/com/cosmopolis/dessins/decollage_fusee/1.txt";
    private final String DECOLLAGE = "src/com/cosmopolis/dessins/decollage_fusee/2.txt";
    private final String EN_TRAIN_DE_DECOLLER_1 = "src/com/cosmopolis/dessins/decollage_fusee/3a.txt";
    private final String EN_TRAIN_DE_DECOLLER_2 = "src/com/cosmopolis/dessins/decollage_fusee/3b.txt";
    private final String EN_TRAIN_DE_DECOLLER_3 = "src/com/cosmopolis/dessins/decollage_fusee/3b-1.txt";
    // --- Crash
    private String EN_TRAIN_DE_CRASHER_1 = "src/com/cosmopolis/dessins/crash_fusee/0.txt";
    private final String EN_TRAIN_DE_CRASHER_2 = "src/com/cosmopolis/dessins/crash_fusee/0a.txt"; 
    private final String FLAMME_1 = "src/com/cosmopolis/dessins/crash_fusee/4.txt";
    private String FLAMME_2 = "src/com/cosmopolis/dessins/crash_fusee/4a.txt";
    private final String FUSEE_SUR_TERRE = "src/com/cosmopolis/dessins/crash_fusee/5.txt";
    private final String EXPLOSION_1 = "src/com/cosmopolis/dessins/crash_fusee/6.txt";
    private final String EXPLOSION_2 = "src/com/cosmopolis/dessins/crash_fusee/7.txt";
    private final String EXPLOSION_3 = "src/com/cosmopolis/dessins/crash_fusee/8.txt";

    public boolean playing_animation = false;

    public void update(boolean success) throws IOException, InterruptedException {
        if(playing_animation)
            return;
        playing_animation = true;

        if(success) {
            this.decollage();
            this.succes();
        } else {
            this.decollage();
            this.crash();
        }
    };

    public void succes() throws IOException, InterruptedException {
        clearMyScreen();
        Utils.printTxt(DANS_L_ESPACE);
        Thread.sleep(10000);
    }

    public void affichageAlterne(String a, String b) throws IOException, InterruptedException { 
        for(int i = 0; i < 20; i++) {
            clearMyScreen();
            if(i%2 == 0)
                Utils.printTxt(a);
            else
                Utils.printTxt(b);
            Thread.sleep(100);
        }
    }

    public void decollage() throws IOException, InterruptedException {
        println(Utils.BLUE_BOLD + "Décollage dans...");
        
        for(int i = 1; i <= 3; i++) {
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
        
        this.affichageAlterne(EN_TRAIN_DE_DECOLLER_2, EN_TRAIN_DE_DECOLLER_3);
    }

    public void crash() throws IOException, InterruptedException {
        clearMyScreen();
        Utils.printTxt(EN_TRAIN_DE_CRASHER_1);
        Thread.sleep(500);

        clearMyScreen();
        Utils.printTxt(EN_TRAIN_DE_CRASHER_2);
        Thread.sleep(500);

        this.affichageAlterne(FLAMME_1, FLAMME_2);

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
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Fusee fusee = new Fusee();
        fusee.update(false);
    }

}

