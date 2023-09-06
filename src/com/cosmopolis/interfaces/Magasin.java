package com.cosmopolis.interfaces;

import java.io.IOException;
import java.util.Random;

import com.cosmopolis.Controls;
import com.cosmopolis.Utils;
import com.cosmopolis.Ville;
import com.cosmopolis.batiments.AbriBatiment;
import com.cosmopolis.batiments.Batiment;
import com.cosmopolis.batiments.CasernePoliceBatiment;
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

    public void update() {
        System.out.print(Utils.BLACK_BOLD);
        try {
            if(ville.getTotalBatiments("MaisonBatiment") == 0) {
                Utils.printTxt("src/com/cosmopolis/dessins/village/1.txt");
            } else if(ville.getTotalBatiments("MaisonBatiment") < 5) {
                Utils.printTxt("src/com/cosmopolis/dessins/village/2.txt");
            } else {
                Utils.printTxt("src/com/cosmopolis/dessins/village/3.txt");
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
        printLabel(6, new LaboratoireBatiment());
        // printLabel(7, new AbriBatiment());
        // printLabel(8, new CasernePoliceBatiment());
        // printLabel(9, new CasernePompierBatiment());
        // System.out.print("\r\n");
        // Random random = new Random();
        // printProgressBar("Protection surpopulation", random.nextDouble(), Utils.GREEN_BACKGROUND, 30);
        // System.out.print("    ");
        // printProgressBar("Sécurité", random.nextDouble(), Utils.BLUE_BACKGROUND, 30);
        // System.out.print("\r\n");
        // printProgressBar("Protection aux incendies", random.nextDouble(), Utils.RED_BACKGROUND, 30);
        // System.out.print("    ");
        // printProgressBar("Protection aux séismes", random.nextDouble(), Utils.YELLOW_BACKGROUND, 30);

        
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
            println(s + count + " " + Utils.RESET + batiment.getLabel() + Utils.BLACK + " (" + (int) batiment.getTotalPrice(count) + "$)" + Utils.RESET);
        } else {
            println(Utils.RED_BOLD + "    [???]" + Utils.BLACK + " Il vous manque " + Utils.RED + (batiment.getLanding() - ville.getResidents()) + Utils.BLACK + " habitants pour ce bâtiment!");
        }
    }
}
