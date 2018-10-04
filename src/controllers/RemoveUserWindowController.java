package controllers;

import interfaces.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import static start.Main.arrayUsers;
import static start.Main.stgRemoveUser;

public class RemoveUserWindowController {

    @FXML
    private Button btnClose;

    @FXML
    private Button btnRemove;

    @FXML
    private ChoiceBox<User> chcUserList;

    @FXML
    private void handleBtnClose(ActionEvent event) {

        stgRemoveUser.close();

    }

    @FXML
    private void handleBtnRemove(ActionEvent event) {

        User user = chcUserList.getValue();

        arrayUsers.remove(user);

    }

    @FXML
    private void initialize(){

        chcUserList.setItems(arrayUsers.getUsersForVisualWithoutAdmin());

    }


}