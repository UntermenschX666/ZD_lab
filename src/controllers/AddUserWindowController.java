package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import objects.UserForVisual;

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

        String strUserName = tfUserName.getText().toLowerCase();
        boolean bBlock = chbBlock.isSelected();
        boolean bRestriction = chbRestriction.isSelected();
        int intSize = arrayUsers.getSize();


        if(!checkCorrectUsername(strUserName)){

            lblMessege.setText("Incorrect username");
            return;
        }

        arrayUsers.add(new UserForVisual(strUserName, bBlock, bRestriction));

        if(intSize == arrayUsers.getSize()) {

            lblMessege.setText("A user with that name already exists");

            return;

        }

        refreshAddWindow();

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

    private boolean checkCorrectUsername(String strUserName){

        if(strUserName.isEmpty())
            return false;

        if(strUserName.length()<2)
            return false;

        if(!strUserName.matches("^[a-z0-9]+$"))
            return false;


        return true;

    }

}

