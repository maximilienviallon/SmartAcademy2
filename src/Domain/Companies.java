package Domain;

public class Companies {
private Integer CompanyID;
private String name;
private String fieldOfExpertise;
private String zipcode;
private String cvr;
private String pNum;
private String city;
private String webpage;
private String street;
private String info;
    public Companies(){

    }
    public Companies(Integer CompanyID, String name, String fieldOfExpertise, String zipcode, String cvr, String pNum, String city, String webpage, String street, String info){
        this.CompanyID = CompanyID;
        this.name = name;
        this.fieldOfExpertise = fieldOfExpertise;
        this.zipcode = zipcode;
        this.cvr = cvr;
        this.pNum = pNum;
        this.city = city;
        this.webpage = webpage;
        this.street=street;
        this.info=info;
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

    public Integer getCompanyID() {
        return CompanyID;
    }

    public void setCompanyID(Integer companyID) {
        CompanyID = companyID;
    }

    public String getWebpage() {
        return webpage;
    }

    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
