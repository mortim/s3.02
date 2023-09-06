package com.cosmopolis;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import com.cosmopolis.evenements.Evenement;
import com.cosmopolis.evenements.RandomEvent;
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
    public int screen = 0;
    public int lastScreen = -99;

    public Fenetre currentScreen;
    /**
     * Les données du joueur
     */
    public Ville ville;
    public ArrayList<Alert> alerts = new ArrayList<>();
    public int semainesDepuisEvenement = 0;

    
    Jeu(String nom) throws InterruptedException, IOException {
        Random random = new Random();
        ville = new Ville(nom);
        enableKeyTypedInConsole(true);

        ville.setMoney(500);
        while (true) {
            clearMyScreen();
            
            if(msUntilNextWeek < 0) {
                semainesDepuisEvenement += 1;
                
                if(ville.getResidents() > 1000 && semainesDepuisEvenement > 7) {
                    boolean evenementPassee = false;
                    // if(random.nextDouble() > (1.0 - Math.pow(ville.abriParHabitants(), 2))) {
                    //     RandomEvent randomEvent = new RandomEvent(ville, Evenement.SEISME);
                    //     addAlert(true, randomEvent.createEvent());
                    // }
                    if(random.nextDouble() > Math.pow(ville.policeParHabitants(), 2)) {
                        RandomEvent randomEvent = new RandomEvent(ville, Evenement.BRAQUAGE);
                        addAlert(true, randomEvent.createEvent());
                        evenementPassee = true;
                    } else
                    if(random.nextDouble() > Math.pow(ville.pompiersParHabitants(), 2)) {
                        RandomEvent randomEvent = new RandomEvent(ville, Evenement.INCENDIE);
                        addAlert(true, randomEvent.createEvent());
                        evenementPassee = true;
                    } else
                    if (random.nextDouble() > Math.pow(ville.abriParHabitants(), 2)) {
                        RandomEvent randomEvent = new RandomEvent(ville, Evenement.SEISME);
                        addAlert(true, randomEvent.createEvent());
                        evenementPassee = true;
                    }

                    if(evenementPassee) {
                        semainesDepuisEvenement = 0;
                    }
                    
                }

                ville.incrementWeek();
                ville.addMoney(Utils.getIncomeForWeek(ville.getResidents()));
                if(ville.getResearchPointsForWeek() > 0.0) {
                    ville.research += ville.getResearchPointsForWeek();
                }
                msUntilNextWeek = WEEK_LENGTH;
            }
            printHeader(
                Utils.WHITE_BACKGROUND + "  " + (int) ville.getMoney() + "$  " + Utils.GREEN_BACKGROUND + "  " + (int) Utils.getIncomeForWeek(ville.getResidents()) + "$/sem  " + Utils.WHITE_BACKGROUND,
                Utils.PURPLE_BACKGROUND + "  " + ville.getResidents() + " hab.  " + Utils.BLUE_BACKGROUND + "  semaine n°" + ville.getWeek() + "  \r" + Utils.RESET);
            
            printHeader(
                Utils.WHITE_BACKGROUND + Utils.WHITE_BOLD + "Ville de " + ville.getName(),
                Utils.BLUE_BACKGROUND + "  " + Utils.round(ville.getResearch(), 2) + " points de recherche (" + Utils.round(ville.getResearchPointsForWeek(), 2) +"/sem)");
            if(screen != lastScreen) {
                updateScreen();
            }            
            currentScreen.update();
            for (int i = alerts.size() - 1; i >= 0; i--) {
                Alert alert = alerts.get(i);
                printAlert(alert.label, alert.important);
                alert.timeLeft -= TICK_LENGTH;
                if(alert.timeLeft < 0) {
                    alerts.remove(alert);
                }
            }
            
            sleep(TICK_LENGTH);
            msUntilNextWeek -= TICK_LENGTH;
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
                currentScreen = new Fusee(ville);
                break;  
        }
        lastScreen = screen;
    }

    public void tryToBuy(int choice) {
        int result = ville.buy(choice);
        if(result == 1) {
            addAlert(false, "Vous n'avez pas assez d'argent.");
        } else if(result == 2) {
            addAlert(false, "Vous n'avez pas assez d'habitants.");
        }
    }

    public void addAlert(boolean important, String message) {
        if(alerts.size() <= 5) {
            alerts.add(new Alert(important, message));
        } else if(important) {
            alerts.remove(0);
            alerts.add(new Alert(important, message));
        }
    }

    protected void keyTypedInConsole(int keyCode) throws InterruptedException, IOException {
        // System.out.println(keyCode);
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
                if(keyCode == Raccourcis.PAVE_1.getID() || keyCode == Raccourcis.SPECIAUX_1.getID()) {
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
                } else if(keyCode == Raccourcis.PAVE_7.getID() || keyCode == Raccourcis.SPECIAUX_7.getID()) {
                    tryToBuy(7);
                } else if(keyCode == Raccourcis.PAVE_8.getID() || keyCode == Raccourcis.SPECIAUX_8.getID()) {
                    tryToBuy(8);
                } else if(keyCode == Raccourcis.PAVE_9.getID() || keyCode == Raccourcis.SPECIAUX_9.getID()) {
                    tryToBuy(9);
                } else if(keyCode == Raccourcis.PAVE_0.getID() || keyCode == Raccourcis.SPECIAUX_0.getID()) {
                    tryToBuy(10);
                }
            
                
                break;
            case 2:
                if(keyCode == Raccourcis.F.getID()) {
                    Fusee f = (Fusee) currentScreen;
                    if(ville.getMoney() < 1000.0) {
                        alerts.add(new Alert("Vous n'avez pas assez d'argent!"));
                        return;
                    }
                    if(f.state == Fusee.State.NONE || (f.state == Fusee.State.END && !ville.canWin())) {
                        f.send();
                        ville.removeMoney(1000.0f);
                    }
                }
        }
        if(keyCode == Raccourcis.S.getID()) { // sauvegarder
            Sauvegarde sauvegarde = new Sauvegarde("/tmp/save.dat");
            sauvegarde.sauvegarder(ville);
        }
        
        if(keyCode == Raccourcis.L.getID()) { // charger
            ville = new Sauvegarde("/tmp/save.dat").lire();
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

        System.out.print(left_label);
        for (int i = 0; i < Utils.SCREEN_WIDTH - (left_label.length() + right_label.length()); i++) {
            System.out.print(' ');
        }
        System.out.print(right_label + Utils.RESET + "\n");
    }

    public void printAlert(String alert, boolean important) {
        if(important) {
            System.out.print("\r\n" + Utils.RED_BACKGROUND + " EVENEMENT " + Utils.YELLOW_BACKGROUND + " ");
        } else {
            System.out.print("\r\n" + Utils.BLUE_BACKGROUND + " ! " + Utils.WHITE_BACKGROUND + " ");
        }
        
        System.out.print(alert);
        for (int i = 0; i < Utils.SCREEN_WIDTH - (alert.length() + 4); i++) {
            System.out.print(' ');
        }
        System.out.print(Utils.RESET + "\r\n");
    }

}
