package com.cosmopolis;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.cosmopolis.batiments.Batiment;
import com.cosmopolis.batiments.MaisonBatiment;

public class Jeu {

    public final int WEEK_LENGTH = 2500;

    Map<String, Batiment> batiments = new HashMap<String, Batiment>();
    
    Jeu() throws InterruptedException {
        // map.put("house", new MaisonBatiment());
        // map.put("house", new MaisonBatiment());
        // map.put("house", new MaisonBatiment());
        // map.put("house", new MaisonBatiment());
        // map.put("house", new MaisonBatiment());
        // map.put("house", new MaisonBatiment());
        
        System.out.println("Entrez un nom à votre ville:");
        Scanner scanner = new Scanner(System.in);
        Ville ville = new Ville(scanner.nextLine());
        ville.setResidents(10);
        while (true) {
            ville.incrementWeek();
            ville.addMoney(Semaine.getIncomeForWeek(ville.getResidents()));
            ville.setResidents(ville.getResidents() + 1);
            System.out.println("\033\143"); // effacer la console
            printHeader(ville);
            System.out.println(Utils.BLACK_BOLD + "                                    +");
            System.out.println("                                   / \\");
            System.out.println(" _____        _____     __________/ o \\/\\_________      _________");
            System.out.println("|o o o|_______|    |___|               | | # # #  |____|o o o o  |  /\\");
            System.out.println("|o o o|  * * *|: ::|. .|               |o| # # #  |. . |o o o o  | /|\\");
            System.out.println("|o o o|* * *  |::  |. .| []  []  []  []|o| # # #  |. . |o o o o  |((|))");
            System.out.println("|o o o|**  ** |:  :|. .| []  []  []    |o| # # #  |. . |o o o o  |((|))");
            System.out.println("|_[]__|__[]___|_||_|__<|____________;;_|_|___/\\___|_.|_|____[]___|  |");
            System.out.println(Utils.BLUE_BOLD + ville);

            printLabel(1, 10, ville.getTotalHouses(), "maisons");
            printLabel(2, 50, ville.getTotalShops(), "commerces");
            printLabel(3, 250, ville.getTotalBuildings(), "immeubles");
            printLabel(4, 1000, ville.getTotalSchools(), "écoles");
            printLabel(5, 5000, ville.getTotalFactories(), "industries");
            printLabel(6, 50000, ville.getTotalLaboratories(), "laboratoires");

            printProgressBar("Habitants", 0.1, Utils.GREEN_BACKGROUND, 30);
            System.out.print("    ");
            printProgressBar("Recherche", 0.1, Utils.BLUE_BACKGROUND, 30);
            System.out.println();
            printProgressBar("Popularité", 0.1, Utils.YELLOW_BACKGROUND, 30);

            // String inputString = scanner.next();
            // System.out.println(inputString);
            Thread.sleep(1000);
        }
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

    public void printLabel(int id, int price, int count, String label) {
        System.out.println(Utils.BLACK + "    [" + id + "] " + Utils.GREEN_BOLD + count + " " + Utils.RESET + label + Utils.BLACK + " (" + (int) Utils.getBuildingPrice(price, count) + "$)" + Utils.RESET);
    }

    private final int SCREEN_WIDTH = 80;

    public void printHeader(Ville ville) {
        String left_label = "    " + ville.getMoney() + "$";
        String right_label =  Semaine.getIncomeForWeek(ville.getResidents()) / (WEEK_LENGTH / 1000) + "$/s        semaine n°" + ville.getWeek() + "    ";

        System.out.print(Utils.WHITE_BACKGROUND + left_label);
        for (int i = 0; i < SCREEN_WIDTH - (left_label.length() + right_label.length()); i++) {
            System.out.print(' ');
        }
        System.out.print(right_label + Utils.RESET + "\n");
    }
    
    public void printAlert(String alert) {
        System.out.print("\n" + Utils.BLUE_BACKGROUND + " ! " + Utils.WHITE_BACKGROUND + " ");

        System.out.print(Utils.WHITE_BACKGROUND + alert);
        for (int i = 0; i < SCREEN_WIDTH - (alert.length() + 4); i++) {
            System.out.print(' ');
        }
        System.out.print(Utils.RESET + "\n");
    }
}
