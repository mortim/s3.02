package com.cosmopolis;

import java.io.IOException;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws InterruptedException, IOException {

        println(Utils.WHITE_BOLD + "                                    ,:                       ");
        println("                                  ,' |                       ");
        println("                                /   :                        ");
        println("                              --'   /                        ");
        println("                              \\/ />/                        ");
        println("                              / <//_\\                       ");
        println("                          __/   /                            ");
        println("                          )'-. /                             ");
        println(RGBToANSI(new int[]{255, 255, 0}, false) + "                          ./  :\\                            ");
        println(RGBToANSI(new int[]{255, 219, 0}, false) + "                            /.' '                            ");
        println(RGBToANSI(new int[]{255, 182, 0}, false) + "                          '/'                                ");
        println(RGBToANSI(new int[]{255, 146, 0}, false) + "                          +                                  ");
        println(RGBToANSI(new int[]{255, 109, 0}, false) + "                        '                                    ");
        println(RGBToANSI(new int[]{219, 73, 0}, false) + "                      `.                                     ");
        println(RGBToANSI(new int[]{182, 36, 0}, false) + "                  .-\"-                                      ");
        println(RGBToANSI(new int[]{146, 0, 0}, false) + "                  (    |                                     ");
        println(RGBToANSI(new int[]{109, 0, 0}, false) + "              . .-'  '.                                      ");
        println(RGBToANSI(new int[]{73, 0, 0}, false) + "              ( (.   )8:                                     ");
        println(RGBToANSI(new int[]{36, 0, 0}, false) + "          .'    / (_  )                                      ");
        println(RGBToANSI(new int[]{0, 0, 0}, false) + "          _. :(.   )8P  `                                    " + Utils.RESET);
        println(RGBToANSI(new int[]{51, 204, 255}, false) + "   ____                                      _ _             ");
        println(RGBToANSI(new int[]{51, 173, 255}, false) + "  / ___|___  ___ _ __ ___   ___  _ __   ___ | (_)____        ");
        println(RGBToANSI(new int[]{51, 143, 255}, false) + " | |   / _ \\/ __| '_ ` _ \\ / _ \\| '_ \\ / _ \\| | / __|   ");
        println(RGBToANSI(new int[]{51, 112, 255}, false) + " | |__| (_) \\__ \\ | | | | | (_) | |_) | (_) | | \\__ \\    ");
        println(RGBToANSI(new int[]{51, 82, 255}, false) + "  \\____\\___/|___/_| |_| |_|\\___/| .__/ \\___/|_|_|___/    ");
        println(RGBToANSI(new int[]{51, 51, 255}, false) + "                                |_|                          ");
        println(Utils.BLACK + "\r\n        Poussez le clic jusqu'à l'innovation             ");
        println("");
        println("");
        println("");
        Scanner sc= new Scanner(System.in);  //System.in is a standard input stream  
        System.out.println(Utils.WHITE_BOLD + "Entrez le nom de votre ville:\r"); 
        String str = sc.next();
        Jeu jeu = new Jeu(str);
    }

    protected static void println(Object content) {
        System.out.print("\r" + content + "\r\n");
    }

    /**
   * Converts an RGB color to an ANSI color.
   * ANSI allows us to color texts and control the cursor's position.
   * Note that transparency isn't allowed.
   * @param rgb A list of 3 numbers between 0 and 255 (included), according to the RGB format.
   * @param backgroundColor Is the color supposed to only be used on the background?
   * @return The given color in ANSI format.
   */
    public static String RGBToANSI(int[] rgb, boolean backgroundColor) {
        return "\u001b[" + (backgroundColor ? "48" : "38") + ";2;" + rgb[0] + ";" + rgb[1] + ";" + rgb[2] + "m";
    }
}
