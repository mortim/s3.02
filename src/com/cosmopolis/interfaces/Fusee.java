package com.cosmopolis.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.cosmopolis.Utils;

public class Fusee extends Fenetre {
    final String PRET_AU_DECOLLAGE = "src/com/cosmopolis/dessins/decollage_fusee/1.txt";
    final String DECOLLAGE = "src/com/cosmopolis/dessins/decollage_fusee/2.txt";
    final String EN_TRAIN_DE_DECOLLER_1 = "src/com/cosmopolis/dessins/decollage_fusee/3a.txt";
    final String EN_TRAIN_DE_DECOLLER_2 = "src/com/cosmopolis/dessins/decollage_fusee/3b.txt";
    final String EN_TRAIN_DE_DECOLLER_3 = "src/com/cosmopolis/dessins/decollage_fusee/3b-1.txt";
    final String DANS_L_ESPACE = "src/com/cosmopolis/dessins/decollage_fusee/4.txt";

    public boolean playing_animation = false;

    public void update() throws IOException, InterruptedException {
        if(playing_animation) {
            return;
        }
        playing_animation = true;
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
        
        for(int i = 0; i < 20; i++) {
            clearMyScreen();
            if(i%2 == 0)
                Utils.printTxt(EN_TRAIN_DE_DECOLLER_2);
            else
                Utils.printTxt(EN_TRAIN_DE_DECOLLER_3);
            Thread.sleep(100);
        }

        clearMyScreen();
        Utils.printTxt(DANS_L_ESPACE);
        Thread.sleep(10000);
    };

}
