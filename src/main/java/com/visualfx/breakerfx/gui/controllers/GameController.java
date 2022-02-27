package com.visualfx.breakerfx.gui.controllers;

import com.visualfx.breakerfx.model.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    @FXML
    private Canvas canvas;
    private Player player;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        player = new Player(canvas, "Yovel");
        GraphicsContext gc = canvas.getGraphicsContext2D();
    }
}