package com.typhoon0678.learnspringframework;

import com.typhoon0678.learnspringframework.game.GameRunner;
import com.typhoon0678.learnspringframework.game.MarioGame;
import com.typhoon0678.learnspringframework.game.PacmanGame;

public class App01GamingBasicJava {

    public static void main(String[] args) {

//        var game = new MarioGame();
//        var game = new SuperContraGame();
        var game = new PacmanGame();
        var gameRunner = new GameRunner(game);
        gameRunner.run();

    }

}
