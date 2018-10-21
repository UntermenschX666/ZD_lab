package controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.WindowEvent;
import objects.PasswordParser;

import static start.Main.*;

public class UserWindowController {

    @FXML
    private Button btnEndSession;

    @FXML
    private Label lblUserName;

    @FXML
    private Label lblRestriction;

    private String strBufferPassword;

    @FXML
    private void handleMiAbout(ActionEvent event) throws Exception {

        stgAbout.show();

    }

    @FXML
    private void handleMiChangePassword(ActionEvent event) throws Exception{

        strBufferPassword = curUser.getPassword();

        stgChangePassword.show();
    }

    @FXML
    private void handleBtnEndSession(ActionEvent event) throws Exception {

        //Костыль(Похорошему нужно создать окно для сохранения настроек пользователя, но мне похуй, это лаба в конце концов)
        if(!curUser.getPassword().equals(strBufferPassword)) {

            if (!arrayUsers.serializeUsers(fUsersFile)) {
                Platform.exit();
                System.exit(0);
            }

        }
        stgAuthorization.show();
        stgUser.close();

    }

    @FXML
    private void initialize() throws Exception{


        stgUser.addEventHandler(WindowEvent.WINDOW_SHOWING, new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                lblUserName.setText(curUser.getUserName());

                PasswordParser passwordParser =new PasswordParser(curUser.getPassword());

                if(curUser.isRestriction())
                    lblRestriction.setText("Yes");
                else
                    lblRestriction.setText("No");

                if(curUser.isRestriction() &&
                        !passwordParser.isCorrectPassword(curUser.getUserName())){

                    stgFirstEntry.showAndWait();
                }

            }
        });

        //костыль

    }

}

