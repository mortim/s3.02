package com.cosmopolis.interfaces;

import java.io.IOException;

import com.cosmopolis.Controls;
import com.cosmopolis.Utils;
import com.cosmopolis.Ville;

public class Magasin extends Controls {
    public Magasin(Ville ville) throws IOException {
        Utils.printTxt("src/com/cosmopolis/dessins/village.txt");
        println(Utils.BLUE_BOLD + ville);

        printLabel(1, 10, ville.getTotalBatiments("MaisonBatiment"), "maisons");
        printLabel(2, 50, ville.getTotalBatiments("CommerceBatiment"), "commerces");
        printLabel(3, 250, ville.getTotalBatiments("ImmeubleBatiment"), "immeubles");
        printLabel(4, 1000, ville.getTotalBatiments("EcoleBatiment"), "écoles");
        printLabel(5, 5000, ville.getTotalBatiments("IndustrieBatiment"), "industries");
        printLabel(6, 50000, ville.getTotalBatiments("LabortoireBatiment"), "laboratoires");

        printProgressBar("Habitants", 0.5, Utils.GREEN_BACKGROUND, 30);
        System.out.print("    ");
        printProgressBar("Recherche", 0.5, Utils.PURPLE_BACKGROUND, 30);
        System.out.print("\r\n");
        printProgressBar("Sécurité", 0.5, Utils.BLUE_BACKGROUND, 30);
        System.out.print("    ");
        printProgressBar("Incendies", 0.5, Utils.RED_BACKGROUND, 30);
        System.out.print("\r\n");
        printProgressBar("Séisme", 0.5, Utils.YELLOW_BACKGROUND, 30);
        
        printAlert("7 de vos habitants sont morts");
    }

    private void printProgressBar(String label, double progress, String background, int size) {
        for (int i = 0; i < size; i++) {
            if((float) i / (float) size > progress) {
                System.out.print(Utils.BLACK_BACKGROUND);
            } else {
                System.out.print(background);

            }
            if(i < label.length()) {
                System.out.print(label.charAt(i));
            } else {
                System.out.print(' ');
            }

        }
        System.out.print(Utils.RESET);
    }


    public void printAlert(String alert) {
        System.out.print("\r\n" + Utils.BLUE_BACKGROUND + " ! " + Utils.WHITE_BACKGROUND + " ");

        System.out.print(Utils.WHITE_BACKGROUND + alert);
        for (int i = 0; i < Utils.SCREEN_WIDTH - (alert.length() + 4); i++) {
            System.out.print(' ');
        }
        System.out.print(Utils.RESET + "\r\n");
    }

    public void printLabel(int id, int price, int count, String label) {
        println(Utils.BLACK + "    [" + id + "] " + Utils.GREEN_BOLD + count + " " + Utils.RESET + label + Utils.BLACK + " (" + (int) Utils.getBuildingPrice(price, count) + "$)" + Utils.RESET);
    }
}
