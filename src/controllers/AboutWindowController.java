package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import static start.Main.stgAbout;

public class AboutWindowController {

    @FXML
    private Button btnClose;

    @FXML
    void handleBtnClose(ActionEvent event) {

        stgAbout.close();

    }

}
