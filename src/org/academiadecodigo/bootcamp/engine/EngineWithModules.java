package org.academiadecodigo.bootcamp.engine;

import org.academiadecodigo.bootcamp.engine.modules.Module;

import java.util.*;

public abstract class EngineWithModules extends Engine implements ModuleProcessor {

    private Map<Timing, List<Module>> modulesPerExecutingPhase;
    private List<Module> allModules;

    public EngineWithModules(int targetFrames) {
        super(targetFrames);
        this.allModules = new LinkedList<>();
        this.modulesPerExecutingPhase = new HashMap<>();
    }

    @Override
    public void addModule(Timing phase, Module module) {
        List<Module> modules = modulesPerExecutingPhase.get(phase);
        if (modules == null) {
            modules = new LinkedList<>();
        }

        modules.add(module);
        allModules.add(module);
        this.modulesPerExecutingPhase.put(phase, modules);
    }

    @Override
    public void remove(Module module) {
        Iterator<List<Module>> listIterator = modulesPerExecutingPhase.values().iterator();

        while (listIterator.hasNext()) {
            List<Module> list = listIterator.next();
            list.remove(module);
        }
    }

    @Override
    public boolean contains(Module module) {
        for (List<Module> value : modulesPerExecutingPhase.values()) {
            if (value.contains(module)) {
                return true;
            }
        }

    }

    @Override
    protected void loop() {
        while (running) {
            super.startLoop();
            for (Module module : modulesPerExecutingPhase) {
                module.tick();
            }
            super.loop();
        }
    }
}
