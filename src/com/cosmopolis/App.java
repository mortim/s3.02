package com.cosmopolis;

import java.io.IOException;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws InterruptedException, IOException {

        println("                                    ,:                       ");
        println("                                  ,' |                       ");
        println("                                /   :                        ");
        println("                              --'   /                        ");
        println("                              \\/ />/                        ");
        println("                              / <//_\\                       ");
        println("                          __/   /                            ");
        println("                          )'-. /                             ");
        println(Utils.YELLOW + "                          ./  :\\                            ");
        println(Utils.YELLOW + "                            /.' '                            ");
        println(Utils.YELLOW + "                          '/'                                ");
        println(Utils.YELLOW + "                          +                                  ");
        println(Utils.RED + "                        '                                    ");
        println(Utils.RED + "                      `.                                     ");
        println(Utils.RED + "                  .-\"-                                      ");
        println(Utils.RED + "                  (    |                                     ");
        println(Utils.BLACK_BOLD + "              . .-'  '.                                      ");
        println(Utils.BLACK_BOLD + "              ( (.   )8:                                     ");
        println(Utils.BLACK_BOLD + "          .'    / (_  )                                      ");
        println(Utils.BLACK_BOLD + "          _. :(.   )8P  `                                    " + Utils.RESET);
        println("   ____                                      _ _             ");
        println("  / ___|___  ___ _ __ ___   ___  _ __   ___ | (_)____        ");
        println(" | |   / _ \\/ __| '_ ` _ \\ / _ \\| '_ \\ / _ \\| | / __|   ");
        println(" | |__| (_) \\__ \\ | | | | | (_) | |_) | (_) | | \\__ \\    ");
        println("  \\____\\___/|___/_| |_| |_|\\___/| .__/ \\___/|_|_|___/    ");
        println("                                |_|                          ");
        println("            Poussez le clic jusqu'à l'innovation             ");
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
}
