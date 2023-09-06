package com.cosmopolis.interfaces;

import java.io.IOException;

import com.cosmopolis.Utils;

public class Click extends Fenetre {
    
    public void update() throws IOException {
        println("╔═════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
        println("║ Votre objectif est de construire la meilleure ville et d'envoyer une fusée.                             ║");
        println("║                                                                                                         ║");
        println("║ Tutoriel:                                                                                               ║");
        println("║ Utilisez les flèches directionnelles pour jouer, ils vous permettent de naviguer entre les onglets.     ║");
        println("║ Et les touches du pavé numérique vous permettent d'acheter des bâtiments.                               ║");
        println("║ Appuyez sur [Q/q] pour quitter le jeu.                                                                  ║");
        println("╚═════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
        println("");
        Utils.printTxt("src/com/cosmopolis/dessins/infos");
    }

    protected void println(Object content) {
        System.out.print("\r" + content + "\r\n");
    }
}
