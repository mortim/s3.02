package com.cosmopolis.interfaces;

import java.io.IOException;

import com.cosmopolis.Controls;
import com.cosmopolis.Raccourcis;
import com.cosmopolis.Utils;

public class Menu extends Controls {

    public boolean exit = false;
    public Menu() throws IOException {
        println(Utils.RED_BOLD);
        Utils.printTxt("src/com/cosmopolis/dessins/logo.txt");
        println(Utils.RESET + "[1] Nouvelle partie");
        println(Utils.BLACK + "[2] Continuer" + Utils.RESET);
        println("[3] Quitter le jeu");
        enableKeyTypedInConsole(true);
        while(!exit) {
            sleep(100);
        }
        clearMyScreen();
        Utils.printTxt("src/com/cosmopolis/dessins/comment_jouer.txt");
        sleep(4000);
    }

    protected void keyTypedInConsole(int keyCode) {
        if(keyCode == Raccourcis.PAVE_1.getID() || keyCode == Raccourcis.PAVE_1.getID()) {
            exit = true;
        } else if(keyCode == Raccourcis.PAVE_2.getID() || keyCode == Raccourcis.SPECIAUX_2.getID()) {
            // TODO
        } else if(keyCode == Raccourcis.PAVE_3.getID() || keyCode == Raccourcis.SPECIAUX_3.getID()) {
            System.exit(0);
        }
        // else if(keyCode == Raccourcis.PAVE_4.getID() || keyCode == Raccourcis.SPECIAUX_4.getID()) {
        // }
    }
}
