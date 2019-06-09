package Domain;

public class Contacts {
    private int conID;
    private int companyID;
    private String name;
    private String email;
    private String phoneNo;
    public Contacts(int conID, int companyID, String name, String email, String phoneNo){
        this.conID = conID;
        this.companyID = companyID;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    public int getConID() {
        return conID;
    }

    public void setConID(int conID) {
        this.conID = conID;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
