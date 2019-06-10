package controller;

public class KeeperOfKeys {


    private final static KeeperOfKeys LoggedUserNameInstance = new KeeperOfKeys();
    public static KeeperOfKeys getLoggedUserNameInstance() {
        return LoggedUserNameInstance;
    }



    private ApprenticeOverviewController apprOverCont = new ApprenticeOverviewController();
    public ApprenticeOverviewController currentApprenticeID(){
        return apprOverCont;
    }


    private CompanyOverviewController compOverCont = new CompanyOverviewController();
    public CompanyOverviewController currentCompanyID(){
        return compOverCont;
    }


    private ContactOverviewController contOverCont = new ContactOverviewController();
    public ContactOverviewController currentContactID(){
        return contOverCont;
    }


    private EducationOverviewController educOverCont = new EducationOverviewController();
    public EducationOverviewController currentEducationID(){
        return educOverCont;
    }


    private PermissionOverviewController permContOver = new PermissionOverviewController();
    public PermissionOverviewController currentPermissionID(){
        return permContOver;
    }

    private LogInController logInCont = new LogInController();
    public LogInController currentLoggedUserName(){
        return logInCont;
    }

    private UserOverviewController userOverCont = new UserOverviewController();
    public UserOverviewController currentUserName(){
        return userOverCont;
    }


}
