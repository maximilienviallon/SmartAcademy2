package controller;

public class KeeperOfKeys {
    private final static KeeperOfKeys userNameInstance = new KeeperOfKeys();


    public static KeeperOfKeys getUserNameInstance() {
        return userNameInstance;
    }

    public static KeeperOfKeys getCompanyIDInstance() {
        return companyIDInstance;
    }

    private final static KeeperOfKeys companyIDInstance = new KeeperOfKeys();

    private LogInController logInCont = new LogInController();

    public LogInController currentUserName(){
        return logInCont;
    }

    private CompanyOverviewController compOverCont = new CompanyOverviewController();

    public CompanyOverviewController currentCompanyID(){
        return compOverCont;
    }
}
