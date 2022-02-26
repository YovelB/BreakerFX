package com.visualfx.breakerfx.gui.controllers;

import com.visualfx.breakerfx.App;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnQuit;

    @FXML
    private Button btnSettings;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void onPlay(ActionEvent event) {
        try {
            App.setRoot("Game");
        } catch (IOException e) {
            //todo print error
            e.printStackTrace();
        }
    }

    @FXML
    void onSettings(ActionEvent event) {
        try {
            App.setRoot("Settings");
        } catch (IOException e) {
            //todo print error
            e.printStackTrace();
        }
    }

    @FXML
    void onQuit(ActionEvent event) {
        Platform.exit();
    }
}