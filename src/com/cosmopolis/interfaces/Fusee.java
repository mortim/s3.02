package com.cosmopolis.interfaces;

import com.cosmopolis.Controls;

public class Fusee extends Fenetre {
    public Fusee() {
        println("spaceship");
    }

    protected void println(Object content) {
        System.out.print("\r" + content + "\r\n");
    }
}
