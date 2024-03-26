package com.typhoon0678.learnspringframework;

import com.typhoon0678.learnspringframework.game.GameRunner;
import com.typhoon0678.learnspringframework.game.GamingConsole;
import com.typhoon0678.learnspringframework.game.PacmanGame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03GamingSpringBeans {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(GamingConfiguration.class);

        context.getBean(GamingConsole.class).up();

        context.getBean(GameRunner.class).run();

    }

}
