package com.visualfx.breakerfx.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainMenuController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}