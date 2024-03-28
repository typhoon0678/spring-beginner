package com.typhoon0678.learnspringframework.game;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component //Spring Configuration 이 감지할 수 있도록 함
public class PacmanGame implements GamingConsole {

    public void up() {
        System.out.println("up");
    }

    public void down() {
        System.out.println("down");
    }

    public void left() {
        System.out.println("left");
    }

    public void right() {
        System.out.println("right");
    }
}
