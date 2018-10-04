package interfaces;
//в Userах вставлена ненужная переменная придумай как от нее избавится например с помощью нового класса TryCounter
public interface User {

 String getUserName();

 String getPassword();

 boolean isBlocked();

 boolean isRestriction();

 boolean equals(User user);

 void setBlock(boolean bBlock);

 void setRestriction(boolean bRestriction);

 void setPassword(String strPassword);

 void setTryCount(int nTryCount);

 int getTryCount();

 void addTryCount();

 void setUser(User user);


}
