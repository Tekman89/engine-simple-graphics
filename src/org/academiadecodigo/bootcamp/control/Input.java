package org.academiadecodigo.bootcamp.control;

import java.util.Objects;

public class Input {

    private final Keys key;
    private final InputTypes type;

    public Input(Keys key, InputTypes type) {
        this.key = key;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Input input = (Input) o;
        return Objects.equals(key, input.key) &&
                Objects.equals(type, input.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, type);
    }

    public Keys getKey() {
        return key;
    }

    public InputTypes getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Input{" +
                "key=" + key +
                ", type=" + type +
                '}';
    }
}
