package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

import static start.Main.arrayUsers;
import static start.Main.curUser;
import static start.Main.stgFirstEntry;

public class FirstEntryWindowController {

    @FXML
    private PasswordField tfConfirmPassword;

    @FXML
    private Label lblMessege;

    @FXML
    private PasswordField tfNewPassword;

    @FXML
    private Button btnNext;

    @FXML
    private void handleBtnNext(ActionEvent event) {

        String strNewPassword = tfNewPassword.getText();
        String strConfirmPassword = tfConfirmPassword.getText();

        if(!strNewPassword.equals(strConfirmPassword)){

            lblMessege.setText("Passwords do not match");

            return;
        }

        curUser.setPassword(strNewPassword);
        arrayUsers.replaceUser(curUser);

        stgFirstEntry.close();

    }

}
