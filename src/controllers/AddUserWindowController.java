package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import objects.UserForTable;

import static controllers.AdminWindowController.refreshTable;
import static start.Main.*;

public class AddUserWindowController {

    @FXML
    private Button btnClose;

    @FXML
    private TextField tfUserName;

    @FXML
    private CheckBox chbBlock;

    @FXML
    private CheckBox chbRestriction;

    @FXML
    private Button btnAdd;

    @FXML
    private Label lblMessege;

    @FXML
    private void handleBtnAdd(ActionEvent event) {

        String strUserName = tfUserName.getText();
        String strPassword = strStandartPassword;
        boolean bBlock = chbBlock.isSelected();
        boolean bRestriction = chbRestriction.isSelected();

        if(!arrayUsers.isUserOnList(strUserName)) {

            arrayUsers.add(new UserForTable(strUserName, strPassword, bBlock, bRestriction));
            refreshAddWindow();
            refreshTable();

            return;

        }

        lblMessege.setText("A user with that name already exists");

    }

    @FXML
    private void handleBtnClose(ActionEvent event) {

        stgAddUser.close();

    }

    private void refreshAddWindow(){

        lblMessege.setText("");
        tfUserName.setText("");
        chbBlock.setSelected(false);
        chbRestriction.setSelected(false);

    }

}

