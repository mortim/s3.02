package com.cosmopolis;
import java.util.Scanner;

public class Interactions {
    
    private Scanner stringScanner;
    private String inputString;

    /**
     * @return Renvoie un int en fonction de la saisie de l'utilisateur.
     */
    public int voirInput(){
        stringScanner = new Scanner(System.in);
        inputString = stringScanner.next();
        if(inputString.equals("1")){
            return 1;
        } else if(inputString.equals("2")){
            return 2;
        }else if(inputString.equals("3")){
            return 3;
        } else {
            return 0;
        }
    }

}