package controllers;

import interfaces.User;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import static start.Main.*;

public class SaveChangesWindowController {

    @FXML
    private Button btnYes;

    @FXML
    private Button btnNo;

    @FXML
    void handleBtnNo(ActionEvent event) {


        arrayUsers.replaceArrayList(arrBufferUsers);

        stgAuthorization.show();
        stgSaveChanges.close();
        stgAdmin.close();

    }

    @FXML
    void handleBtnYes(ActionEvent event) {

        arrayUsers.serializeUsers(fUsersFile);
        //messegebox

        stgSaveChanges.close();
        stgAdmin.close();
        stgAuthorization.show();

    }


}

