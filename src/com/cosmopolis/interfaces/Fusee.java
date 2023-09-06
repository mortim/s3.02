package com.cosmopolis.interfaces;

import java.io.FileNotFoundException;

import com.cosmopolis.Controls;
import com.cosmopolis.Utils;

public class Fusee extends Fenetre {
    public Fusee() throws FileNotFoundException, InterruptedException {
        String pret_au_decollage = Utils.lireFichier("src/com/cosmopolis/dessins/decollage_fusee/1.txt");
        String decollage = Utils.lireFichier("src/com/cosmopolis/dessins/decollage_fusee/2.txt");
        String en_train_de_decoller1 = Utils.lireFichier("src/com/cosmopolis/dessins/decollage_fusee/3a.txt");
        String en_train_de_decoller2 = Utils.lireFichier("src/com/cosmopolis/dessins/decollage_fusee/3b.txt");
        String en_train_de_decoller3 = Utils.lireFichier("src/com/cosmopolis/dessins/decollage_fusee/3b-1.txt");
        String dans_lespace = Utils.lireFichier("src/com/cosmopolis/dessins/decollage_fusee/4.txt");

        System.out.println("Décollage dans...");
        System.out.println(pret_au_decollage);

        for(int i = 1; i <= 3; i++) {
            System.out.print("\033[H\033[2J");
            System.out.println("Décollage dans..." + i);
            System.out.println(pret_au_decollage);
            Thread.sleep(1000);
        }

        System.out.print("\033[H\033[2J");
        System.out.println(decollage);

        System.out.print("\033[H\033[2J");
        System.out.println(en_train_de_decoller1);
        Thread.sleep(500);
        
        for(int i = 0; i < 20; i++) {
            System.out.print("\033[H\033[2J");
            if(i%2 == 0)
                System.out.println(en_train_de_decoller3);
            else
                System.out.println(en_train_de_decoller2);
            Thread.sleep(100);
        }

        System.out.print("\033[H\033[2J");
        System.out.println(dans_lespace);
    }

}
