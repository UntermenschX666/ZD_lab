package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import objects.PasswordParser;

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

    private final String strWrongPassword = "Wrong old password";
    private final String strRestPassword = "Password does not comply with restriction";
    private final String strDuplicatePassword = "Password does not match";

    @FXML
    private void handleBtnChange(ActionEvent event) {

        String strOldPassword = tfOldPassword.getText();
        String strNewPassword = tfNewPassword.getText();
        String strConfirmPassword = tfConfirmPassword.getText();

        refreshFields();

        if(!strOldPassword.equals(curUser.getDecryptedPassword())){

            lblMessege.setText(strWrongPassword);

            return;
        }

        if(!strNewPassword.equals(strConfirmPassword)){

            lblMessege.setText(strDuplicatePassword);

            return;
        }

        if(curUser.isRestriction()){

            PasswordParser passwordParser = new PasswordParser(strNewPassword);
            if(!passwordParser.isCorrectPassword(curUser.getUserName())){

                lblMessege.setText(strRestPassword);

                return;

            }

        }

        curUser.setPassword(strNewPassword);
        arrayUsers.replaceUser(curUser);

        stgChangePassword.close();

    }

    @FXML
    private void handleBtnClose(ActionEvent event) {

        stgChangePassword.close();

    }

    private void refreshFields(){

        tfOldPassword.setText("");
        tfNewPassword.setText("");
        tfConfirmPassword.setText("");

    }

}
