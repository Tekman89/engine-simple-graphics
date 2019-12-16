package org.academiadecodigo.bootcamp.engine.modules;

public interface Module extends Comparable<Module> {

    boolean equals(Module module);

    int hashCode();

    void tick();
}
