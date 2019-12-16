package org.academiadecodigo.bootcamp.screen;

import org.academiadecodigo.bootcamp.control.Input;
import org.academiadecodigo.bootcamp.engine.Engine;

public interface Screen {

    /**
     * Clear all active rendered objects
     */
    void hide();

    /**
     * Method to make logic updates to the entities and render
     */
    void update();

    /**
     * Initialize all screen components, should not call renders in this method,
     *
     * @param engine the game engine used to control state
     */
    void init(Engine engine);

    /**
     * Each screen takes a input and processes it differently
     *
     * @param input the SimpleGFXKey being pressed
     */
    void processInput(Input input);

    /**
     * A method to find if the screen wants to handle this key pressed
     *
     * @param input the key being pressed
     * @return true if the key is handled by this screen
     */
    boolean handles(Input input);
}
