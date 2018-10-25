package interfaces;
//пассы в юзере теперь валяются в зашифрованом виде
public interface User {

 String getUserName();

 String getPassword();

 String getDecryptedPassword();

 boolean isBlocked();

 boolean isRestriction();

 boolean equals(User user);

 void setBlock(boolean bBlock);

 void setRestriction(boolean bRestriction);

 void setPassword(String strPassword);

 void setUser(User user);

}
