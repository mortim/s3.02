package com.cosmopolis;

public class Alert {

    public boolean important = false;
    public String label = "";
    public int timeLeft = 3000;

    Alert(String label) {
        this.important = false;
        this.label = label;
    }
    
    Alert(boolean important, String label) {
        this.important = important;
        this.label = label;
        timeLeft = 6000;
    }

}
