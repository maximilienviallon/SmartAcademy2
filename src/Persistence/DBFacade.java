package Persistence;

public class DBFacade {

    public static boolean checkLogin (boolean doneLogin, String loginIDTextField, String logInPasswordID) {

        try {

            DB.selectSQL("select fldUserName from tblUsers");
            do  {


                String username = DB.getData();

                if (username.equals(loginIDTextField)) {
                    System.out.println("Email Found in DB: " + username);

                    do {
                        DB.selectSQL("select fldPassword from tblUsers");
                        String pass = DB.getData();
                        if (pass.equals(logInPasswordID)) {
                            System.out.println("Password Match the Email...Login Done ");
                            return doneLogin == true;
                        } else System.out.println("Access Denied , wrong password");
                    }while (true);
                }
            }while(true);

        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Execute Done ");
        return false;
    }

    public static String checkPermission(String userName){

        DB.selectSQL("select fldPermission from tblPermissions where fldPermissionID in (select fldPermissionID from tblUserPermissionBridge where fldUsername = '" + userName + "')");
        String permissionTier = DB.getData();
        System.out.println(permissionTier);

        return permissionTier;
    }


}
