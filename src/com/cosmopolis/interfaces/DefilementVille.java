package com.cosmopolis.interfaces;

import java.io.IOException;

import com.cosmopolis.Utils;

public class DefilementVille extends Fenetre {
     public void defiler() throws IOException, InterruptedException {
        int i = 1;
        while(true) {
            Utils.printTxt("src/com/cosmopolis/dessins/village/" + i + ".txt");
            Thread.sleep(300);
            clearMyScreen();
            i = (i == 13) ? 1 : i+1;
        }
     }

     public static void main(String[] args) throws IOException, InterruptedException {
        DefilementVille defilement = new DefilementVille();
        defilement.defiler();
     }
}
