package start;

import interfaces.User;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import objects.ArrayUsers;
import objects.UserForSerialize;
import objects.UserForVisual;

import java.io.File;
import java.util.ArrayList;

public class Main extends Application {

    public static Stage stgAuthorization;
    public static Stage stgUser;
    public static Stage stgAdmin;
    public static Stage stgAbout;
    public static Stage stgAddUser;
    public static Stage stgSaveChanges;
    public static Stage stgFirstEntry;
    public static Stage stgChangePassword;

    public static File fUsersFile;

    public static final String strPathFxmlAuthorizationWindow = "/gui/AuthorizationWindow.fxml";
    public static final String strPathFxmlUserWindow = "/gui/UserWindow.fxml" ;
    public static final String strPathFxmlAdminWindow = "/gui/AdminWindow.fxml";
    public static final String strPathFxmlAboutWindow = "/gui/AboutWindow.fxml";
    public static final String strPathFxmlAddUserWindow = "/gui/AddUserWindow.fxml";
    public static final String strPathFxmlSaveChangesWindow = "/gui/SaveChangesWindow.fxml";
    public static final String strPathFxmlFirstEntryWindow = "/gui/FirstEntryWindow.fxml";
    public static final String strPathFxmlChangePasswordWindow = "/gui/ChangePasswordWindow.fxml";


    public static final String strNameAuthorizationWindow = "Authorization";
    public static final String strNameUserWindow = "User";
    public static final String strNameAdminWindow = "Admin";
    public static final String strNameAboutWindow = "About";
    public static final String strNameAddUserWindow = "Add new user";
    public static final String strNameSaveChengesWindow = "Save Changes";
    public static final String strNameFirstEntryWindow = "First Entry";
    public static final String strNameChangePassword = "Change Password";

    public static final String strPathIcon = "/images/icon/icnMainWindow.png";

    public static final String strFileName = ".users";

    public static final String strAdminName = "admin";
    public static final String strStandartPassword = "";

    public static final String strStyleCheckBoxInTable = "/gui/CheckBox.css";

    public static ArrayUsers arrayUsers;
    public static ArrayList<User> arrBufferUsers;
    public static User curUser;

    public static void createWindow(Stage stgWindow, final String strWindowName, Parent root ){

        stgWindow.setTitle(strWindowName);
        stgWindow.getIcons().add(new Image(strPathIcon));
        stgWindow.setScene(new Scene(root));
        stgWindow.setResizable(false);

    }

    public static void addCloseHandler(Stage stgWindow){

        stgWindow.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {

                Platform.exit();
                System.exit(0);

            }

        });

    }

    public static void setModalWindow(Stage stgModalWindow, Stage stgOwner){

        stgModalWindow.initModality(Modality.WINDOW_MODAL);
        stgModalWindow.initOwner(stgOwner);

    }



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stgAuthorization) throws Exception{

        fUsersFile = new File(strFileName);
        arrayUsers = new ArrayUsers();

        if (fUsersFile.length() == 0 ) {

            User adminUser = new UserForVisual(strAdminName, strStandartPassword,
                    false, true);

            arrayUsers.add(adminUser);

            //if (!arrayUsers.serializeUsers(fUsersFile)) {
            //    System.out.println("Error serial"); //MessegeBox
            //    return;
            //}

        }
        else{

            if(!arrayUsers.deserializeUsers(fUsersFile)) {
                System.out.println("Errr");
            }

        }

        this.stgAuthorization = stgAuthorization;

        createWindow(stgAuthorization,strNameAuthorizationWindow,
                FXMLLoader.load(getClass().getResource(strPathFxmlAuthorizationWindow)));

        stgAuthorization.show();

    }

}
