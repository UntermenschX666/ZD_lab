package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import start.Main;

import static start.Main.curUser;

public class UserWindowController {

    @FXML
    private Button btnEndSession;

    @FXML
    private Label lblUserName;

    @FXML
    private Label lblRestriction;

    @FXML
    void handleBtnEndSession(ActionEvent event) {

        Main.stgAuthorization.show();
        Main.stgUser.close();

    }

    @FXML
    private void initialize(){

        lblUserName.setText(curUser.getUserName());

        if(curUser.isRestriction())
            lblRestriction.setText("Yes");
        else
            lblRestriction.setText("No");

    }

}

