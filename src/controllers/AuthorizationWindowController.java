package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
    private void handleBtnExit(ActionEvent event) {

        stgAuthorization.close();

    }

    @FXML
    private void handleBtnSignIn(ActionEvent event) throws Exception {

        String strUserName = tfLogin.getText();
        String strPassword = tfPassword.getText();
        //Когда нет времени придумывать пора вставлять уродские костыли
        curUser = arrayUsers.getUser(strUserName);


        if(curUser == null){

            lblMessege.setText("User with this name is not registered");

            return;
        }

        if(curUser.isBlocked()){

            lblMessege.setText("You are blocked");

            return;
        }

        if(!curUser.getPassword().equals(strPassword)){

            lblMessege.setText("Wrong password");
            curUser.addTryCount();

            if(curUser.getTryCount() == 3)
                curUser.setBlock(true);

            return;
        }

        if(curUser.getUserName().equals(strAdminName)){

            curUser.setTryCount(0);

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

            curUser.setTryCount(0);

            stgAuthorization.hide();
            refreshAuthorizationWindow();

            if(curUser.getPassword().equals(strStandartPassword)){

                FirstEntry(stgAdmin);
                addCloseHandler(stgFirstEntry);
                stgFirstEntry.showAndWait();

            }

            stgUser = new Stage();

            createWindow(stgUser,strNameUserWindow,
                    FXMLLoader.load(getClass().getResource(Main.strPathFxmlUserWindow)));

            stgUser.show();

            return;
        }


    }

    @FXML
    private void initialize(){

        if(!arrayUsers.deserializeUsers(fUsersFile)) {
            //System.out.println("Error deserial");
            //messegebox
        }
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


