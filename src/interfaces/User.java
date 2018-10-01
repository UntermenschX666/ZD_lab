package interfaces;

public interface User {

 String getUserName();

 String getPassword();

 boolean isBlocked();

 boolean isRestriction();

 void setBlock(boolean bBlock);

 void setRestriction(boolean bRestriction);

 void setPassword(String strPassword);

}
