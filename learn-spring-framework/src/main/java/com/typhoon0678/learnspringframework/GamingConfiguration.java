package com.typhoon0678.learnspringframework;

import com.typhoon0678.learnspringframework.game.GameRunner;
import com.typhoon0678.learnspringframework.game.GamingConsole;
import com.typhoon0678.learnspringframework.game.PacmanGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {

    @Bean
    public GamingConsole game() {
        var game = new PacmanGame();
        return game;
    }

    @Bean
    public GameRunner gameRunner(GamingConsole game) {
        return new GameRunner(game);
    }

}
