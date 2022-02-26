package com.visualfx.breakerfx.model;

import com.visualfx.breakerfx.gui.objects.Paddle;
import javafx.scene.canvas.Canvas;

public class Player {
    private final String name;

    public Player(Canvas canvas, String name) {
        this.name = name;
        Paddle paddle = new Paddle();
        Movement.addMovementListeners(canvas);
    }

    public String getName() {
        return name;
    }
}