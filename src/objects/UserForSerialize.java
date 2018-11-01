package objects;

import interfaces.User;
import java.io.Serializable;

import static start.Main.strStandartPassword;

public class UserForSerialize implements User, Serializable {

    private String strUserName;
    private String strPassword;
    private boolean bBlock;
    private boolean bRestriction;
    private transient MyCrypt myCrypt;

    public UserForSerialize(String strUserName, boolean bBlock, boolean bRestriction){


        myCrypt = new MyCrypt(3);
        this.strUserName = strUserName;
        this.strPassword = strStandartPassword;
        this.bBlock = bBlock;
        this.bRestriction = bRestriction;

    }

    public  UserForSerialize(User user){
        myCrypt = new MyCrypt(3);
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

    public String getDecryptedPassword(){

        return myCrypt.decrypt(this.strPassword);
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

    public void setPassword(String strPassword) {

        this.strPassword = strPassword;

    }

    public void setUser(User user){

        this.strUserName = user.getUserName();
        this.strPassword = user.getPassword();
        this.bBlock = user.isBlocked();
        this.bRestriction = user.isRestriction();

    }

    public void setEncryptedPassword(String strPassword){

        this.strPassword = myCrypt.encrypt(strPassword);

    }

}
