package Domain;

public class Contacts {
    private Integer conID;
    private Integer companyID;
    private String name;
    private String email;
    private String phoneNo;
    public Contacts(Integer conID, Integer companyID, String name, String email, String phoneNo){
        this.conID = conID;
        this.companyID = companyID;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    public Integer getContactID() {
        return conID;
    }

    public void setConID(Integer conID) {
        this.conID = conID;
    }

    public Integer getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Integer companyID) {
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
