package objects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.ArrayList;

public class UserList implements Serializable {

    private ObservableList<User> userList = FXCollections.observableArrayList();

    public void add(User user){
        userList.add(user);
    }

    public void test(){
        userList.add(new User("Test1","",false,false));
        userList.add(new User("Test2","",false,false));
        userList.add(new User("Test3","",false,false));
        userList.add(new User("Test4","",false,false));
        userList.add(new User("Test5","",false,false));
    }

    public ObservableList<User> getUsers() {
        return userList;
    }

}
