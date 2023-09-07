package com.cosmopolis;

public class Alert {

    public boolean important = false;
    public boolean positive = false;
    public String label = "";
    public int timeLeft = 2000;

    Alert(String label) {
        this.important = false;
        this.label = label;
    }
    
    Alert(boolean important, String label) {
        this.important = important;
        this.label = label;
        timeLeft = 8000;
    }
    
    Alert(boolean important, String label, boolean positive) {
        this.important = important;
        this.label = label;
        this.positive = positive;
        timeLeft = 8000;
    }

}
