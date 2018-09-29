package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import static start.Main.stgAddUser;

public class AddUserWindowController {

    @FXML
    private Button btnClose;

    @FXML
    private TextField tfUsername;

    @FXML
    private CheckBox chbBlock;

    @FXML
    private CheckBox chbRestriction;

    @FXML
    private Button btnAdd;

    @FXML
    void handleBtnAdd(ActionEvent event) {

    }

    @FXML
    void handleBtnClose(ActionEvent event) {

        stgAddUser.close();

    }

}

