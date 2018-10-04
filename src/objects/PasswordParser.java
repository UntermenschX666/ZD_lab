package objects;

import interfaces.User;

public class PasswordParser {

    String strUserName;
    String strPassword;

    public PasswordParser(User user){

        this.strUserName = user.getUserName();
        this.strPassword = user.getPassword();

    }

    public boolean isCorrectPassward(){

        if(strPassword.equals(strUserName))
            return false;

        if(strPassword.length()<4)
            return false;

        return true;

    }

}
