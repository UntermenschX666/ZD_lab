package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import objects.User;
import objects.UserList;
import java.io.File;
import java.io.IOException;

public class AuthorizationWindowController {

    public static UserList userList;
    public static Stage stgAdmin;
    public static Stage stgUser;
    public static Stage stgAuthorization;

    @FXML
    private TextField tfLogin;

    @FXML
    private PasswordField tfPassword;

    @FXML
    private Button btnSignIn;

    @FXML
    void handleBtnSignIn(ActionEvent event) throws Exception {
        if (tfLogin.getText().equals("admin")) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/gui/AdminWindow.fxml"));
            Parent root =  (Parent) fxmlLoader.load();
            AdminWindowController controller = fxmlLoader.getController();
            stgAdmin = new Stage();
            stgAdmin.setTitle("Admin");
            stgAdmin.getIcons().add(new Image("/images/icon/icnMainWindow.png"));
            stgAdmin.setScene(new Scene(root));
            stgAuthorization.hide();
            stgAdmin.show();
        }

        if(tfLogin.getText().equals("user")) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/gui/UserWindow.fxml"));
            Parent root =  (Parent) fxmlLoader.load();
            UserWindowController controller = fxmlLoader.getController();
            stgUser = new Stage();
            stgUser.setTitle("objects.User");
            stgUser.getIcons().add(new Image("/images/icon/icnMainWindow.png"));
            stgUser.setScene(new Scene(root));
            controller.setStage(stgUser);
            stgAuthorization.hide();
            stgUser.show();
        }

    }

    @FXML
    private void initialize(){

        File fUsersList = new File(".12oad032f78s");

        userList = new UserList();
        userList.test();

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

    public void setStage(Stage stage){
        stgAuthorization = stage;
    }


}
