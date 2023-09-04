package com.cosmopolis;
import java.util.Scanner;

public class Jeu {
    Jeu() throws InterruptedException {
        
        System.out.println("Entrez un nom à votre ville:");
        Scanner scanner = new Scanner(System.in);
        Ville ville = new Ville(scanner.nextLine());
        scanner.close();
        ville.setResidents(10);
        while (true) {
            ville.addMoney(Semaine.getIncomeForWeek(ville.getResidents()));
            System.out.println("\033\143"); // effacer la console
            System.out.println("            +");
            System.out.println("            / \\");
            System.out.println("_____        _____     __________/ o \\/\\_________      _________");
            System.out.println("|o o o|_______|    |___|               | | # # #  |____|o o o o  |  /\\");
            System.out.println("|o o o|  * * *|: ::|. .|               |o| # # #  |. . |o o o o  | /|\\");
            System.out.println("|o o o|* * *  |::  |. .| []  []  []  []|o| # # #  |. . |o o o o  |((|))");
            System.out.println("|o o o|**  ** |:  :|. .| []  []  []    |o| # # #  |. . |o o o o  |((|))");
            System.out.println("|_[]__|__[]___|_||_|__<|____________;;_|_|___/\\___|_.|_|____[]___|  |");
            ville.incrementWeek();
            System.out.println(ville);
            Thread.sleep(1000);
        }
    }
}
