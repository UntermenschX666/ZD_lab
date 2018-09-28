package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import objects.ArrayUsers;
import java.io.File;
import java.io.IOException;
import interfaces.User;
public class AuthorizationWindowController {

    public static ArrayUsers arrayUsers;
    public static Stage stgAdmin;
    public static Stage stgUser;
    public static Stage stgAuthorization;

    @FXML
    private Label lblMassege;

    @FXML
    private TextField tfLogin;

    @FXML
    private PasswordField tfPassword;

    @FXML
    private Button btnSignIn;

    @FXML
    void handleBtnSignIn(ActionEvent event) throws Exception {

        User user = arrayUsers.getUser(tfLogin.getText());
        String strUserName = tfLogin.getText();
        String strPassword = tfPassword.getText();
        String strAdminName = "admin";


        if(user == null){
            lblMassege.setText("UserForSerialize with this name is not registered");
            return;
        }

        if (!user.getPassword().equals(strPassword)){
            lblMassege.setText("Wrong password");
            return;
        }

        if(user.getUserName().equals(strAdminName)){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/gui/AdminWindow.fxml"));
            Parent root =  (Parent) fxmlLoader.load();
            stgAdmin = new Stage();
            stgAdmin.setTitle("Admin");
            stgAdmin.getIcons().add(new Image("/images/icon/icnMainWindow.png"));
            stgAdmin.setScene(new Scene(root));
            stgAuthorization.hide();
            stgAdmin.show();
            return;
        }

        if(user.getUserName().equals(strUserName)) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/gui/UserWindow.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            UserWindowController controller = fxmlLoader.getController();
            stgUser = new Stage();
            stgUser.setTitle("User");
            stgUser.getIcons().add(new Image("/images/icon/icnMainWindow.png"));
            stgUser.setScene(new Scene(root));
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
