package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import start.Main;

import static start.Main.*;

public class UserWindowController {

    @FXML
    private Button btnEndSession;

    @FXML
    private Label lblUserName;

    @FXML
    private Label lblRestriction;

    @FXML
    private void handleMiAbout(ActionEvent event) throws Exception {

        stgAbout = new Stage();

        createWindow(stgAbout, strNameAboutWindow,
                FXMLLoader.load(getClass().getResource(strPathFxmlAboutWindow)));


        stgAbout.show();

    }

    @FXML
    private void handleMiChangePassword(ActionEvent event) throws Exception{

        stgChangePassword = new Stage();

        createWindow(stgChangePassword, strNameChangePassword,
                FXMLLoader.load(getClass().getResource(strPathFxmlChangePasswordWindow)));

        setModalWindow(stgChangePassword,stgUser);

        stgChangePassword.show();
    }

    @FXML
    private void handleBtnEndSession(ActionEvent event) {

        stgAuthorization.show();
        stgUser.close();

    }

    @FXML
    private void initialize() throws Exception{

        lblUserName.setText(curUser.getUserName());

        if(curUser.isRestriction())
            lblRestriction.setText("Yes");
        else
            lblRestriction.setText("No");


    }

}

