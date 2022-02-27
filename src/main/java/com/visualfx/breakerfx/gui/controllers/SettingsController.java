package com.visualfx.breakerfx.gui.controllers;

import com.visualfx.breakerfx.App;
import com.visualfx.breakerfx.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void OnBack(ActionEvent event) {
        try {
            App.setRoot(String.valueOf(Utils.Scenes.MainMenu));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}