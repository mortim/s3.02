package com.cosmopolis;
import java.util.Scanner;

public class Interactions {
    
    private Scanner stringScanner;
    private String inputString;

    /**
     * @return Renvoie un int en fonction de la saisie de l'utilisateur.
     */
    public int voirInput() throws NumberFormatException {
        stringScanner = new Scanner(System.in);
        inputString = stringScanner.next();
        stringScanner.close();
        return Integer.parseInt(inputString);
    }

}