package org.academiadecodigo.bootcamp.engine.gfx;

import org.academiadecodigo.bootcamp.control.Input;
import org.academiadecodigo.bootcamp.control.InputType;
import org.academiadecodigo.bootcamp.control.SimpleGFXKey;
import org.academiadecodigo.bootcamp.engine.Engine;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.ConcurrentModificationException;
import java.util.LinkedHashMap;
import java.util.Map;

public class SimpleGraphicsEngine extends Engine implements KeyboardHandler {

    private Map<Integer, Input> inputs = new LinkedHashMap<>();

    public SimpleGraphicsEngine(int targetFrames) {
        super(targetFrames);
    }

    @Override
    public void init() {
        Keyboard keyboard = new Keyboard(this);

        for (SimpleGFXKey key : SimpleGFXKey.values()) {
            addEventListener(key.getKeyCode(), KeyboardEventType.KEY_PRESSED, keyboard);
            addEventListener(key.getKeyCode(), KeyboardEventType.KEY_RELEASED, keyboard);
        }
    }

    @Override
    protected void processAllInputs() {
        for (Input input : inputs.values()) {
            processInput(input);
        }
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        inputs.put(keyboardEvent.getKey(), new Input(SimpleGFXKey.getKeyFromKeyCode(keyboardEvent.getKey()), InputType.PRESSED));
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        inputs.remove(keyboardEvent.getKey());
        processInput(new Input(SimpleGFXKey.getKeyFromKeyCode(keyboardEvent.getKey()), InputType.RELEASED));
    }

    private void addEventListener(int keyCode, KeyboardEventType type, Keyboard keyboard) {
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(keyCode);
        event.setKeyboardEventType(type);
        keyboard.addEventListener(event);
    }


    @Override
    public void clearAllInputs() {
        inputs.clear();
    }

    @Override
    protected void loop() {
        while (isRunning()) {
            try {
                super.loop();
            } catch (ConcurrentModificationException ignored) {
                System.err.println("SimpleGraphicsEngine.loop()");
                // no handling required for exceptions from simpleGraphics
            }
        }
    }

}
