package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import static start.Main.stgAbout;
import static start.Main.stgAuthorization;

public class AboutWindowController {

    @FXML
    private Button btnClose;

    @FXML
    void handleBtnClose(ActionEvent event) {

        stgAuthorization.show();
        stgAbout.close();

    }

}
