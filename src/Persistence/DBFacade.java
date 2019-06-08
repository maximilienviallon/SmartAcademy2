package Persistence;

import Domain.Companies;

import java.sql.Date;
import java.util.ArrayList;

public class DBFacade {

    public static boolean checkLogin (boolean doneLogin, String loginIDTextField, String logInPasswordID) {

        try {

            DB.selectSQL("select fldUsername from tblUsers");
            do  {


                String username = DB.getData();

                if (username.equals(loginIDTextField)) {
                    System.out.println("Username has been found in DB: " + username);

                    do {
                        DB.selectSQL("select fldPassword from tblUsers where fldUsername = '"+ loginIDTextField + "'");
                        String pass = DB.getData();
                        if (pass.equals(logInPasswordID)) {
                            System.out.println("Password is a match for given username...Login Done ");
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

    public static Integer[] checkYourPrivilege(String userName){
        String query = ("select fldCompanyID from tblPermissions where fldPermissionID in (select fldPermissionID from tblUserPermissionBridge where fldUsername = '" + userName + "')");
        ArrayList<Object[]> privilegeQuery = DB.select(query);
        Integer[] companyPrivileges = new Integer[privilegeQuery.size()];
        int positionChecker = 0;
        for (Object[] objects : privilegeQuery) {
            companyPrivileges[positionChecker]= (int) objects[0];
            positionChecker++;
        }
        return companyPrivileges;
    }

    public static ArrayList<Companies> retrieveCompanies(Integer[] companyList){
            ArrayList<Companies> retrievedCompanies = new ArrayList<>();

            try {
                String query = ("select fldCompanyName, fldFieldOfExpertise, fldCompanyZipcode, fldCVRNum, fldPNum from tblCompanies where fldCompanyID in (");
                for (int companyID:companyList) {
                    query+= (companyID + ",");
                }
query = query.substring(0,query.length()-1) + ")";

                ArrayList<Object[]> companyQuery = DB.select(query);

                for (Object[] objects : companyQuery) {
                    String name = (String) objects[0];
                    String fieldOfExpertise = (String) objects[0];
                    String zipcode = (String) objects[0];
                    String cvr = (String) objects[0];
                    String pNum = (String) objects[0];
                    //String city = (String) objects[0];

                    Companies companies = new Companies(name,fieldOfExpertise,zipcode,cvr,pNum, null);

                    retrievedCompanies.add(companies);
                }

            } catch (NullPointerException e) {
                e.printStackTrace();


            }
            return retrievedCompanies;

    }

}
