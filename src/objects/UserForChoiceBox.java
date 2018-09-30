package objects;

import interfaces.User;

public class UserForChoiceBox implements User {

    private String strUserName;
    private String strPassword;
    private boolean bBlock;
    private boolean bRestriction;

    public UserForChoiceBox(String strUserName, String strPassword,
                            boolean bBlock, boolean bRestriction){

        this.strUserName = strUserName;
        this.strPassword = strPassword;
        this.bBlock = bBlock;
        this.bRestriction = bRestriction;

    }

    public  UserForChoiceBox(User user){

        strUserName = user.getUserName();
        strPassword = user.getPassword();
        bBlock = user.isBlocked();
        bRestriction = user.isRestriction();

    }

    public String getUserName(){

        return  strUserName;

    }

    public String getPassword() {

        return strPassword;

    }

    public boolean isBlocked(){

        return bBlock;

    }

    public boolean isRestriction(){

        return  bRestriction;

    }

    public void setBlock(boolean bBlock) {

        this.bBlock = bBlock;

    }

    public void setRestriction(boolean bRestriction){

        this.bRestriction = bRestriction;

    }

    public String toString(){

        return strUserName;

    }

}
