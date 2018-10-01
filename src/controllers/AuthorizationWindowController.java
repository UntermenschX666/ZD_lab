package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import objects.ArrayUsers;
import java.io.File;
import java.io.IOException;
import start.Main;

import static start.Main.*;


public class AuthorizationWindowController {

    @FXML
    private Label lblMessege;

    @FXML
    private TextField tfLogin;

    @FXML
    private PasswordField tfPassword;

    @FXML
    private Button btnSignIn;

    @FXML
    private void handleMiAbout(ActionEvent event) throws Exception {

        stgAbout = new Stage();

        createWindow(stgAbout, strNameAboutWindow,
                FXMLLoader.load(getClass().getResource(strPathFxmlAboutWindow)));


        stgAbout.show();

    }

    @FXML
    private void handleBtnSignIn(ActionEvent event) throws Exception {

        String strUserName = tfLogin.getText();
        String strPassword = tfPassword.getText();


        curUser = arrayUsers.getUser(strUserName);

        if(curUser == null){

            lblMessege.setText("User with this name is not registered");

            return;
        }

        if (!curUser.getPassword().equals(strPassword)){

            lblMessege.setText("Wrong password");

            return;
        }

        if(curUser.getUserName().equals(strAdminName)){

            stgAuthorization.hide();
            refreshAuthorizationWindow();

            if(curUser.getPassword().equals(strStandartPassword)){

                FirstEntry(stgAdmin);
                stgFirstEntry.showAndWait();

            }

            stgAdmin = new Stage();

            createWindow(stgAdmin, strNameAdminWindow,
                    FXMLLoader.load(getClass().getResource(strPathFxmlAdminWindow)));

            stgAdmin.show();

            return;

        }

        if(curUser.getUserName().equals(strUserName)) {

            stgAuthorization.hide();
            refreshAuthorizationWindow();

            if(curUser.getPassword().equals(strStandartPassword)){

                FirstEntry(stgAdmin);
                stgFirstEntry.showAndWait();

            }

            stgUser = new Stage();

            createWindow(Main.stgUser,Main.strNameUserWindow,
                    FXMLLoader.load(getClass().getResource(Main.strPathFxmlUserWindow)));

            stgUser.show();

            return;
        }


    }

    @FXML
    private void initialize(){


        //arrayUsers.test();
        /*
        if (fUsersList.exists()){
            try {

                if (!fUsersList.createNewFile()) {
                    //MassegeBox
                    stgAuthorization.close();
                }


            }
            catch (IOException ex){
                //MassegeBox
                stgAuthorization.close();
            }

        }*/


    }

    private void FirstEntry(Stage stgAdminOrUser) throws Exception{

        stgFirstEntry = new Stage();

        createWindow(stgFirstEntry,strNameFirstEntryWindow,
                FXMLLoader.load(getClass().getResource(strPathFxmlFirstEntryWindow)));

    }

    private void refreshAuthorizationWindow(){

        lblMessege.setText("");
        tfLogin.setText("");
        tfPassword.setText("");

    }

}
