package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import objects.UserForTable;

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
    void handleBtnAdd(ActionEvent event) {

        String strUserName = tfUserName.getText();
        String strPassword = strStandartPassword;
        boolean bBlock = chbBlock.isSelected();
        boolean bRestriction = chbRestriction.isSelected();

        arrayUsers.add(new UserForTable(strUserName, strPassword, bBlock, bRestriction));

        tfUserName.setText("");
        chbBlock.setSelected(false);
        chbRestriction.setSelected(false);

        AdminWindowController.refreshTable();
    }

    @FXML
    void handleBtnClose(ActionEvent event) {

        stgAddUser.close();

    }

}

