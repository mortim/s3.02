package com.cosmopolis.interfaces;

import com.cosmopolis.Controls;

public class Click extends Fenetre {
    public Click() {
        println("test");
    }

    protected void println(Object content) {
        System.out.print("\r" + content + "\r\n");
    }
}
