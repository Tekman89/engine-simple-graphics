package org.academiadecodigo.bootcamp.control;

public enum InputType implements InputTypes {

    PRESSED,
    RELEASED;

    @Override
    public String getName() {
        return this.toString();
    }
}
