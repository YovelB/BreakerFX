package com.visualfx.breakerfx.gui.controllers;

import com.visualfx.breakerfx.gui.entities.Entity;
import com.visualfx.breakerfx.systems.Renderer;
import com.visualfx.breakerfx.timers.PausableAnimationTimer;
import com.visualfx.breakerfx.model.Player;
import com.visualfx.breakerfx.systems.KeyPolling;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.util.converter.NumberStringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Label FPSLabel;

    private Canvas canvas;

    private final KeyPolling keyPolling = KeyPolling.getInstance();

    private Entity player;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        canvas = new Canvas();
        initializeCanvas();

        player = new Entity(new Image(String.valueOf(getClass().getResource("/images/paddle.png"))));
        player.setPosition(350, 200);
        player.setScale(0.5f);

        Renderer renderer = new Renderer(this.canvas);
        renderer.setBackground(new Image(String.valueOf(getClass().getResource("/images/background.png"))));
        renderer.addEntity(player);


        PausableAnimationTimer timer = new PausableAnimationTimer() {
            @Override
            public void handleGame(long relativeNow) {
                renderer.prepare();
                updatePlayerMovement(relativeNow);
                renderer.render();
            }
        };
        timer.start();

        FPSLabel.textProperty().bindBidirectional(timer.getFrameRateProperty(), new NumberStringConverter("FPS: "));
    }

    private void initializeCanvas() {
        canvas.widthProperty().bind(anchorPane.widthProperty());
        canvas.heightProperty().bind(anchorPane.heightProperty());
    }

    private void updatePlayerMovement(float frameDuration) {
        if (keyPolling.isDown(KeyCode.UP)) {
            player.addThrustForce(20 * frameDuration);
        } else if (keyPolling.isDown(KeyCode.DOWN)) {
            player.addThrustForce(-20 * frameDuration);
        }

        if (keyPolling.isDown(KeyCode.RIGHT)) {
            player.addTorque(120f * frameDuration);
        } else if (keyPolling.isDown(KeyCode.LEFT)) {
            player.addTorque(-120f * frameDuration);
        }
        player.update();
    }
}