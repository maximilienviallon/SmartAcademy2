package Domain;

public class Contacts {
    private Integer conID;
    private Integer companyID;
    private String name;
    private String email;
    private String phoneNo;
    private String landline;
    private String info;
    public Contacts(Integer conID, Integer companyID, String name, String email, String phoneNo, String landline, String info){
        this.conID = conID;
        this.companyID = companyID;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.landline = landline;
        this.info = info;
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

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
