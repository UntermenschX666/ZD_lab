package objects;

public class User {

    private String strUserName;
    private String strPassword;
    private boolean bBlock;
    private boolean bRestriction;

    public User(String strUserName, String strPassword, boolean bBlock, boolean bRestriction){

        this.strUserName = strUserName;
        this.strPassword = strPassword;
        this.bBlock=bBlock;
        this.bRestriction=bRestriction;

    }

    public String getUserName(){
        return  strUserName;
    }

    public String getPassword(){
        return strPassword;
    }

    public boolean isBlocked(){
        return bBlock;
    }
    public boolean isRestriction(){
        return  bRestriction;
    }
}
