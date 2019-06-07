package controller;

public class KeeperOfKeys {
    private final static KeeperOfKeys instance = new KeeperOfKeys();


    public static KeeperOfKeys getInstance() {
        return instance;
    }



    private LogInController logInCont = new LogInController();

    public LogInController currentUserName(){
        return logInCont;
    }

}
