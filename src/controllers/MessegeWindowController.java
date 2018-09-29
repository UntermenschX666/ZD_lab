package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import static start.Main.stgMessege;


public class MessegeWindowController {

    @FXML
    private Button btnOk;

    @FXML
    void handleBtnOk(ActionEvent event) {

        stgMessege.close();

    }

}

