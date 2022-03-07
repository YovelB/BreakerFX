package com.visualfx.breakerfx.gui.controllers;

import com.visualfx.breakerfx.timers.PausableAnimationTimer;
import com.visualfx.breakerfx.model.Player;
import com.visualfx.breakerfx.systems.KeyPolling;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
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
    private Player player;

    private PausableAnimationTimer timer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        canvas = new Canvas();
        canvas.widthProperty().bind(anchorPane.widthProperty());
        canvas.heightProperty().bind(anchorPane.heightProperty());
        player = new Player(canvas, "Yovel");

        GraphicsContext gc = canvas.getGraphicsContext2D();

        timer = new PausableAnimationTimer() {
            @Override
            public void handleGame(long relativeNow) {
                gameLoop(relativeNow);
            }
        };
        FPSLabel.textProperty().bindBidirectional(timer.getFrameRateProperty(), new NumberStringConverter("FPS: "));

    }

    private void gameLoop(long relativeNow) {
        pollUserInput();
        updatePlayerPosition();
        updateCanvas();
    }

    private void updateCanvas() {
    }

    private void updatePlayerPosition() {
    }

    private void pollUserInput() {
    }
}