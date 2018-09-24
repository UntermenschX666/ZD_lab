package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import objects.User;
import objects.UserList;

public class AdminWindowController {

    private Stage stgAdmin;

    @FXML
    private TableView tbvUserList;


    @FXML
    private TableColumn<User, String> tbcUsername;

    @FXML
    private TableColumn<User, String> tbcPassword;

    @FXML
    private TableColumn<User, Boolean> tbcBlocked;

    @FXML
    private TableColumn<User, Boolean> tbcRestrictions;

    @FXML
    private Button btnAddUser;

    @FXML
    private Button btnRemoveUser;

    @FXML
    private Button btnEditUser;

    @FXML
    private Button btnEditPass;

    @FXML
    private Button btnSaveChanges;

    @FXML
    private Button btnEndSession;

    @FXML
    private void initialize(){
        //test data
        tbcUsername.setCellValueFactory(new PropertyValueFactory<User,String>("sstrpUserName"));
        tbcPassword.setCellValueFactory(new PropertyValueFactory<User,String>("sstrpPassword"));
        tbcBlocked.setCellValueFactory(new PropertyValueFactory<User,Boolean>("sbpBlock"));
        tbcRestrictions.setCellValueFactory(new PropertyValueFactory<User,Boolean>("sbpRestriction"));
        tbvUserList.setItems(AuthorizationWindowController.userList.getUsers());

    }


}
