package Persistence;

import Domain.*;

import java.sql.Date;
import java.util.ArrayList;

public class DBFacade {

    public static boolean checkLogin(boolean doneLogin, String loginIDTextField, String logInPasswordID) {

        try {

            DB.selectSQL("select fldUsername from tblUsers");
            do {


                String username = DB.getData();

                if (username.equals(loginIDTextField)) {
                    System.out.println("Username has been found in DB: " + username);

                    do {
                        DB.selectSQL("select fldPassword from tblUsers where fldUsername = '" + loginIDTextField + "'");
                        String pass = DB.getData();
                        if (pass.equals(logInPasswordID)) {
                            System.out.println("Password is a match for given username...Login Done ");
                            return doneLogin == true;
                        } else System.out.println("Access Denied , wrong password");
                    } while (true);
                }
            } while (true);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Execute Done ");
        return false;
    }

    public static String checkPermission(String userName) {
        DB.selectSQL("select fldPermission from tblPermissions where fldPermissionID in (select fldPermissionID from tblUserPermissionBridge where fldUsername = '" + userName + "')");
        String permissionTier = DB.getData();
        System.out.println(permissionTier);

        return permissionTier;
    }

    public static Integer[] checkYourPrivilege(String userName) {
        String query = ("select fldCompanyID from tblPermissions where fldPermissionID in (select fldPermissionID from tblUserPermissionBridge where fldUsername = '" + userName + "')");
        ArrayList<Object[]> privilegeQuery = DB.select(query);
        Integer[] companyPrivileges = new Integer[privilegeQuery.size()];
        int positionChecker = 0;
        for (Object[] objects : privilegeQuery) {
            companyPrivileges[positionChecker] = (int) objects[0];
            positionChecker++;
        }
        return companyPrivileges;
    }

    public static ArrayList<Companies> retrieveCompanies(Integer[] companyList) {
        ArrayList<Companies> retrievedCompanies = new ArrayList<>();

        try {
            String query = ("select tblCompanies.fldCompanyID, tblCompanies.fldCompanyName, tblCompanies.fldFieldOfExpertise, tblCompanies.fldCompanyZipcode, tblCompanies.fldCVRNum, tblCompanies.fldPNum, tblZipcode.fldCity from tblCompanies left join tblZipcode on tblCompanies.fldCompanyZipcode = tblZipcode.fldZipcode where fldCompanyID in (");
            for (int companyID : companyList) {
                query += (companyID + ",");
            }
            query = query.substring(0, query.length() - 1) + ")";

            ArrayList<Object[]> companyQuery = DB.select(query);

            for (Object[] objects : companyQuery) {
                int companyID = (int) objects[0];
                String name = (String) objects[1];
                String fieldOfExpertise = (String) objects[2];
                String zipcode = (String) objects[3];
                String cvr = (String) objects[4];
                String pNum = (String) objects[5];
                String city = (String) objects[6];

                Companies companies = new Companies(companyID, name, fieldOfExpertise, zipcode, cvr, pNum, city);

                retrievedCompanies.add(companies);
            }

        } catch (NullPointerException e) {
            e.printStackTrace();

        }
        return retrievedCompanies;

    }

    public static ArrayList<Apprentices> retrieveApprentices() {
        ArrayList<Apprentices> retrievedApprentices = new ArrayList<>();

        try {
            String query = ("select fldApprenticeCPR, fldApprenticeName, fldCompanyID, fldApprenticeEmail, fldApprenticePhone, fldApprenticeID from tblApprentices");
            ArrayList<Object[]> apprenticeQuery = DB.select(query);

            for (Object[] objects : apprenticeQuery) {
                String CPR = (String) objects[0];
                String name = (String) objects[1];
                int companyID = (int) objects[2];
                String email = (String) objects[3];
                String phone = (String) objects[4];
                int apprenticeID = (int) objects[5];

                Apprentices apprentices = new Apprentices(CPR, name, companyID, email, phone, apprenticeID);

                retrievedApprentices.add(apprentices);
            }

        } catch (NullPointerException e) {
            e.printStackTrace();


        }
        return retrievedApprentices;

    }

    public static ArrayList<Apprentices> retrieveApprentices(int selectedCompany) {
        ArrayList<Apprentices> retrievedApprentices = new ArrayList<>();

        try {
            String query = ("select fldApprenticeCPR, fldApprenticeName, fldCompanyID, fldApprenticeEmail, fldApprenticePhone, fldApprenticeID from tblApprentices where fldCompanyID = " + selectedCompany);
            ArrayList<Object[]> apprenticeQuery = DB.select(query);

            for (Object[] objects : apprenticeQuery) {
                String CPR = (String) objects[0];
                String name = (String) objects[1];
                int companyID = (int) objects[2];
                String email = (String) objects[3];
                String phone = (String) objects[4];
                int apprenticeID = (int) objects[5];

                Apprentices apprentices = new Apprentices(CPR, name, companyID, email, phone, apprenticeID);

                retrievedApprentices.add(apprentices);
            }

        } catch (NullPointerException e) {
            e.printStackTrace();


        }
        return retrievedApprentices;

    }

    public static ArrayList<Contacts> retrieveContacts(int selectedCompany) {
        ArrayList<Contacts> retrievedContacts = new ArrayList<>();

        try {
            String query = ("select fldConID, fldCompanyID, fldConName, fldConEmail, fldConPhoneNo from tblContacts where fldCompanyID = " + selectedCompany);
            ArrayList<Object[]> apprenticeQuery = DB.select(query);

            for (Object[] objects : apprenticeQuery) {
                int conID = (int) objects[0];
                int companyID = (int) objects[1];
                String name = (String) objects[2];
                String email = (String) objects[3];
                String phoneNo = (String) objects[4];

                Contacts contacts = new Contacts(conID, companyID, name, email, phoneNo);

                retrievedContacts.add(contacts);
            }

        } catch (NullPointerException e) {
            e.printStackTrace();


        }
        return retrievedContacts;

    }

    public static ArrayList<Educations> retrieveEducations() {
        ArrayList<Educations> retrievedEducations = new ArrayList<>();

        try {
            String query = ("select tblEducations.fldEduID, tblAMU.fldEduName, tblZipcode.fldCity,fldEduStart, tblEducations.fldEduEnd,tblEducations.fldAMU,tblEducations.fldEduZipcode from tblEducations left join tblAMU on tblEducations.fldAMU = tblAMU.fldAMU left join tblZipcode on tblEducations.fldEduZipcode = tblZipcode.fldZipcode");
            ArrayList<Object[]> educationsQuery = DB.select(query);

            for (Object[] objects : educationsQuery) {
                Integer eduID = (Integer) objects[0];
                String name = (String) objects[1];
                String city = (String) objects[2];
                Date eduStart = (Date) objects[3];
                Date eduEnd = (Date) objects[4];
                Integer AMU = (Integer) objects[5];
                String zipcode = (String) objects[6];

                Educations educations = new Educations(eduID,name,city,eduStart,eduEnd,AMU,zipcode);

                retrievedEducations.add(educations);
            }

        } catch (NullPointerException e) {
            e.printStackTrace();


        }
        return retrievedEducations;

    }

    public static ArrayList<Permissions> retrievePermissions() {
        ArrayList<Permissions> retrievedPermissions = new ArrayList<>();

        try {
            String query = ("select * from tblPermissions");
            ArrayList<Object[]> permissionsQuery = DB.select(query);

            for (Object[] objects : permissionsQuery) {
                String permission = (String) objects[0];
                Integer permissionID = (Integer) objects[1];
                Integer companyID = (Integer) objects[2];


                Permissions permissions = new Permissions(permission,permissionID,companyID);

                retrievedPermissions.add(permissions);
            }

        } catch (NullPointerException e) {
            e.printStackTrace();


        }
        return retrievedPermissions;

    }

    public static ArrayList<Permissions> retrievePermissions(int selectedCompany) {
        ArrayList<Permissions> retrievedPermissions = new ArrayList<>();

        try {
            String query = ("select * from tblPermissions where fldCompanyID = " + selectedCompany);
            ArrayList<Object[]> permissionsQuery = DB.select(query);

            for (Object[] objects : permissionsQuery) {
                String permission = (String) objects[0];
                Integer permissionID = (Integer) objects[1];
                Integer companyID = (Integer) objects[2];


                Permissions permissions = new Permissions(permission,permissionID,companyID);

                retrievedPermissions.add(permissions);
            }

        } catch (NullPointerException e) {
            e.printStackTrace();


        }
        return retrievedPermissions;

    }

}
