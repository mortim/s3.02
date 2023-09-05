package com.cosmopolis;

public class Semaine {
    /**
     * @param residents Le nombre total d'habitants
     * @return Renvoie le nombre total d'argents gagnés par un clic.
     */
    public static float getIncomeForWeek(int residents) {
        return (float) residents;
    }
    
    /**
     * @param residents Le nombre total d'habitants
     * @return Renvoie le nombre total d'argents gagnés par un clic.
     */
    public static float getIncomeForClick(int residents) {
        return (float) (residents * 0.5);
    }
}
