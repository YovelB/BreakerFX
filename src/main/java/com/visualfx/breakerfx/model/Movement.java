package com.visualfx.breakerfx.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;

class Movement {
    private static final BooleanProperty isRightMovement, isLeftMovement;

    static {
        isRightMovement = new SimpleBooleanProperty(false);
        isLeftMovement = new SimpleBooleanProperty(false);
    }

    public static void addMovementListeners(Canvas canvas) {
        EventHandler<KeyEvent> keyPressedEvent = keyEvent -> {
            switch (keyEvent.getCode()) {
                case RIGHT, A -> isRightMovement.set(true);
                case LEFT, D -> isLeftMovement.set(true);
                default -> throw new IllegalArgumentException("Unexpected value: " + keyEvent.getCode());
            }
        };
        EventHandler<KeyEvent> keyReleaseEvent = keyEvent -> {
            switch (keyEvent.getCode()) {
                case RIGHT, A -> isRightMovement.set(false);
                case LEFT, D -> isLeftMovement.set(false);
                default -> throw new IllegalArgumentException("Unexpected value: " + keyEvent.getCode());
            }
        };
        canvas.setOnKeyPressed(keyPressedEvent);
        canvas.setOnKeyReleased(keyReleaseEvent);
    }

    public static BooleanProperty isRightMovementProperty() {
        return isRightMovement;
    }

    public static BooleanProperty isLeftMovementProperty() {
        return isLeftMovement;
    }
}