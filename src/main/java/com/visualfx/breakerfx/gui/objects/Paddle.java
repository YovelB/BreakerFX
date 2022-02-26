package com.visualfx.breakerfx.gui.objects;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import static com.visualfx.breakerfx.Utils.SCENE_HEIGHT;
import static com.visualfx.breakerfx.Utils.SCENE_WIDTH;

public class Paddle extends StackPane {
    //should this be in the paddle UI or in the Player
    private static final int WIDTH = 100, HEIGHT = 20;
    private static final int startX = SCENE_WIDTH / 2 - (WIDTH / 2), startY = SCENE_HEIGHT - HEIGHT - 20;
    private static final Paint paint = Color.WHITE;

    public Paddle() {
        Rectangle body = new Rectangle(startX, startY, WIDTH, HEIGHT);
        body.setStroke(paint);
        getChildren().add(body);
    }

}