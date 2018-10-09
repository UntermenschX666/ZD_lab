package objects;

import interfaces.User;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class UserForVisual implements User, Serializable {

    private SimpleStringProperty sspUserName;
    private SimpleStringProperty sspPassword;
    private SimpleBooleanProperty sbpBlock;
    private SimpleBooleanProperty sbpRestriction;

    public UserForVisual(String strUserName, String strPassword,
                         boolean bBlock, boolean bRestriction){

        sspUserName = new SimpleStringProperty(strUserName);
        sspPassword = new SimpleStringProperty(strPassword);
        sbpBlock = new SimpleBooleanProperty(bBlock);
        sbpRestriction = new SimpleBooleanProperty(bRestriction);

    }

    public UserForVisual(User user){

        sspUserName = new SimpleStringProperty(user.getUserName());
        sspPassword = new SimpleStringProperty(user.getPassword());
        sbpBlock = new SimpleBooleanProperty(user.isBlocked());
        sbpRestriction = new SimpleBooleanProperty(user.isRestriction());

    }

    public String getUserName(){

        return  sspUserName.get();

    }

    public String getPassword() {

        return sspPassword.get();

    }

    public boolean isBlocked(){

        return sbpBlock.get();

    }

    public boolean isRestriction(){

        return  sbpRestriction.get();

    }

    public boolean equals(User user){

        String strUsername = user.getUserName();
        String strPassword = user.getPassword();
        boolean bBlock = user.isBlocked();
        boolean bRestriction = user.isRestriction();

        if(sspUserName.get().equals(strUsername) && sspPassword.get().equals(strPassword)
                && sbpBlock.get() == bBlock && sbpRestriction.get() == bRestriction)
            return true;

        return false;
    }


    public SimpleStringProperty sspUserNameProperty() {

        return sspUserName;

    }

    public SimpleStringProperty sspPasswordProperty() {

        return sspPassword;

    }

    public SimpleBooleanProperty sbpBlockProperty() {

        return sbpBlock;

    }

    public SimpleBooleanProperty sbpRestrictionProperty(){

        return sbpRestriction;

    }

    public void setBlock(boolean bBlock){

        sbpBlock.set(bBlock);

    }

    public void setRestriction(boolean bRestriction){

        sbpRestriction.set(bRestriction);

    }

    public void setPassword(String strPassword){

        sspPassword.set(strPassword);

    }

     public String toString(){

        return sspUserName.get();

    }

    public void setUser(User user){

        sspUserName.set(user.getUserName());
        sspPassword.set(user.getPassword());
        sbpBlock.set(user.isBlocked());
        sbpRestriction.set(user.isRestriction());

    }

}
