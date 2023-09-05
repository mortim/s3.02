package com.cosmopolis;

import java.io.IOException;

import com.cosmopolis.interfaces.Menu;

public class App extends Controls {
    public static void main(String[] args) throws InterruptedException, IOException {
        // Menu du jeu
        new Menu();

        // Jeu
        new Jeu();
    }
}
