package com.cosmopolis.interfaces;

import java.io.IOException;

public class Fenetre {
    public void update() throws IOException, InterruptedException {};

    protected void println(Object content) {
        System.out.print("\r" + content + "\r\n");
    }


    protected void clearMyScreen() {
        System.out.print("\033[2J");
        moveCursorTo(0,0);
    }

    protected void moveCursorTo(int x, int y) {
        System.out.print("\033[" + y + ";" + x + "H");
    }

    protected void sleep(int milliseconds) {
        try {
            Thread.sleep((long)milliseconds);
        } catch (InterruptedException ignore) {}
      }
}
