package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

import static start.Main.arrayUsers;
import static start.Main.curUser;
import static start.Main.stgChangePassword;

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
    private void handleBtnChange(ActionEvent event) {

        String strOldPassword = tfOldPassword.getText();
        String strNewPassword = tfNewPassword.getText();
        String strConfirmPassword = tfConfirmPassword.getText();

        if(!strOldPassword.equals(curUser.getPassword())){

            lblMessege.setText("Wrong old password");

            return;
        }

        if(!strNewPassword.equals(strConfirmPassword)){

            lblMessege.setText("Passwords do not match");

            return;
        }

        curUser.setPassword(strNewPassword);
        arrayUsers.replaceUser(curUser);

        stgChangePassword.close();

    }

    @FXML
    private void handleBtnClose(ActionEvent event) {

        stgChangePassword.close();

    }

}
