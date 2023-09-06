package com.cosmopolis.interfaces;

import java.io.IOException;

import com.cosmopolis.Utils;

public class DefilementVille extends Fenetre {
     public void defiler() throws IOException, InterruptedException {
        int i = 1;
        while(true) {
            if(i != 11) {
               Utils.printTxt("src/com/cosmopolis/dessins/village/" + i + ".txt");
               Thread.sleep(200);
            } else {
               int a = 1;
               int b = 0;
               int c = 0;

               for(int j = 0; j < 20; j++) {
                  clearMyScreen();
                  if(a == 1) {
                     Utils.printTxt("src/com/cosmopolis/dessins/village/" + i + "-a.txt");
                     a = 0; b = 1; c = 0;
                  } else if(b == 1) {
                     Utils.printTxt("src/com/cosmopolis/dessins/village/" + i + "-b.txt");
                     a = 0; b = 0; c = 1;
                  } else {
                     Utils.printTxt("src/com/cosmopolis/dessins/village/" + i + "-c.txt");
                     a = 1; b = 0; c = 0;
                  }
                  Thread.sleep(80);
              }
            }
            clearMyScreen();
            i = (i == 11) ? 1 : i+1;
        }
     }

     public static void main(String[] args) throws IOException, InterruptedException {
        DefilementVille defilement = new DefilementVille();
        defilement.defiler();
     }
}
