package com.cosmopolis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Utils {

    public static final int SCREEN_WIDTH = 80;

    public static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE

    // Bold
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE

    // Underline
    public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
    public static final String RED_UNDERLINED = "\033[4;31m";    // RED
    public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
    public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
    public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
    public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
    public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
    public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE

    public static final String BLACK_BACKGROUND = "\u001B[40m";
    public static final String RED_BACKGROUND = "\u001B[41m";
    public static final String GREEN_BACKGROUND = "\u001B[42m";
    public static final String YELLOW_BACKGROUND = "\u001B[43m";
    public static final String BLUE_BACKGROUND = "\u001B[44m";
    public static final String PURPLE_BACKGROUND = "\u001B[45m";
    public static final String CYAN_BACKGROUND = "\u001B[46m";
    public static final String WHITE_BACKGROUND = "\u001B[47m";

    /**
     * @param residents Le nombre total d'habitants
     * @return Renvoie le nombre total d'argents gagnés par un clic.
     */
    public static float getIncomeForWeek(int residents) {
        return (float) residents * 0.25f;
    }

    
    /**
     * @param residents Le nombre total d'habitants
     * @return Renvoie le nombre total d'argents gagnés par un clic.
     */
    public static float getIncomeForClick(int residents) {
        return (float) (residents * 0.5);
    }

    public static float getBuildingPrice(float basePrice, int count) {
        return (float) (basePrice * Math.pow(1.04, count));
    }


    public static void printTxt(String path) throws IOException {
        Scanner input = new Scanner(new FileReader(path));
        while (input.hasNextLine())
        {
           System.out.print("\r" + input.nextLine() + "\r\n");
        }
    }



    public static String lireFichier(String filepath) throws FileNotFoundException {
        String output = "";
        Scanner sc = new Scanner(new File(filepath));
        while(sc.hasNextLine())
            output += sc.nextLine() + "\n";
        sc.close();
        return output;
    }

    public static void quitter() {
        System.out.print(Utils.RED_UNDERLINED + "Vous avez quitté le jeu." + Utils.RESET + "\r\n");
        System.exit(0);
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
    
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
