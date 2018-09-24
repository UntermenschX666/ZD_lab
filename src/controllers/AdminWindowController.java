package controllers;

import javafx.collections.FXCollections;
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
    private UserList userList;

    @FXML
    private TableView<User> tbvUserList;


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
        userList = new UserList();
        userList.test();
        tbcUsername.setCellValueFactory(new PropertyValueFactory<User,String>("sstrpUserName"));
        tbcPassword.setCellValueFactory(new PropertyValueFactory<User,String>("sstrpPassword"));
        tbcBlocked.setCellValueFactory(new PropertyValueFactory<User,Boolean>("spbBlock"));
        tbcRestrictions.setCellValueFactory(new PropertyValueFactory<User,Boolean>("sbpRestriction"));
        tbvUserList.setItems(userList.getUsers());

    }

    public void setStage(Stage stage){
        stgAdmin = stage;
    }

    public void setUserList(UserList userList){
        this.userList = userList;
    }
}
