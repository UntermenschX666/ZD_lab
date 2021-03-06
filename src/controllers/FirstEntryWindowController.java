package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.WindowEvent;
import objects.PasswordParser;

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

    private final String strRestPassword = "Password does not comply with restriction";
    private final String strDuplicatePassword = "Password does not match";


    @FXML
    private void handleBtnNext(ActionEvent event) {


        String strNewPassword = tfNewPassword.getText();
        String strConfirmPassword = tfConfirmPassword.getText();

        refreshFields();

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


        curUser.setEncryptedPassword(strNewPassword);
        arrayUsers.replaceUser(curUser);

        stgFirstEntry.close();

    }

    private void refreshFields(){

       tfNewPassword.setText("");
       tfConfirmPassword.setText("");
       lblMessege.setText("");

    }


}
