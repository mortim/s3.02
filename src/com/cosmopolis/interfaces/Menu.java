package com.cosmopolis.interfaces;

import java.io.IOException;

import com.cosmopolis.Controls;
import com.cosmopolis.Utils;

public class Menu extends Controls {
    public Menu() throws IOException {
        println(Utils.RED_BOLD);
        Utils.printTxt("src/com/cosmopolis/dessins/logo.txt");
        sleep(1000);
        clearMyScreen();
        Utils.printTxt("src/com/cosmopolis/dessins/comment_jouer.txt");
        sleep(4000);
    }

    protected void keyTypedInConsole(int keyCode) {
        println(keyCode);
    }
}
