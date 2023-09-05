package com.cosmopolis;

import java.io.Console;
import java.io.IOException;
import java.io.Reader;

/**
 * Allows our code to actually detect the key inputs instead of writing them in the standard input.
 * This code is partially based on the work of <a href="https://www.cristal.univ-lille.fr/~ysecq/">Yann Secq</a> (author of iJava)
 */
public class Controls {
  /**
   * If the console is listening to key inputs from the console, then this is `true`.
   * By default, it will be `false`.
   */
  private boolean listeningConsole = false;

  /**
   * The thread listening to the key inputs, when `listeningConsole` is `true`.
   * Using a thread allows the process to not be blocked.
   */
  private Thread keyboardListener;

  /**
   * In order to detect the actual key presses of the user, without writing any of them, 
   * then this function needs to be called with `newState` set to `true`.
   * Disable this behaviour by using the same function, but with `newState` set to `false`.
   * @param newState Whether or not you want the terminal to be used as a detector of key presses.
   */
  protected void enableKeyTypedInConsole(boolean newState) {
    if (!listeningConsole && newState) {
      listeningConsole = true;
      keyboardListener = new Thread() {
        public void run() {
          try {
            String[] commands = new String[] { "/bin/sh", "-c", "stty raw </dev/tty" };
            Runtime.getRuntime().exec(commands).waitFor();
            Console console = System.console();
            Reader reader;

            for (reader = console.reader(); listeningConsole; Thread.sleep(100L)) {
              int keyInput = reader.read();
              if (keyInput == 27) { // Escape key
                keyInput = reader.read();
                if (keyInput == 91) { // Meta
                  keyInput = reader.read();
                  switch (keyInput) {
                    case 65:
                      keyTypedInConsole(17); // top arrow key
                      break;
                    case 66:
                      keyTypedInConsole(18); // bottom arrow key
                      break;
                    case 67:
                      keyTypedInConsole(20); // left arrow key
                      break;
                    case 68:
                      keyTypedInConsole(19); // right arrow key
                  }
                }
              } else {
                keyTypedInConsole(keyInput);
              }
            }

            reader.close();
          } catch (InterruptedException | IOException e) {
            e.printStackTrace();
          }
        }
      };
      keyboardListener.start();
    } else {
      listeningConsole = false;

      try {
        String[] commands = new String[] { "/bin/sh", "-c", "stty sane </dev/tty" };
        Runtime.getRuntime().exec(commands).waitFor();
      } catch (InterruptedException | IOException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * This function is meant to be overriden by any class inherited from `Controls`.
   * This is called if `listeningConsole` is set to `true`.
   * In order to set it to true, use `enableKeyTypedInConsole()`.
   * 
   * This function will be executed each time the user enters a key.
   * The key itself won't be displayed in the standard input.
   * @param keyCode The unique key code of the pressed key (an integer).
   */
  protected void keyTypedInConsole(int keyCode) { }

  /**
   * Allows the program to sleep for a while.
   * @param milliseconds The exact sleep duration in milliseconds.
   */
  protected void sleep(int milliseconds) {
    try {
      Thread.sleep((long)milliseconds);
    } catch (InterruptedException ignore) {}
  }

  /**
   * Moves the cursor to a specific position on the screen.
   * @param x The coordinates on the X-axis
   * @param y The coordinates on the Y-axis
   */
  protected void moveCursorTo(int x, int y) {
    System.out.print("\033[" + y + ";" + x + "H");
  }

  /**
   * Deletes everything there is on the console, if it's visible.
   * It also places the cursor to (0;0).
   */
  protected void clearMyScreen() {
    System.out.print("\033[2J");
    moveCursorTo(0,0);
  }

  /**
   * Saves the current position of the cursor.
   * The cursor will be directed to this position when `restoredCursorPosition` is called.
   */
  protected void saveCursorPosition() {
    System.out.print("\033[s");
  }

  /**
   * The cursor goes back to its previously saved position.
   */
  protected void restoreCursorPosition() {
    System.out.print("\033[u");
  }

  /**
   * The way `enableKeyTypedInConsole` works is that it changes the input mode of the commands via `stty raw`.
   * However, it causes a problem : the carriage returns (`\r`) are forgotten when adding a new line (via `\n`),
   * and as a consequence, when printing text onto the console, it creates a `staircase effect`.
   * 
   * This method must be used instead of the traditional `System.out.println()`.
   * 
   * More info here on
   * <a href="https://unix.stackexchange.com/a/366426">stackexchange</a>.
   * 
   * @param content The content to be printed.
   */
  protected void println(Object content) {
    System.out.print("\r" + content + "\r\n");
  }
}