package start;

import interfaces.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import controllers.AuthorizationWindowController;
import objects.ArrayUsers;

public class Main extends Application {

    public static Stage stgAuthorization;
    public static Stage stgUser;
    public static Stage stgAdmin;
    public static Stage stgAbout;
    public static Stage stgAddUser;
    public static Stage stgRemoveUser;
    public static Stage stgSaveChanges;
    public static Stage stgFirstEntry;
    public static Stage stgMessege;

    public static final String strPathFxmlAuthorizationWindow = "/gui/AuthorizationWindow.fxml";
    public static final String strPathFxmlUserWindow = "/gui/UserWindow.fxml" ;
    public static final String strPathFxmlAdminWindow = "/gui/AdminWindow.fxml";
    public static final String strPathFxmlAboutWindow = "/gui/AboutWindow.fxml";
    public static final String strPathFxmlAddUserWindow = "/gui/AddUserWindow.fxml";
    public static final String strPathFxmlRemoveUserWindow = "/gui/RemoveUserWindow.fxml";
    public static final String strPathFxmlSaveChangesWindow = "/gui/SaveChangesWindow.fxml";
    public static final String strPathFxmlFirstEntryWindow = "/gui/FirstEntryWindow.fxml";
    public static final String strPathFxmlMessegeWindow = "/gui/MessegeWindow.fxml";


    public static final String strNameAuthorizationWindow = "Authorization";
    public static final String strNameUserWindow = "User";
    public static final String strNameAdminWindow = "Admin";
    public static final String strNameAboutWindow = "About";
    public static final String strNameAddUserWindow = "Add new user";
    public static final String strNameRemoveUserWindow = "Remove user";
    public static final String strNameSaveChengesWindow = "Save Changes";
    public static final String strNameFirstEntryWindow = "First Entry";
    public static final String strNameMessegeWindow = "Messege";

    public static final String strPathIcon = "/images/icon/icnMainWindow.png";

    public static final String strAdminName = "admin";
    public static final String strStandartPassword = "";
    public static final String strStandartUserName = "Username";

    public static final String strStyleCheckBoxInTable = "/gui/CheckBox.css";


    public static ArrayUsers arrayUsers;
    public static User curUser;

    public static void CreateWindow(Stage stgWindow, final String strWindowName, Parent root ){

        stgWindow.setTitle(strWindowName);
        stgWindow.getIcons().add(new Image(strPathIcon));
        stgWindow.setScene(new Scene(root));
        stgWindow.setResizable(false);

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stgAuthorization) throws Exception{

        this.stgAuthorization = stgAuthorization;

        CreateWindow(stgAuthorization,strNameAuthorizationWindow,
                FXMLLoader.load(getClass().getResource(strPathFxmlAuthorizationWindow)));

        stgAuthorization.show();
    }

}
