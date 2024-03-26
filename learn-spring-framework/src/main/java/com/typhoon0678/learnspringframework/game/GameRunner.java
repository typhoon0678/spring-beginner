package com.typhoon0678.learnspringframework.game;

import com.typhoon0678.learnspringframework.game.MarioGame;

public class GameRunner {

    private GamingConsole game;

    public GameRunner(GamingConsole game) {
        this.game = game;
    }

    public void run() {
        System.out.println("Running game : " + game);

        game.up();
        game.down();
        game.left();
        game.right();
    }
}
