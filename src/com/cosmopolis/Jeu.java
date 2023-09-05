package com.cosmopolis;
import java.io.IOException;
import java.util.Scanner;

import com.cosmopolis.interfaces.Click;
import com.cosmopolis.interfaces.Fusee;
import com.cosmopolis.interfaces.Magasin;

public class Jeu extends Controls {

    /**
     * La longueur d'une semaine en millisecondes.
     */
    public final int WEEK_LENGTH = 2500;
    /**
     * Le nombre de millisecondes avant le jour suivant.
     */
    public int msUntilNextWeek = 0;

    /**
     * L'écran sur laquelle le joueur se trouve actuellement (0 = cliquer, 1 = acheter des bâtiments, 2 = envoyer une fusée)
     */
    public int screen = 1;

    public Object currentScreen;
    /**
     * Les données du joueur
     */
    public Ville ville;

    
    Jeu() throws InterruptedException, IOException {
    
        // D'abord on demande au joueur de nommer sa ville
        println("Entrez un nom à votre ville:");
        try (Scanner scanner = new Scanner(System.in)) {
            ville = new Ville(scanner.nextLine());
        }
        ville.setResidents(10);
        enableKeyTypedInConsole(true);
        while (true) {
            clearMyScreen();

            if(msUntilNextWeek < 0) {
                ville.incrementWeek();
                ville.addMoney(Utils.getIncomeForWeek(ville.getResidents()));
                ville.setResidents(ville.getResidents() + 1);
                msUntilNextWeek = WEEK_LENGTH;
            }
            printHeader("    " + ville.getMoney() + "$", Utils.getIncomeForWeek(ville.getResidents()) / (WEEK_LENGTH / 1000) + "$/s        semaine n°" + ville.getWeek() + "    \r");
            printHeader("← Cliquer / Ville / Fusée →", "Utilisez les flèches pour changer de menu");
            
            switch (screen) {
                case 0:
                    new Click();
                    break;
                case 1:
                    new Magasin(ville);
                    break;
                case 2:
                    new Fusee();
                    break;  
            }

            Thread.sleep(100);
            msUntilNextWeek -= 100;
        }
    }

    protected void keyTypedInConsole(int keyCode) {
        switch (keyCode) {
            case 19:
                screen--;
                break;
            case 20:
                screen++;
                break;
            default:
                break;
        }
        if(screen == 0 && keyCode == 32) {
            ville.addMoney(Utils.getIncomeForClick(ville.getResidents()));
        }
    }


    /**
     * @param left_label Le label qui sera affiché à gauche
     * @param right_label Le label qui sera affiché à droite
     */
    public void printHeader(String left_label, String right_label) {

        System.out.print(Utils.WHITE_BACKGROUND + left_label);
        for (int i = 0; i < Utils.SCREEN_WIDTH - (left_label.length() + right_label.length()); i++) {
            System.out.print(' ');
        }
        System.out.print(right_label + Utils.RESET + "\n");
    }
}
