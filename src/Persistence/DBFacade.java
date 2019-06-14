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

                Companies companies = new Companies(companyID, name, fieldOfExpertise, zipcode, cvr, pNum, city, null, null, null);

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

                Apprentices apprentices = new Apprentices(CPR, name, companyID, email, phone, apprenticeID, null, null);

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

                Apprentices apprentices = new Apprentices(CPR, name, companyID, email, phone, apprenticeID, null, null);

                retrievedApprentices.add(apprentices);
            }

        } catch (NullPointerException e) {
            e.printStackTrace();


        }
        return retrievedApprentices;

    }

    public static ArrayList<Contacts> retrieveContacts(Integer selectedCompany) {
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

                Contacts contacts = new Contacts(conID, companyID, name, email, phoneNo, null, null);

                retrievedContacts.add(contacts);
            }

        } catch (NullPointerException e) {
            e.printStackTrace();


        }
        return retrievedContacts;

    }

    public static ArrayList<Contacts> retrieveContacts() {
        ArrayList<Contacts> retrievedContacts = new ArrayList<>();

        try {
            String query = ("select fldConID, fldCompanyID, fldConName, fldConEmail, fldConPhoneNo from tblContacts");
            ArrayList<Object[]> apprenticeQuery = DB.select(query);

            for (Object[] objects : apprenticeQuery) {
                int conID = (int) objects[0];
                int companyID = (int) objects[1];
                String name = (String) objects[2];
                String email = (String) objects[3];
                String phoneNo = (String) objects[4];

                Contacts contacts = new Contacts(conID, companyID, name, email, phoneNo, null, null);

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
            String query = ("select tblEducations.fldEduID, tblAMU.fldEduName, tblEducations.fldEduProvider, tblZipcode.fldCity,fldEduStart, tblEducations.fldEduEnd,tblEducations.fldAMU,tblEducations.fldEduZipcode from tblEducations left join tblAMU on tblEducations.fldAMU = tblAMU.fldAMU left join tblZipcode on tblEducations.fldEduZipcode = tblZipcode.fldZipcode");
            ArrayList<Object[]> educationsQuery = DB.select(query);

            for (Object[] objects : educationsQuery) {
                Integer eduID = (Integer) objects[0];
                String name = (String) objects[1];
                String provider = (String) objects[2];
                String city = (String) objects[3];
                Date eduStart = (Date) objects[4];
                Date eduEnd = (Date) objects[5];
                Integer AMU = (Integer) objects[6];
                String zipcode = (String) objects[7];

                Educations educations = new Educations(eduID, name, provider, city, eduStart, eduEnd, AMU, zipcode, null);

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


                Permissions permissions = new Permissions(permission, permissionID, companyID);

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


                Permissions permissions = new Permissions(permission, permissionID, companyID);

                retrievedPermissions.add(permissions);
            }

        } catch (NullPointerException e) {
            e.printStackTrace();


        }
        return retrievedPermissions;

    }

    public static ArrayList<Users> retrieveUsers() {
        ArrayList<Users> retrievedUsers = new ArrayList<>();

        try {
            String query = ("select distinct machine.fldPermission, tblUsers.fldUsername, tblApprentices.fldApprenticeName, tblContacts.fldConName from tblUsers left join tblUserBridge on tblUsers.fldUsername = tblUserBridge.fldUsername left join tblContacts on tblUserBridge.fldConID = tblContacts.fldConID left join tblApprentices on tblUserBridge.fldApprenticeID = tblApprentices.fldApprenticeID left join (select tblUserPermissionBridge.fldUsername, simplifier.fldPermissionID, simplifier.fldPermission from tblUserPermissionBridge left outer join tblPermissions as simplifier on(tblUserPermissionBridge.fldPermissionID = simplifier.fldPermissionID AND simplifier.fldPermissionID=(select top 1 complicator.fldPermissionID from tblPermissions as complicator where complicator.fldPermissionID = tblUserPermissionBridge.fldPermissionID order by complicator.fldPermissionID))) machine on tblUsers.fldUsername=machine.fldUsername order by tblUsers.fldUsername");
            ArrayList<Object[]> usersQuery = DB.select(query);

            for (Object[] objects : usersQuery) {
                String permission = (String) objects[0];
                String username = (String) objects[1];
                String apprenticeName = (String) objects[2];
                String conName = (String) objects[3];


                Users users = new Users(permission, username, apprenticeName, conName);

                retrievedUsers.add(users);
            }

        } catch (NullPointerException e) {
            e.printStackTrace();


        }
        return retrievedUsers;

    }

    public static ArrayList<Companies> retrieveCompanyDetail(int requestedID) {
        ArrayList<Companies> retrievedCompanies = new ArrayList<>();

        try {
            String query = ("select fldCompanyID, fldCompanyName, fldFieldOfExpertise, fldZipcode, fldCVRNum, fldPNum, fldCity, fldWebpage, fldStreet, fldCompanyInfo from tblCompanies left join tblZipcode on tblCompanies.fldCompanyZipcode = tblZipcode.fldZipcode where fldCompanyID = " + requestedID);
            ArrayList<Object[]> companyQuery = DB.select(query);

            for (Object[] objects : companyQuery) {
                int companyID = (int) objects[0];
                String name = (String) objects[1];
                String fieldOfExpertise = (String) objects[2];
                String zipcode = (String) objects[3];
                String cvr = (String) objects[4];
                String pNum = (String) objects[5];
                String city = (String) objects[6];
                String webpage = (String) objects[7];
                String street = (String) objects[8];
                String info = (String) objects[9];

                Companies companies = new Companies(companyID, name, fieldOfExpertise, zipcode, cvr, pNum, city, webpage, street, info);

                retrievedCompanies.add(companies);
            }

        } catch (NullPointerException e) {
            e.printStackTrace();

        }
        return retrievedCompanies;

    }

    public static ArrayList<Apprentices> retrieveApprenticeDetail(int selectedApprentice) {
        ArrayList<Apprentices> retrievedApprentices = new ArrayList<>();

        try {
            String query = ("select * from tblApprentices where fldApprenticeID = " + selectedApprentice);
            ArrayList<Object[]> apprenticeQuery = DB.select(query);

            for (Object[] objects : apprenticeQuery) {
                String CPR = (String) objects[0];
                String name = (String) objects[1];
                int companyID = (int) objects[2];
                String email = (String) objects[3];
                String phone = (String) objects[4];
                String workExperience = (String) objects[5];
                String generalExpertise = (String) objects[6];
                int apprenticeID = (int) objects[7];

                Apprentices apprentices = new Apprentices(CPR, name, companyID, email, phone, apprenticeID, workExperience, generalExpertise);

                retrievedApprentices.add(apprentices);
            }

        } catch (NullPointerException e) {
            e.printStackTrace();


        }
        return retrievedApprentices;

    }

    public static ArrayList<Contacts> retrieveContactDetail(Integer selectedContact) {
        ArrayList<Contacts> retrievedContacts = new ArrayList<>();

        try {
            String query = ("select * from tblContacts where fldConID = " + selectedContact);
            ArrayList<Object[]> apprenticeQuery = DB.select(query);

            for (Object[] objects : apprenticeQuery) {
                int conID = (int) objects[0];
                int companyID = (int) objects[1];
                String name = (String) objects[2];
                String email = (String) objects[3];
                String phoneNo = (String) objects[4];
                String landline = (String) objects[5];
                String info = (String) objects[6];

                Contacts contacts = new Contacts(conID, companyID, name, email, phoneNo, landline, info);

                retrievedContacts.add(contacts);
            }

        } catch (NullPointerException e) {
            e.printStackTrace();


        }
        return retrievedContacts;

    }

    public static ArrayList<Educations> retrieveEducationDetail(Integer selectedEducation) {
        ArrayList<Educations> retrievedEducations = new ArrayList<>();

        try {
            String query = ("select tblEducations.fldEduID, tblAMU.fldEduName, tblEducations.fldEduProvider, tblZipcode.fldCity,fldEduStart, tblEducations.fldEduEnd,tblEducations.fldAMU,tblEducations.fldEduZipcode, tblEducations.fldEduDesc from tblEducations left join tblAMU on tblEducations.fldAMU = tblAMU.fldAMU left join tblZipcode on tblEducations.fldEduZipcode = tblZipcode.fldZipcode where tblEducations.fldEduID = " + selectedEducation);
            ArrayList<Object[]> educationsQuery = DB.select(query);

            for (Object[] objects : educationsQuery) {
                Integer eduID = (Integer) objects[0];
                String name = (String) objects[1];
                String provider = (String) objects[2];
                String city = (String) objects[3];
                Date eduStart = (Date) objects[4];
                Date eduEnd = (Date) objects[5];
                Integer AMU = (Integer) objects[6];
                String zipcode = (String) objects[7];
                String description = (String) objects[8];

                Educations educations = new Educations(eduID, name, provider, city, eduStart, eduEnd, AMU, zipcode, description);

                retrievedEducations.add(educations);
            }

        } catch (NullPointerException e) {
            e.printStackTrace();


        }
        return retrievedEducations;

    }

    public static ArrayList<Users> retrieveUsersByPermissions(Integer selectedPermissions) {
        ArrayList<Users> retrievedUsers = new ArrayList<>();

        try {
            String query = ("select distinct machine.fldPermission, tblUsers.fldUsername, tblApprentices.fldApprenticeName, tblContacts.fldConName from tblUsers left join tblUserBridge on tblUsers.fldUsername = tblUserBridge.fldUsername left join tblContacts on tblUserBridge.fldConID = tblContacts.fldConID left join tblApprentices on tblUserBridge.fldApprenticeID = tblApprentices.fldApprenticeID left join (select tblUserPermissionBridge.fldUsername, simplifier.fldPermissionID, simplifier.fldPermission from tblUserPermissionBridge left outer join tblPermissions as simplifier on(tblUserPermissionBridge.fldPermissionID = simplifier.fldPermissionID AND simplifier.fldPermissionID=(select top 1 complicator.fldPermissionID from tblPermissions as complicator where complicator.fldPermissionID = tblUserPermissionBridge.fldPermissionID order by complicator.fldPermissionID))) machine on tblUsers.fldUsername=machine.fldUsername where tblUsers.fldUsername in(select fldUsername from tblUserPermissionBridge where tblUserPermissionBridge.fldPermissionID = " + selectedPermissions + ") order by tblUsers.fldUsername");
            ArrayList<Object[]> usersQuery = DB.select(query);

            for (Object[] objects : usersQuery) {
                String permission = (String) objects[0];
                String username = (String) objects[1];
                String apprenticeName = (String) objects[2];
                String conName = (String) objects[3];


                Users users = new Users(permission, username, apprenticeName, conName);

                retrievedUsers.add(users);
            }

        } catch (NullPointerException e) {
            e.printStackTrace();


        }
        return retrievedUsers;
    }

    public static ArrayList<Matrix> retrieveMatrix(Integer selectedCompany) {
        ArrayList<Matrix> retrievedMatrix = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> priorities = new ArrayList<>();
        try {
            String prequery = ("select tblEducations.fldAMU, tblAMU.fldEduName, tblEducations.fldEduProvider, tblZipcode.fldCity,");
            String query = (" from tblEducations ");
            String query2 = ("select tblApprentices.fldApprenticeID, tblApprentices.fldApprenticeName from tblApprentices where tblApprentices.fldCompanyID = " + selectedCompany);
            ArrayList<Object[]> usersQuery2 = DB.select(query2);
            for (Object[] object : usersQuery2) {
                prequery += (" matrix" + object[0] + ".fldPriority,");
                query += (" left join (select * from tblMatrix where tblMatrix.fldApprenticeID = " + object[0] + ") matrix" + object[0] + " on tblEducations.fldEduID = matrix" + object[0] + ".fldEduID ");
                names.add((String) object[1]);
            }

            query += (" left join tblAMU on tblEducations.fldAMU = tblAMU.fldAMU left join tblZipcode on tblEducations.fldEduZipcode = tblZipcode.fldZipcode where tblEducations.fldEduID in (select tblMatrix.fldEduID from tblMatrix where tblMatrix.fldApprenticeID in (select tblApprentices.fldApprenticeID from tblApprentices where tblApprentices.fldCompanyID = " + selectedCompany + "))");
            query = prequery.substring(0, prequery.length() - 1) + query;
            ArrayList<Object[]> usersQuery = DB.select(query);

            for (Object[] objects : usersQuery) {
                Integer AMU = (Integer) objects[0];
                String name = (String) objects[1];
                String provider = (String) objects[2];
                String city = (String) objects[3];
                priorities.add((String) objects[4]);

                Matrix matrix = new Matrix(AMU, name, provider, city, names, priorities);

                retrievedMatrix.add(matrix);
            }

        } catch (NullPointerException e) {
            e.printStackTrace();


        }
        return retrievedMatrix;
    }

    public static Integer insertCompany(String name, String fieldOfExpertise, String zipcode, String cvr, String pNum, String city, String webpage, String street, String info) {
        Integer returnedID = 1;
        String query = ("insert into tblCompanies values ('" + name + "','" + fieldOfExpertise + "', '" + zipcode + "', '" + cvr + "', '" + pNum + "', '" + webpage + "', '" + street + "', '" + info + "');");
        String query2 = ("BEGIN\n" +
                "        IF NOT EXISTS (SELECT 1 FROM tblZipcode  WHERE tblZipcode.fldZipcode = '" + zipcode + "')\n" +
                "        BEGIN\n" +
                "        INSERT INTO tblZipcode VALUES ('" + zipcode + "','" + city + "')\n" +
                "        END \n" +
                "                END");
        String query3 = ("IF EXISTS (select 1 from tblCompanies where tblCompanies.fldCompanyName = '" + name + "' and tblCompanies.fldCompanyZipcode='" + zipcode + "' and tblCompanies.fldCVRNum = '" + cvr + "' and (tblCompanies.fldPNum = '" + pNum + "' or tblCompanies.fldPNum is null) and (tblCompanies.fldFieldOfExpertise = '" + fieldOfExpertise + "' or tblCompanies.fldFieldOfExpertise is null) and tblCompanies.fldStreet = '" + street + "' and (tblCompanies.fldWebpage = '" + webpage + "' or tblCompanies.fldWebpage is null) and (tblCompanies.fldCompanyInfo = '" + info + "' or tblCompanies.fldCompanyInfo is null))\n" +
                "BEGIN\n" +
                "select TOP 1 tblCompanies.fldCompanyID from tblCompanies where tblCompanies.fldCompanyName = '" + name + "' and tblCompanies.fldCompanyZipcode='" + zipcode + "' and tblCompanies.fldCVRNum = '" + cvr + "' and (tblCompanies.fldPNum = '" + pNum + "' or tblCompanies.fldPNum is null) and (tblCompanies.fldFieldOfExpertise = '" + fieldOfExpertise + "' or tblCompanies.fldFieldOfExpertise is null) and tblCompanies.fldStreet = '" + street + "' and (tblCompanies.fldWebpage = '" + webpage + "' or tblCompanies.fldWebpage is null) and (tblCompanies.fldCompanyInfo = '" + info + "' or tblCompanies.fldCompanyInfo is null) order by tblCompanies.fldCompanyID desc\n" +
                "END");
        DB.execute(query2);
        DB.execute(query);
        DB.selectSQL(query3);
        do {
            String data = DB.getData();
            if (data.equals(DB.NOMOREDATA)) {
                break;
            } else {
                returnedID = Integer.valueOf(data.trim());
            }
        } while (true);

        String query4 = ("insert into tblPermissions values ('Interviewer',"+returnedID.intValue()+");");
        String query5 = ("insert into tblPermissions values ('HR',"+returnedID.intValue()+");");
        DB.execute(query4);
        DB.execute(query5);

        return returnedID;
    }
}
