package objects;

import interfaces.User;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

import static start.Main.strStandartPassword;

public class UserForVisual implements User, Serializable {

    private SimpleStringProperty sspUserName;
    private SimpleStringProperty sspPassword;
    private SimpleBooleanProperty sbpBlock;
    private SimpleBooleanProperty sbpRestriction;
    private transient MyCrypt myCrypt;

    public UserForVisual(String strUserName,
                         boolean bBlock, boolean bRestriction){

        myCrypt = new MyCrypt(3);
        sspUserName = new SimpleStringProperty(strUserName);
        sspPassword = new SimpleStringProperty(strStandartPassword);
        sbpBlock = new SimpleBooleanProperty(bBlock);
        sbpRestriction = new SimpleBooleanProperty(bRestriction);

    }

    public UserForVisual(User user){
        myCrypt = new MyCrypt(3);
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

    public String getDecryptedPassword(){

        return myCrypt.decrypt(sspPassword.get());

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

        sspPassword = new SimpleStringProperty(strPassword);

    }

    public void setEncryptedPassword(String strPassword){

        sspPassword = new SimpleStringProperty(myCrypt.encrypt(strPassword));

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
