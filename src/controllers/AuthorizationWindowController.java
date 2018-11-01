package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import objects.TryCounter;
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
    private Button btnExit;

    private TryCounter tryCounter;

    private final String strNotRegistered = "User with this name is not registered";
    private final String strUserIsBlock = "You are blocked";
    private final String strWrongPassword = "Wrong password";

    @FXML
    private void handleMiAbout(ActionEvent event) throws Exception {

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

        curUser = arrayUsers.getUser(strUserName);

        if(curUser == null){

            lblMessege.setText(strNotRegistered);

            return;
        }

        if(curUser.isBlocked()){

            lblMessege.setText(strUserIsBlock);

            return;
        }

        if(!curUser.getPassword().equals(strPassword)){

            lblMessege.setText(strWrongPassword);
            tryCounter.addTryCountByUsername(curUser.getUserName());

            if(tryCounter.isTryCountEnd(curUser.getUserName()))
                curUser.setBlock(true);

            return;
        }

        if(curUser.getUserName().equals(strAdminName)){

            refreshAuthorizationWindow();

            if(curUser.getPassword().equals(strStandartPassword)){

                stgFirstEntry.showAndWait();

            }


            stgAdmin.show();
            stgAuthorization.close();

            return;

        }

        if(curUser.getUserName().equals(strUserName)) {


            refreshAuthorizationWindow();

            if(curUser.getPassword().equals(strStandartPassword)){

                stgFirstEntry.showAndWait();

            }


            stgUser.show();
            stgAuthorization.close();

            return;
        }


    }

    @FXML
    private void initialize() throws Exception{

        stgAdmin = new Stage();
        stgUser = new Stage();
        stgFirstEntry = new Stage();
        stgAbout = new Stage();
        stgChangePassword = new Stage();

        createWindow(stgAdmin, strNameAdminWindow,
                FXMLLoader.load(getClass().getResource(strPathFxmlAdminWindow)));


        createWindow(stgUser,strNameUserWindow,
                FXMLLoader.load(getClass().getResource(Main.strPathFxmlUserWindow)));


        createWindow(stgFirstEntry,strNameFirstEntryWindow,
                FXMLLoader.load(getClass().getResource(strPathFxmlFirstEntryWindow)));

        addCloseHandler(stgFirstEntry);

        setModalWindow(stgFirstEntry);

        createWindow(stgAbout, strNameAboutWindow,
                FXMLLoader.load(getClass().getResource(strPathFxmlAboutWindow)));

        setModalWindow(stgAbout);

        createWindow(stgChangePassword, strNameChangePassword,
                FXMLLoader.load(getClass().getResource(strPathFxmlChangePasswordWindow)));

        setModalWindow(stgChangePassword);

        stgAuthorization.addEventHandler(WindowEvent.WINDOW_SHOWING, new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                tryCounter = new TryCounter(arrayUsers.getUsers());
            }
        });

    }

    private void refreshAuthorizationWindow(){

        lblMessege.setText("");
        tfLogin.setText("");
        tfPassword.setText("");

    }

}


