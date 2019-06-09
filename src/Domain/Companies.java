package Domain;

public class Companies {
private int CompanyID;
private String name;
private String fieldOfExpertise;
private String zipcode;
private String cvr;
private String pNum;
private String city;

    public Companies(int CompanyID, String name, String fieldOfExpertise, String zipcode, String cvr, String pNum, String city){
        this.CompanyID = CompanyID;
        this.name = name;
        this.fieldOfExpertise = fieldOfExpertise;
        this.zipcode = zipcode;
        this.cvr = cvr;
        this.pNum = pNum;
        this.city = city;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFieldOfExpertise() {
        return fieldOfExpertise;
    }

    public void setFieldOfExpertise(String fieldOfExpertise) {
        this.fieldOfExpertise = fieldOfExpertise;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCvr() {
        return cvr;
    }

    public void setCvr(String cvr) {
        this.cvr = cvr;
    }

    public String getpNum() {
        return pNum;
    }

    public void setpNum(String pNum) {
        this.pNum = pNum;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCompanyID() {
        return CompanyID;
    }

    public void setCompanyID(int companyID) {
        CompanyID = companyID;
    }
}
