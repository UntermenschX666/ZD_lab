package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import objects.User;

public class AdminWindowController {

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
    private MenuBar mbMenu;

    @FXML
    private MenuItem miAdd;

    @FXML
    private MenuItem miRemove;


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

        tbvUserList.setEditable(true);
    }


}
