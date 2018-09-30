package objects;

import interfaces.User;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class UserForTable implements User {

    private SimpleStringProperty sspUserName;
    private SimpleStringProperty sspPassword;
    private SimpleBooleanProperty sbpBlock;
    private SimpleBooleanProperty sbpRestriction;

    public UserForTable(String strUserName, String strPassword,
                            boolean bBlock, boolean bRestriction){

        sspUserName = new SimpleStringProperty(strUserName);
        sspPassword = new SimpleStringProperty(strPassword);
        sbpBlock = new SimpleBooleanProperty(bBlock);
        sbpRestriction = new SimpleBooleanProperty(bRestriction);

    }

    public UserForTable(User user){

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

}
