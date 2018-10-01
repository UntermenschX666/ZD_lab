package objects;

import interfaces.User;

import java.io.*;
import java.util.ArrayList;

public class ArrayUsers {

    private ArrayList<User> arrUsers;

    public ArrayUsers(User user){

        arrUsers = new ArrayList<User>();
        arrUsers.add(user);

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

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){

            oos.writeObject(arrUsers);

        }catch (Exception e){

            return false;

        }

        return true;

    }

    public boolean deserializeUsers(File file){

        arrUsers.clear();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){

            arrUsers = (ArrayList<User>)ois.readObject();

        }catch(Exception e){

            return false;

        }

        return true;

    }

    public ArrayList<User> getUsersForSerialize() {

        convertToSerializeUsers();

        return arrUsers;

    }

    public ArrayList<User> getUsersForTable(){

        convertToTableUsers();

        return arrUsers;

    }

    public ArrayList<User> getUsersForChoiceBox(){

        convertToChoiceBoxUsers();

        return arrUsers;

    }




    private void convertToChoiceBoxUsers(){

        for (int i = 0; i < arrUsers.size(); i++) {

            arrUsers.set(i,new UserForChoiceBox(arrUsers.get(i)));

        }

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
