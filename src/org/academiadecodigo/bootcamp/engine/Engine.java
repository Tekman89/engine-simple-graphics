package org.academiadecodigo.bootcamp.engine;

import org.academiadecodigo.bootcamp.control.Input;
import org.academiadecodigo.bootcamp.screen.Screen;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class Engine {

    private Map<State, Screen> screenMap;
    private Screen activeScreen;
    protected boolean running = true;
    private int currentFrames;
    protected State initialState;
    private long milliSecondsPerFrame;
    private long lastSecond;
    private long startTime;
    private int howManyLoopsPerSecond;

    public Engine(int targetFrames) {
        int oneSecond = 1;
        milliSecondsPerFrame = TimeUnit.SECONDS.toMillis(oneSecond) / targetFrames;
        this.screenMap = new HashMap<>();
    }

    public abstract void init();

    public void start() {
        lastSecond = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        startLoop();
        loop();
    }

    protected void startLoop() {
        this.startTime = System.currentTimeMillis();
    }

    protected void loop() {

        processAllInputs();

        howManyLoopsPerSecond++;

        if (TimeUnit.MILLISECONDS.toSeconds(startTime) != lastSecond) {
            lastSecond = TimeUnit.MILLISECONDS.toSeconds(startTime);
            currentFrames = howManyLoopsPerSecond;
            howManyLoopsPerSecond = 0;
        }

        activeScreen.update();

        long waitingValue = milliSecondsPerFrame - (System.currentTimeMillis() - startTime);

        sleep(waitingValue);
    }

    private void sleep(long waitingValue) {
        if (waitingValue <= 0) {
            return;
        }

        try {
            Thread.sleep(waitingValue);
        } catch (InterruptedException ignored) { // exceptions should not be silenced unless explicitly so.
            System.err.println(ignored.getMessage());
            // Thread woke up early
        }
    }

    public void setScreen(State state) {
        if (activeScreen != null) {
            this.activeScreen.hide();
        }

        this.activeScreen = screenMap.get(state);
    }

    public void addScreen(State state, Screen screen) {
        screenMap.put(state, screen);
        screen.init(this);
    }

    public void stop() {
        running = false;
        System.exit(0);
    }

    protected void processInput(Input input) {
        if (activeScreen.handles(input)) {
            activeScreen.processInput(input);
        }
    }

    public void reset() {
        setScreen(initialState);
    }

    public int getCurrentFrames() {
        return currentFrames;
    }

    protected boolean isRunning() {
        return running;
    }

    protected abstract void processAllInputs();

    public abstract void clearAllInputs();
}
