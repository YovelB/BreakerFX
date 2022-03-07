package com.visualfx.breakerfx.timers;

import javafx.animation.AnimationTimer;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class PausableAnimationTimer extends AnimationTimer {
    DoubleProperty animationDuration = new SimpleDoubleProperty(0L);

    private long animationStart, pauseStart;
    private boolean restartScheduled, playScheduled, pausedScheduled;
    private boolean isPaused, isActive;

    @Override
    public void start() {
        super.start();
        isActive = true;
        restartScheduled = true;
    }

    @Override
    public void stop() {
        super.stop();
        pauseStart = 0;
        isPaused = false;
        isActive = false;
        pausedScheduled = false;
        playScheduled = false;
        animationDuration.set(0L);
    }

    public void play() {
        if (isPaused) {
            playScheduled = true;
        }
    }

    public void pause() {
        if (!isPaused) {
            pausedScheduled = true;
        }
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean isPaused() {
        return isPaused;
    }

    private void updatePlayingStates(long now) {
        if (pausedScheduled) {
            pauseStart = now;
            isPaused = true;
            pausedScheduled = false;
        }

        if (playScheduled) {
            animationStart += (now - pauseStart);
            isPaused = false;
            playScheduled = false;
        }

        if (restartScheduled) {
            animationStart = now;
            isPaused = false;
            restartScheduled = false;
        }
    }

    // fields and a private method to calculate AnimationTimer frameRate
    IntegerProperty frameRateProperty = new SimpleIntegerProperty(0);

    public IntegerProperty getFrameRateProperty() {
        return frameRateProperty;
    }

    private long lastFrameTime = -1L;

    private void updateFrameRate(long currentTimeNano) {
        long deltaTimeNano = currentTimeNano - lastFrameTime;
        lastFrameTime = currentTimeNano;

        double frameRate = (1d / deltaTimeNano) * 1e9;
        frameRateProperty.set((int) Math.round(frameRate));
    }

    @Override
    public void handle(long now) {
        updateFrameRate(now);
        updatePlayingStates(now);

        if (!isPaused) {
            long animDuration = now - animationStart;
            animationDuration.set(animDuration / 1e9);
            handleGame(animDuration);
        }
    }

    public abstract void handleGame(long relativeNow);
}