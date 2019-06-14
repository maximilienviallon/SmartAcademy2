package controller;


/**
 * the KeeperOfKeys is a class that will keep specific variable from controller in order to pass it to other controllers
 *
 */
public class KeeperOfKeys {


    private final static KeeperOfKeys LoggedUserNameInstance = new KeeperOfKeys();

    /**
     * this will create an instance of the keeper of keys so that the variable can be stored
     * @return
     */
    public static KeeperOfKeys getLoggedUserNameInstance() {
        return LoggedUserNameInstance;
    }


    /**
     * this method along with all of the ones below will create an instance of their respective controllers
     * in order to be able to fetch a specific variable, the idea being that it will then pass it on to the
     * instance of the keeper of keys
     */
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
