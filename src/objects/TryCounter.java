package objects;

import interfaces.User;
import javafx.collections.ObservableList;

public class TryCounter {

    private TryCount[] arrTryCount;
    private int tryCountEnd;

    public TryCounter(ObservableList<User> arrUsers){

        arrTryCount = new TryCount[arrUsers.size()];
        int i = 0;

        for(User user : arrUsers){

            arrTryCount[i] = new TryCount(user.getUserName());
            i++;

        }

        tryCountEnd = 3;

    }

    public void addTryCountByUsername(String strUserName){

       int i = findIndexByUserName(strUserName);

       if(i<0)
           return;

       arrTryCount[i].addTry();

    }

    public boolean isTryCountEnd(String strUserName){

        int i = findIndexByUserName(strUserName);

        if(arrTryCount[i].getTryCount() == tryCountEnd)
            return true;

        return false;

    }

    public void setTryCountEnd(int tryCountEnd){

        this.tryCountEnd = tryCountEnd;

    }

    private int findIndexByUserName(String strUserName){

        for(int i = 0; i < arrTryCount.length; i++){

            if(arrTryCount[i].getUserName().equals(strUserName))
                return i;

        }

        return -1;

    }

}
