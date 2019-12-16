package org.academiadecodigo.bootcamp.control;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

import java.util.HashMap;
import java.util.Map;

public enum SimpleGFXKey implements Keys {

    S(KeyboardEvent.KEY_S),
    D(KeyboardEvent.KEY_D),
    A(KeyboardEvent.KEY_A),
    W(KeyboardEvent.KEY_W),
    UP(KeyboardEvent.KEY_UP),
    DOWN(KeyboardEvent.KEY_DOWN),
    LEFT(KeyboardEvent.KEY_LEFT),
    RIGHT(KeyboardEvent.KEY_RIGHT),
    Q(KeyboardEvent.KEY_Q),
    SPACE(KeyboardEvent.KEY_SPACE);


    private final static Map<Integer, SimpleGFXKey> reverseEnum;

    /*
        Finally a static initializer block that actually makes sense to me xD
     */
    static {
        reverseEnum = new HashMap<>();
        for (SimpleGFXKey key : values()) {
            reverseEnum.put(key.keyCode, key);
        }
    }


    private final int keyCode;

    SimpleGFXKey(int keyCode) {
        this.keyCode = keyCode;
    }

    public static SimpleGFXKey getKeyFromKeyCode(int keyCode) {
        return reverseEnum.get(keyCode);
    }

    @Override
    public int getKeyCode() {
        return this.keyCode;
    }
}
