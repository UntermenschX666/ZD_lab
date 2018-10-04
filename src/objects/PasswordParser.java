package objects;

import interfaces.User;

public class PasswordParser {

    String strNewPassword;

    public PasswordParser(String strNewPassword){

        this.strNewPassword = strNewPassword;

    }

    public boolean isCorrectPassword(String strUserName){

        if(strNewPassword.equals(strUserName))
            return false;

        if(strNewPassword.length()<3)
            return false;

        return true;

    }

}
