package controller;

public class KeeperOfKeys {
    private final static KeeperOfKeys instance = new KeeperOfKeys();


    public static KeeperOfKeys getInstance() {
        return instance;
    }



    private LogInScreenController logInCont = new LogInScreenController();

    public LogInScreenController currentUserName(){
        return logInCont;
    }

}
