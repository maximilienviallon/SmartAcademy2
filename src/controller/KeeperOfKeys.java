package controller;

public class KeeperOfKeys {

    private final static KeeperOfKeys apprenticeIDInstance = new KeeperOfKeys();
    public static KeeperOfKeys getApprenticeIDInstance(){
        return apprenticeIDInstance;
    }


    private final static KeeperOfKeys companyIDInstance = new KeeperOfKeys();
    public static KeeperOfKeys getCompanyIDInstance() {
        return companyIDInstance;
    }


    private final static KeeperOfKeys contactIDInstance = new KeeperOfKeys();
    public static KeeperOfKeys getContactIDInstance(){
        return contactIDInstance;
    }


    private final static KeeperOfKeys educationIDInstance = new KeeperOfKeys();
    public static KeeperOfKeys getEducationIDInstance(){
        return educationIDInstance;
    }


    private final static KeeperOfKeys LoggedUserNameInstance = new KeeperOfKeys();
    public static KeeperOfKeys getLoggedUserNameInstance() {
        return LoggedUserNameInstance;
    }


    private final static KeeperOfKeys permissionIDInstance = new KeeperOfKeys();
    public final KeeperOfKeys getPermissionIDInstance(){
        return permissionIDInstance;
    }

    private final static KeeperOfKeys userIDInstance = new KeeperOfKeys();
    public final KeeperOfKeys getUserIDInstance(){
        return userIDInstance;
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


    private LogInController logInCont = new LogInController();
    public LogInController currentUserName(){
        return logInCont;
    }


    private PermissionOverviewController permOverCont = new PermissionOverviewController();
    public PermissionOverviewController currentPermissionID(){
        return permOverCont;
    }
}
