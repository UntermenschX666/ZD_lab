package objects;

public class TryCount {

    private int tryCount;
    private String strUserName;

    public TryCount(String strUserName){

        this.strUserName = strUserName;
        this.tryCount = 0;

    }


    public String getUserName(){

        return strUserName;

    }

    public int getTryCount(){

        return this.tryCount;

    }


    public void addTry(){

        tryCount++;

    }

}
