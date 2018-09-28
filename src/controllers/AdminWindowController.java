package controllers;

import interfaces.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import objects.UserForTable;
public class AdminWindowController {

    private ObservableList<User> usersTable;

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
    void handleBtnEndSession(ActionEvent event) {
        AuthorizationWindowController.stgAuthorization.show();
        AuthorizationWindowController.stgAdmin.close();
    }

    @FXML
    void handleBtnSaveChanges(ActionEvent event) {

    }

    @FXML
    private void initialize(){

        OutToTableView();

    }

    private void OutToTableView(){

        usersTable = FXCollections.observableArrayList(AuthorizationWindowController.arrayUsers.getUsersForTable());

        tbcUsername.setCellValueFactory(
                new PropertyValueFactory<User,String>("sspUserName")
        );

        tbcPassword.setCellValueFactory(
                new PropertyValueFactory<User,String>("sspPassword")
        );

        tbcBlocked.setCellValueFactory(
                new PropertyValueFactory<User,Boolean>("sbpBlock")
        );

        tbcRestrictions.setCellValueFactory(
                new PropertyValueFactory<User,Boolean>("sbpRestriction")
        );

        tbvUserList.setItems(usersTable);

    }

}
