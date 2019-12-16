package org.academiadecodigo.bootcamp.screen;

import org.academiadecodigo.bootcamp.control.Input;
import org.academiadecodigo.bootcamp.control.InputTypes;
import org.academiadecodigo.bootcamp.control.Keys;
import org.academiadecodigo.bootcamp.engine.Engine;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractScreen implements Screen {


    protected Set<Input> handledInputs;
    protected Engine engine;
    protected Background background;

    public AbstractScreen(Background background) {
        handledInputs = new HashSet<>();
        this.background = background;
    }

    @Override
    public void hide() {
        background.delete();
    }

    @Override
    public void update() {
        background.draw();
    }

    @Override
    public void init(Engine engine) {
        this.engine = engine;
    }

    @Override
    public boolean handles(Input input) {
        return handledInputs.contains(input);
    }

    protected void addInput(Keys key, InputTypes type) {
        this.handledInputs.add(new Input(key, type));
    }
}
