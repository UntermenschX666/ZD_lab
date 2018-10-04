package objects;

import interfaces.User;
import java.io.Serializable;

//Костыль от бога вставлять лишнюю переменную просто пиздец, когда нет времени как придумать нормально TryCount
public class UserForSerialize implements User, Serializable {

    private String strUserName;
    private String strPassword;
    private boolean bBlock;
    private boolean bRestriction;
    private int nTryCount;

    public UserForSerialize(String strUserName, String strPassword,
                            boolean bBlock, boolean bRestriction){

        this.strUserName = strUserName;
        this.strPassword = strPassword;
        this.bBlock = bBlock;
        this.bRestriction = bRestriction;
        nTryCount = 0;

    }

    public  UserForSerialize(User user){

        strUserName = user.getUserName();
        strPassword = user.getPassword();
        bBlock = user.isBlocked();
        bRestriction = user.isRestriction();
        nTryCount = 0;

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

    public void setPassword(String strPassword) {

        this.strPassword = strPassword;

    }

    public int getTryCount(){

        return nTryCount;

    }

    public void setTryCount(int nTryCount){

        this.nTryCount = nTryCount;

    }

    public void addTryCount(){

        this.nTryCount += 1;

    }

    public void setUser(User user){

        this.strUserName = user.getUserName();
        this.strPassword = user.getPassword();
        this.bBlock = user.isBlocked();
        this.bRestriction = user.isRestriction();

    }

}
