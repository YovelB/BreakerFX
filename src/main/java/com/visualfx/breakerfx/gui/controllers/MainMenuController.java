package com.visualfx.breakerfx.gui.controllers;

import com.visualfx.breakerfx.App;
import com.visualfx.breakerfx.Utils;
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
        //TODO apply better visual to the buttons or delete them.
    }

    @FXML
    void onPlay(ActionEvent event) {
        try {
            App.setRoot(String.valueOf(Utils.Scenes.Game));
        } catch (IOException e) {
            //todo print error
            e.printStackTrace();
        }
    }

    @FXML
    void onSettings(ActionEvent event) {
        try {
            App.setRoot(String.valueOf(Utils.Scenes.Settings));
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