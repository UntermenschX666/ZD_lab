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

    public boolean equals(User user){

        String strUsername = user.getUserName();
        String strPassword = user.getPassword();
        boolean bBlock = user.isBlocked();
        boolean bRestriction = user.isRestriction();

        if(this.strUserName.equals(strUsername) && this.strPassword.equals(strPassword)
                && this.bBlock == bBlock && this.bRestriction == bRestriction)
            return true;

        return false;
    }

    public void setBlock(boolean bBlock) {

        this.bBlock = bBlock;

    }

    public void setRestriction(boolean bRestriction){

        this.bRestriction = bRestriction;

    }

    public void setPassword(String strPassword){

        this.strPassword = strPassword;
    }

    public String toString(){

        return strUserName;

    }

}
