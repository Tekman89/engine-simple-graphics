package org.academiadecodigo.bootcamp.engine;

import org.academiadecodigo.bootcamp.engine.modules.Module;

public interface ModuleProcessor {

    void addModule(Timing phase, Module module);

    void remove(Module module);

    boolean contains(Module module);
}
