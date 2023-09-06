package com.cosmopolis.interfaces;


public class Click extends Fenetre {
    public Click() {
        println("test");
    }

    protected void println(Object content) {
        System.out.print("\r" + content + "\r\n");
    }
}
