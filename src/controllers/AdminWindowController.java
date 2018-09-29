package controllers;

import interfaces.User;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

import static start.Main.*;
import start.Main;

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

        stgAuthorization.show();
        stgAdmin.close();

    }

    @FXML
    void handleBtnSaveChanges(ActionEvent event) {

    }

    @FXML
    void handleMiAdd(ActionEvent event) throws Exception{

        stgAddUser = new Stage();

        CreateWindow(stgAddUser, strNameAddUserWindow,
                FXMLLoader.load(getClass().getResource(strPathFxmlAddUserWindow)),
        440,290);

        stgAddUser.initModality(Modality.WINDOW_MODAL);
        stgAddUser.initOwner(stgAdmin);

        stgAddUser.show();

    }

    @FXML
    void handleMiRemove(ActionEvent event) throws Exception{

        stgRemoveUser = new Stage();

        CreateWindow(stgRemoveUser, strNameRemoveUserWindow,
                FXMLLoader.load(getClass().getResource(strPathFxmlRemoveUserWindow)),
        440,290);

        stgRemoveUser.initModality(Modality.WINDOW_MODAL);
        stgRemoveUser.initOwner(stgAdmin);

        stgRemoveUser.show();

    }

    @FXML
    private void initialize(){

        OutToTableView();

    }

    private void OutToTableView() {

        usersTable = FXCollections.observableArrayList(AuthorizationWindowController.arrayUsers.getUsersForTable());

        tbvUserList.setEditable(true);

        tbcUsername.setCellValueFactory(
                new PropertyValueFactory<User,String>("sspUserName")
        );

        tbcPassword.setCellValueFactory(
                new PropertyValueFactory<User,String>("sspPassword")
        );

        CreateCheckBoxInTable(tbcBlocked,true);

        CreateCheckBoxInTable(tbcRestrictions,false);

        tbvUserList.setItems(usersTable);

    }

    private void CreateCheckBoxInTable(TableColumn<User,Boolean> tbcValue, boolean bRestOrBlock){

        tbcValue.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<User, Boolean>,
                ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<User, Boolean> param) {

                User user = param.getValue();

                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(user.isBlocked());

                booleanProp.addListener(new ChangeListener<Boolean>() {

                    @Override
                    public void changed(ObservableValue<? extends Boolean> observable,
                                        Boolean oldValue, Boolean newValue) {

                        if (bRestOrBlock)
                            user.setBlock(newValue);
                        else
                            user.setRestriction(newValue);

                    }

                });

                return booleanProp;

            }

        });

        tbcValue.setCellFactory(new Callback<TableColumn<User, Boolean>,
                TableCell<User, Boolean>>() {

            @Override
            public TableCell<User, Boolean> call(TableColumn<User, Boolean> p) {

                CheckBoxTableCell<User, Boolean> cell = new CheckBoxTableCell<User, Boolean>();

                cell.getStylesheets().add(strStyleCheckBoxInTable);

                cell.setAlignment(Pos.CENTER);

                return cell;

            }

        });


    }

}
