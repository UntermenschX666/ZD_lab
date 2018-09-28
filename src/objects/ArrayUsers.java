package objects;

import interfaces.User;
import java.util.ArrayList;
import objects.UserForTable;
import objects.UserForSerialize;

public class ArrayUsers {

    private ArrayList<User> arrUsers;

    public ArrayUsers(){

        arrUsers = new ArrayList<User>();

    }

    public void add(User user){

        arrUsers.add(user);

    }

    public void test(){

        arrUsers.add(new UserForTable("admin","",false,false));
        arrUsers.add(new UserForSerialize("Test1","123ko",false,false));
        arrUsers.add(new UserForSerialize("Test2","54sd",false,false));
        arrUsers.add(new UserForSerialize("Test3","asdad3",false,false));
        arrUsers.add(new UserForSerialize("Test4","asda3",false,false));
        arrUsers.add(new UserForSerialize("Test5","aaasod1",false,false));

    }


    public User getUser(String strUserName){

        for (User user:arrUsers) {
            if (user.getUserName().equals(strUserName))
                return user;
        }

        return null;

    }


    public ArrayList<User> getUsersForSerialize() {

        convertToSerializeUsers();

        return arrUsers;

    }

    public ArrayList<User> getUsersForTable(){

        convertToTableUsers();

        return arrUsers;

    }

    private void convertToTableUsers(){

        for (int i = 0; i < arrUsers.size(); i++) {
            arrUsers.set(i,new UserForTable(arrUsers.get(i)));

        }

    }

    private void convertToSerializeUsers(){

        for (int i = 0; i < arrUsers.size(); i++) {
            arrUsers.set(i,new UserForSerialize(arrUsers.get(i)));

        }

    }

}
