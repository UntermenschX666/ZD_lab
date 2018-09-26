package objects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.Serializable;

public class UserList implements Serializable {

    private ObservableList<User> userList = FXCollections.observableArrayList();

    public void add(User user){
        userList.add(user);
    }

    public void test(){

        userList.add(new User("admin","admin",false,false));
        userList.add(new User("Test1","123ko",false,false));
        userList.add(new User("Test2","54sd",false,false));
        userList.add(new User("Test3","asdad3",false,false));
        userList.add(new User("Test4","asda3",false,false));
        userList.add(new User("Test5","aaasd1",false,false));
    }

    public User getUser(String strUserName){

        for (User user:userList) {
            if (user.getUserName().equals(strUserName))
                return user;
        }

        return null;
    }


    public ObservableList<User> getUsers() {
        return userList;
    }

}
