package com.cosmopolis.interfaces;

import java.io.IOException;

import com.cosmopolis.Utils;

public class Click extends Fenetre {
    
    public void update() throws IOException {
        println("Bienvenue dans Cosmopolis!");
        println("Votre objectif est de construire la meilleure ville et d'envoyer une fusée.");
        println("Utilisez votre clavier pour jouer.");
        println("Les flèches directionelles vous permettent de naviguer entre les onglets");
        println("Et les touches du pavé numérique vous permettent d'acheter des bâtiments.");
        println("Appuyez sur [Q] pour quitter le jeu.");
    }

    protected void println(Object content) {
        System.out.print("\r" + content + "\r\n");
    }
}
