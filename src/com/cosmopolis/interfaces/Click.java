package com.cosmopolis.interfaces;

import java.io.IOException;

import com.cosmopolis.Utils;

public class Click extends Fenetre {
    
    public void update() throws IOException {
        println("╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
        println("║ Votre objectif est de construire la meilleure ville et d'envoyer une fusée.                             ║");
        println("║                                                                                                         ║");
        println("║ Tutoriel:                                                                                               ║");
        println("║ °-Utilisez les flèches directionnelles pour jouer, ils vous permettent de naviguer entre les onglets.   ║");
        println("║   Et les touches du pavé numérique vous permettent d'acheter des bâtiments.                             ║");
        println("║ °-1000 points de recherche sont nécessaires pour envoyer une fusée dans l'espace.                       ║");
        println("║ °-Les batiments spéciaux (Caserne de pompier,Abris etc..) permmettent de réduire les risques            ║");
        println("║   d'évènements indésirables (Séismes, Tempêtes etc..).                                                  ║");
        println("║ °-Appuyez sur [Q/q] pour quitter le jeu.                                                                ║");
        println("╚═════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
        println("");
        Utils.printTxt("/com/cosmopolis/dessins/infos.txt");
    }

    protected void println(Object content) {
        System.out.print("\r" + content + "\r\n");
    }
}
