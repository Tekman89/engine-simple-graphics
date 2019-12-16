package org.academiadecodigo.bootcamp.example;

import org.academiadecodigo.bootcamp.control.SimpleGFXKey;
import org.academiadecodigo.bootcamp.engine.State;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

public class Main {


    private static final State MENU = new State() {
    };

    private static final State RUNNING = new State() {
    };


    public static void main(String[] args) {
        System.out.println(SimpleGFXKey.getKeyFromKeyCode(KeyboardEvent.KEY_RIGHT));
    }

}
