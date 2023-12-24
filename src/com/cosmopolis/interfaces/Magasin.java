package com.cosmopolis.interfaces;

import java.io.IOException;
import java.util.Random;

import com.cosmopolis.Controls;
import com.cosmopolis.Utils;
import com.cosmopolis.Ville;
import com.cosmopolis.batiments.AbriBatiment;
import com.cosmopolis.batiments.Batiment;
import com.cosmopolis.batiments.PostePoliceBatiment;
import com.cosmopolis.batiments.CasernePompierBatiment;
import com.cosmopolis.batiments.CommerceBatiment;
import com.cosmopolis.batiments.EcoleBatiment;
import com.cosmopolis.batiments.ImmeubleBatiment;
import com.cosmopolis.batiments.IndustrieBatiment;
import com.cosmopolis.batiments.LaboratoireBatiment;
import com.cosmopolis.batiments.MaisonBatiment;
import com.cosmopolis.batiments.TourismeBatiment;

public class Magasin extends Fenetre {
    Ville ville;
    public Magasin(Ville ville) {
        this.ville = ville;
    }

    public int frame = 0;
    public int half = 0;

    public void update() {
        if(half == 0) {
            frame += 1;
            half = 3;
        } else {
            half -= 1;
        }
        
        frame = frame % 12;

        System.out.print(Utils.BLACK_BOLD);
        try {
            if(ville.getResidents() == 0) {
                Utils.printTxt("/com/cosmopolis/dessins/village/arbre.txt");
            } else if(ville.getResidents() <= 10) {
                Utils.printTxt("/com/cosmopolis/dessins/village/maison.txt");
            } else if(ville.getResidents() <= 1000) {
                Utils.printTxt("/com/cosmopolis/dessins/village/village.txt");
            } else if(ville.getResidents() >= 1000) {
                Utils.printTxt("/com/cosmopolis/dessins/village/" + frame +".txt");
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        println(Utils.RESET);
        

        
        printLabel(1, new MaisonBatiment());
        printLabel(2, new CommerceBatiment());
        printLabel(3, new ImmeubleBatiment());
        printLabel(4, new IndustrieBatiment());
        printLabel(5, new EcoleBatiment());

        printLabel(6, new AbriBatiment());
        printLabel(7, new PostePoliceBatiment());
        printLabel(8, new CasernePompierBatiment());
        
        printLabel(9, new LaboratoireBatiment());
        System.out.print("\r\n");
        Random random = new Random();
        if(ville.getResidents() > 1000) {
            printProgressBar("Education", ville.ecoleParHabitants(), Utils.GREEN_BACKGROUND, 30);
            System.out.print("    ");
            printProgressBar("Protection aux séismes", ville.abriParHabitants(), Utils.YELLOW_BACKGROUND, 30);
            System.out.print("\r\n");
            printProgressBar("Sécurité", ville.policeParHabitants(), Utils.BLUE_BACKGROUND, 30);
            System.out.print("    ");
            printProgressBar("Protection aux incendies", ville.pompiersParHabitants(), Utils.RED_BACKGROUND, 30);
        }
        System.out.print("\r\n");
        if(ville.getResidents() > 0) {
            printProgressBar("   Population (" + ville.getResidents() + "/" + ville.getTotalBar() + ")", (float) ((float) ville.getResidents() / (float) ville.getTotalBar()), Utils.GREEN_BACKGROUND, 60);
        }

        println(' ');        
        // printAlert("7 de vos habitants sont morts");
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



    public void printLabel(int id, Batiment batiment) {
        if(ville.getResidents() >= batiment.getLanding()) {
            int count = ville.getTotalBatiments(batiment.getClass().getSimpleName());
            String s = Utils.BLACK + "    [" + id + "] ";
            if(batiment.getTotalPrice(count) <= ville.getMoney()) {
                s += Utils.GREEN_BOLD;
            } else {
                s += Utils.RED_BOLD;
            }
            println(s + count + " " + Utils.RESET + batiment.getLabel() + Utils.BLACK + " (" + (int) batiment.getTotalPrice(count) + "€)" + Utils.RESET);
        } else {
            println(Utils.RED_BOLD + "    [???]" + Utils.BLACK + " Il vous manque " + Utils.RED + (batiment.getLanding() - ville.getResidents()) + Utils.BLACK + " habitants pour ce bâtiment!");
        }
    }
}
