package com.guuri11.lotrascii;

import com.guuri11.lotrascii.ascii.Title;
import com.guuri11.lotrascii.game.Game;
import com.guuri11.lotrascii.game.menu.Option;

/**
 * Application
 */
public class Application {

  public static void main(String[] args) {
    // Initializate game
    Title.getTitle();
    Game game = new Game();
    game.getMenu().load();

    // Handle menu option
    switch (game.getMenu().getOption()) {
      case Option.NEW_GAME -> game.play();
      case Option.EXIT -> game.exit();
    }

  }

}
