package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import static start.Main.stgRemoveUser;

public class RemoveUserWindowController {

    @FXML
    private Button btnClose;

    @FXML
    private Button btnRemove;

    @FXML
    private ChoiceBox<?> chcUserList;

    @FXML
    void handleBtnClose(ActionEvent event) {

        stgRemoveUser.close();

    }

    @FXML
    void handleBtnRemove(ActionEvent event) {


    }

    @FXML
    private void initialize(){


    }

}