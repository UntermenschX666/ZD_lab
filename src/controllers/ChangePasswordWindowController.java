package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class ChangePasswordWindowController {

    @FXML
    private PasswordField tfConfirmPassword;

    @FXML
    private Button btnChange;

    @FXML
    private Label lblMessege;

    @FXML
    private PasswordField tfNewPassword;

    @FXML
    private PasswordField tfOldPassword;

    @FXML
    private Button btnClose;

    @FXML
    void handleBtnChange(ActionEvent event) {

    }

    @FXML
    void handleBtnClose(ActionEvent event) {

    }

}
