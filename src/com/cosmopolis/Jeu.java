package com.cosmopolis;
import java.io.IOException;
import java.util.ArrayList;

import com.cosmopolis.interfaces.Click;
import com.cosmopolis.interfaces.Fenetre;
import com.cosmopolis.interfaces.Fusee;
import com.cosmopolis.interfaces.Magasin;

public class Jeu extends Controls {

    /**
     * La longueur d'une semaine en millisecondes.
     */
    public final int WEEK_LENGTH = 3000;

    public final int TICK_LENGTH = 100;
    /**
     * Le nombre de millisecondes avant le jour suivant.
     */
    public int msUntilNextWeek = 0;

    /**
     * L'écran sur laquelle le joueur se trouve actuellement (0 = cliquer, 1 = acheter des bâtiments, 2 = envoyer une fusée)
     */
    public int screen = 1;
    public int lastScreen = -99;

    public Fenetre currentScreen;
    /**
     * Les données du joueur
     */
    public Ville ville;
    public ArrayList<Alert> alerts = new ArrayList<>();

    
    Jeu() throws InterruptedException, IOException {
        // Menu menu new Menu(this);
        // menu();
    
        // println("Entrez un nom à votre ville:");
        // try (Scanner scanner = new Scanner(System.in)) {
        //     ville = new Ville(scanner.nextLine());
        // }
        ville = new Ville("Lille");
        enableKeyTypedInConsole(true);
        ville.setMoney(100);
        while (true) {
            clearMyScreen();

            if(msUntilNextWeek < 0) {
                ville.incrementWeek();
                ville.addMoney(Utils.getIncomeForWeek(ville.getResidents()));
                msUntilNextWeek = WEEK_LENGTH;
            }
            printHeader(
                "  " + (int) ville.getMoney() + "$  " + Utils.GREEN_BACKGROUND + "  " + (int) Utils.getIncomeForWeek(ville.getResidents()) + "$/sem  " + Utils.WHITE_BACKGROUND,
                Utils.BLUE_BACKGROUND + "  semaine n°" + ville.getWeek() + "  \r" + Utils.RESET);
            // printHeader("← Cliquer / Ville / Fusée →", "Utilisez les flèches pour changer de menu");

            if(screen != lastScreen) {
                updateScreen();
            }            
            currentScreen.update();
            for (int i = alerts.size() - 1; i >= 0; i--) {
                Alert alert = alerts.get(i);
                printAlert(alert.label);
                alert.timeLeft -= 100;
                if(alert.timeLeft < 0) {
                    alerts.remove(alert);
                }
            }
            
            sleep(100);
            msUntilNextWeek -= 100;
        }
    }

    public void updateScreen() throws InterruptedException, IOException {
        switch (screen) {
            // case -1:
                // currentScreen = new Menu();
            case 0:
                currentScreen = new Click();
                break;
            case 1:
                currentScreen = new Magasin(ville);
                break;
            case 2:
                currentScreen = new Fusee();
                break;  
        }
        lastScreen = screen;
    }

    public void tryToBuy(int choice) {
        if(!ville.buy(choice)) {
            alerts.add(new Alert("Vous n'avez pas assez d'argent!"));
        };
    }

    protected void keyTypedInConsole(int keyCode) throws InterruptedException, IOException {
        switch (screen) {
            case -1:
                if(keyCode == Raccourcis.PAVE_1.getID() || keyCode == Raccourcis.PAVE_1.getID()) {
                    screen = 1;
                    updateScreen();
                } else if(keyCode == Raccourcis.PAVE_2.getID() || keyCode == Raccourcis.SPECIAUX_2.getID()) {
                    tryToBuy(2);
                }
                break;
        
            case 1:
                if(keyCode == Raccourcis.PAVE_1.getID() || keyCode == Raccourcis.PAVE_1.getID()) {
                    tryToBuy(1);
                } else if(keyCode == Raccourcis.PAVE_2.getID() || keyCode == Raccourcis.SPECIAUX_2.getID()) {
                    tryToBuy(2);
                } else if(keyCode == Raccourcis.PAVE_3.getID() || keyCode == Raccourcis.SPECIAUX_3.getID()) {
                    tryToBuy(3);
                } else if(keyCode == Raccourcis.PAVE_4.getID() || keyCode == Raccourcis.SPECIAUX_4.getID()) {
                    tryToBuy(4);
                } else if(keyCode == Raccourcis.PAVE_5.getID() || keyCode == Raccourcis.SPECIAUX_5.getID()) {
                    tryToBuy(5);
                } else if(keyCode == Raccourcis.PAVE_6.getID() || keyCode == Raccourcis.SPECIAUX_6.getID()) {
                    tryToBuy(6);
                }
                break;
        }
        if(keyCode == Raccourcis.Q.getID()) {
            Utils.quitter();
        }
        
        switch (keyCode) {
            case 19:
                if(screen > 0) {
                    screen--;
                }
                break;
            case 20:
                if(screen < 2) {
                    screen++;
                }
                break;
            default:
                break;
        }
        if(screen == 0 && keyCode == 32) {
            ville.addMoney(Utils.getIncomeForClick(ville.getResidents()));
        }
    }


    /**
     * @param left_label Le label qui sera affiché à gauche
     * @param right_label Le label qui sera affiché à droite
     */
    public void printHeader(String left_label, String right_label) {

        System.out.print(Utils.WHITE_BACKGROUND + left_label);
        for (int i = 0; i < Utils.SCREEN_WIDTH - (left_label.length() + right_label.length()); i++) {
            System.out.print(' ');
        }
        System.out.print(right_label + Utils.RESET + "\n");
    }

    public void printAlert(String alert) {
        System.out.print("\r\n" + Utils.BLUE_BACKGROUND + " ! " + Utils.WHITE_BACKGROUND + " ");

        System.out.print(Utils.WHITE_BACKGROUND + alert);
        for (int i = 0; i < Utils.SCREEN_WIDTH - (alert.length() + 4); i++) {
            System.out.print(' ');
        }
        System.out.print(Utils.RESET + "\r\n");
    }

}
