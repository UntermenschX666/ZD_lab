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
import javafx.stage.Stage;
import javafx.util.Callback;

import java.util.ArrayList;

import static start.Main.*;

public class AdminWindowController {



    @FXML
    private TableView tbvTableUsers;

    @FXML
    private TableColumn<User, String> tbcUsername;

    @FXML
    private TableColumn<User, Boolean> tbcBlocked;

    @FXML
    private TableColumn<User, Boolean> tbcRestrictions;

    @FXML
    private MenuBar mbMenu;

    @FXML
    private Button btnAddUser;

    @FXML
    private Button btnRemoveUser;

    @FXML
    private Button btnSaveChanges;

    @FXML
    private Button btnEndSession;

    @FXML
    private void handleMiChangePassword(ActionEvent event) throws Exception{

        stgChangePassword = new Stage();

        createWindow(stgChangePassword, strNameChangePassword,
                FXMLLoader.load(getClass().getResource(strPathFxmlChangePasswordWindow)));

        setModalWindow(stgChangePassword,stgAdmin);

        stgChangePassword.show();
    }

    @FXML
    private void handleBtnEndSession(ActionEvent event) throws Exception{

        if(!compareTableAndArrrayUesers(arrBufferUsers,arrayUsers.getUsersForVisual())){

            stgSaveChanges = new Stage();

            createWindow(stgSaveChanges,strNameSaveChengesWindow,
                    FXMLLoader.load(getClass().getResource(strPathFxmlSaveChangesWindow)));

            setModalWindow(stgSaveChanges,stgAdmin);

            stgSaveChanges.show();

            return;

        }

        stgAuthorization.show();
        stgAdmin.close();

    }

    @FXML
    private void handleBtnSaveChanges(ActionEvent event) {

        arrayUsers.serializeUsers(fUsersFile);

    }

    @FXML
    private void handleBtnAddUser(ActionEvent event) throws Exception{

        stgAddUser = new Stage();

        createWindow(stgAddUser, strNameAddUserWindow,
                FXMLLoader.load(getClass().getResource(strPathFxmlAddUserWindow)));

        setModalWindow(stgAddUser,stgAdmin);

        stgAddUser.show();

    }

    @FXML
    private void handleBtnRemoveUser(ActionEvent event) throws Exception{

        //stgRemoveUser = new Stage();

        //createWindow(stgRemoveUser, strNameRemoveUserWindow,
        //FXMLLoader.load(getClass().getResource(strPathFxmlRemoveUserWindow)));

        //setModalWindow(stgRemoveUser,stgAdmin);

        //stgRemoveUser.show();

        User selectUser = (User)tbvTableUsers.getSelectionModel().getSelectedItem();

        if(selectUser == null)
            return;

        if(selectUser.getUserName().equals(strAdminName))
            return;

        arrayUsers.remove(selectUser);

    }

    @FXML
    private void initialize() throws Exception{

        arrBufferUsers = new ArrayList<User>();

        outToTableView();

    }

    private void outToTableView() {

        tbvTableUsers.setEditable(true);


        tbcUsername.setCellValueFactory(
                new PropertyValueFactory<User,String>("sspUserName")
        );

        createCheckBoxInTable(tbcBlocked,true);

        createCheckBoxInTable(tbcRestrictions,false);

        //Обязательно буффер должен состоять из UserForSerialize иначе ничего не сохраниться
        arrBufferUsers = saveBufferTableUsers(arrayUsers.getUsersForSerialize());

        tbvTableUsers.setItems(arrayUsers.getUsersForVisual());

    }

    private void createCheckBoxInTable(TableColumn<User,Boolean> tbcValue, boolean bRestOrBlock){

        tbcValue.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<User, Boolean>,
                ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<User, Boolean> param) {

                User user = param.getValue();

                SimpleBooleanProperty booleanProp;

                if(bRestOrBlock)
                    booleanProp = new SimpleBooleanProperty(user.isBlocked());
                else
                    booleanProp = new SimpleBooleanProperty(user.isRestriction());


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

    private ArrayList<User> saveBufferTableUsers(ObservableList<User> arrSaved){

        ArrayList<User> arrBuffer = new ArrayList<User>();

        for(User user : arrSaved)
            arrBuffer.add(user);

        return arrBuffer;

    }

    private boolean compareTableAndArrrayUesers(ArrayList<User> arrPrevUsers, ObservableList<User> arrCurUsers){


        if(arrPrevUsers.size() != arrCurUsers.size())
            return false;

        for(int i = 0; i < arrCurUsers.size(); i++){

            User firstUser = arrPrevUsers.get(i); User secondUser = arrCurUsers.get(i);

            if(!firstUser.equals(secondUser))
                return false;

        }

        return true;

    }
}
