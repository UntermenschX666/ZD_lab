package objects;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;

public class User {

    private SimpleStringProperty sstrpUserName;
    private SimpleStringProperty sstrpPassword;
    private SimpleBooleanProperty sbpBlock;
    private SimpleBooleanProperty sbpRestriction;

    public User(String strUserName,String strPassword,
                boolean bBlock,boolean bRestriction){

        sstrpUserName = new SimpleStringProperty(strUserName);
        sstrpPassword = new SimpleStringProperty(strPassword);
        sbpBlock = new SimpleBooleanProperty(bBlock);
        sbpRestriction = new SimpleBooleanProperty(bRestriction);

    }

    public SimpleStringProperty sstrpUserNameProperty(){
        return sstrpUserName;
    }

    public SimpleStringProperty sstrpPasswordProperty(){
        return sstrpPassword;
    }

    public SimpleBooleanProperty sbpBlockProperty(){
        return sbpBlock;
    }

    public SimpleBooleanProperty sbpRestrictionProperty(){
        return sbpRestriction;
    }

    public String getUserName(){
        return  sstrpUserName.get();
    }

    public String getPassword() { return sstrpPassword.get(); }

    public boolean isBlocked(){
        return sbpBlock.get();
    }
    public boolean isRestriction(){
        return  sbpRestriction.get();
    }
}
