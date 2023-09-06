package com.cosmopolis.interfaces;


import java.io.IOException;

import com.cosmopolis.Jeu;
import com.cosmopolis.Utils;

public class Menu extends Fenetre {
    public Jeu jeu;
    
    Menu(Jeu jeu) {
        this.jeu = jeu;
    }
    public void update() throws IOException {
        // println(Utils.RED_BOLD);
        // Utils.printTxt("src/com/cosmopolis/dessins/logo.txt");
        // println("\n" + Utils.RESET + "[1] Nouvelle partie");
        // println(Utils.BLACK + "[2] Continuer" + Utils.RESET);
        // println("[Q] Quitter le jeu");
        // while(true) {

        // }

        // clearMyScreen();
        // Utils.printTxt("src/com/cosmopolis/dessins/comment_jouer.txt");
        // sleep(4000);
    }
}
