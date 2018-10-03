package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import static start.Main.stgSaveChanges;

public class SaveChangesWindowController {

    @FXML
    private Button btnYes;

    @FXML
    private Button btnNo;

    @FXML
    void handleBtnNo(ActionEvent event) {

        stgSaveChanges.close();

    }

    @FXML
    void handleBtnYes(ActionEvent event) {

    }

}

