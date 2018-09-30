package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
    void handleMiAbout(ActionEvent event) throws Exception {

        stgAbout = new Stage();

        CreateWindow(stgAbout, strNameAboutWindow,
                FXMLLoader.load(getClass().getResource(strPathFxmlAboutWindow)));


        stgAbout.show();

    }

    @FXML
    void handleBtnSignIn(ActionEvent event) throws Exception {

        curUser = arrayUsers.getUser(tfLogin.getText());
        String strUserName = tfLogin.getText();
        String strPassword = tfPassword.getText();


        if(curUser == null){
            lblMessege.setText("User with this name is not registered");
            return;
        }

        if (!curUser.getPassword().equals(strPassword)){
            lblMessege.setText("Wrong password");
            return;
        }

        if(curUser.getUserName().equals(strAdminName)){

            stgAdmin = new Stage();

            CreateWindow(stgAdmin, strNameAdminWindow,
                    FXMLLoader.load(getClass().getResource(Main.strPathFxmlAdminWindow)));

            stgAuthorization.hide();
            stgAdmin.show();

            return;

        }

        if(curUser.getUserName().equals(strUserName)) {

            stgUser = new Stage();

            CreateWindow(Main.stgUser,Main.strNameUserWindow,
                    FXMLLoader.load(getClass().getResource(Main.strPathFxmlUserWindow)));

            stgAuthorization.hide();
            stgUser.show();

            return;
        }


    }

    @FXML
    private void initialize(){

        File fUsersList = new File(".12oad032f78s");

        arrayUsers = new ArrayUsers();
        arrayUsers.test();

        if (!fUsersList.exists()){
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

        }


    }

}
