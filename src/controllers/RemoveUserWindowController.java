package controllers;

import interfaces.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.awt.*;

import static start.Main.arrayUsers;
import static start.Main.stgRemoveUser;

public class RemoveUserWindowController {

    private ObservableList<User> usersChoice;

    @FXML
    private Button btnClose;

    @FXML
    private Button btnRemove;

    @FXML
    private ChoiceBox<User> chcUserList;

    @FXML
    void handleBtnClose(ActionEvent event) {

        stgRemoveUser.close();

    }

    @FXML
    void handleBtnRemove(ActionEvent event) {


    }

    @FXML
    private void initialize(){

        usersChoice = FXCollections.observableArrayList(arrayUsers.getUsersForChoiceBox());

        chcUserList.setItems(usersChoice);

    }

}