package objects;

import interfaces.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.*;
import java.util.ArrayList;

public class ArrayUsers {

    private ObservableList<User> arrUsers;

    public ArrayUsers(User user){

        arrUsers = FXCollections.observableArrayList();
        arrUsers.add(user);

    }

    public ArrayUsers(){

        arrUsers = FXCollections.observableArrayList();
    }

    public void remove(User user){

        arrUsers.remove(user);

    }


    private void removeByName( String strUserName){

        User user = getUser(strUserName);

        if(user == null)
            return;

        if(!isUserOnList(strUserName))
            return;

        arrUsers.remove(user);

    }

    public void add(User user){

        //Ensures that all users on the list have a unique name
        if(isUserOnList(user.getUserName()))
            return;

        arrUsers.add(user);

    }

    public void test(){

        arrUsers.add(new UserForSerialize("Test1","123ko",true,false));
        arrUsers.add(new UserForSerialize("Test2","54sd",false,false));
        arrUsers.add(new UserForSerialize("Test3","asdad3",false,false));
        arrUsers.add(new UserForSerialize("Test4","asda3",false,false));
        arrUsers.add(new UserForSerialize("Test5","aaasod1",false,false));

    }

    public int getSize(){

        return arrUsers.size();

    }

    public User getUser(String strUserName){

        for (User user:arrUsers) {
            if (user.getUserName().equals(strUserName))
                return user;
        }

        return null;

    }
    //подправить иначе крашится отображение на форме ппри смене пороля
    public void replaceUser(User userReplacement){

        User userTarget;

        for (int i = 0; i < arrUsers.size(); i++) {

            userTarget = arrUsers.get(i);

            if(userTarget.getUserName().equals(userReplacement.getUserName())){
                arrUsers.set(i,userReplacement);
            }

        }

    }

    public boolean isUserOnList(String strUserName){

        User user = getUser(strUserName);

        if (user == null)
            return false;

        return true;
    }

    public boolean serializeUsers(File file){

        convertToSerializeUsers();

        ArrayList<User> arrBuffer = convertFromObserbListToArrayList(arrUsers);

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){

            oos.writeObject(arrBuffer);

        }catch (Exception e){

            return false;

        }

        return true;

    }

    public boolean deserializeUsers(File file){

        arrUsers.clear();

        ArrayList<User> arrBuffer = new ArrayList<User>();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){

            arrBuffer = ((ArrayList<User>)ois.readObject());

        }catch(Exception e){

            return false;

        }

        arrUsers = convertFromArrayListToObserbList(arrBuffer);

        convertToVisualUsers();

        return true;

    }

    public ObservableList<User> getUsersForSerialize() {

        convertToSerializeUsers();

        return arrUsers;

    }

    public ObservableList<User> getUsersForVisual(){

        convertToVisualUsers();

        return arrUsers;

    }

    //Не защищенный метод
    public void replaceArrayList(ArrayList<User> arrReplacment){

        arrUsers.clear();

        for(User user : arrReplacment)
            arrUsers.add(user);

    }


    private ObservableList<User> convertFromArrayListToObserbList(ArrayList<User> fromList){

        ObservableList<User> toList = FXCollections.observableArrayList();

        for(User user : fromList){
            toList.add(user);
        }

        return toList;
    }

    private ArrayList<User> convertFromObserbListToArrayList(ObservableList<User> fromList){

        ArrayList<User> toList = new ArrayList<User>();

        for(User user : fromList){
            toList.add(user);
        }

        return toList;
    }



    private void convertToVisualUsers(){

        for (int i = 0; i < arrUsers.size(); i++) {
            User user = arrUsers.get(i);
            arrUsers.set(i,new UserForVisual(user));

        }

    }

    private void convertToSerializeUsers(){

        for (int i = 0; i < arrUsers.size(); i++) {
            User user = arrUsers.get(i);
            arrUsers.set(i,new UserForSerialize(user));

        }

    }




}
