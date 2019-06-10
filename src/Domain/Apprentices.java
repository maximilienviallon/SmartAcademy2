package Domain;

public class Apprentices {
private String CPR;
private String name;
private Integer companyID;
private String email;
private String phone;
private int apprenticeID;
private String workExperience;
private String generalExpertise;

    public Apprentices(String CPR, String name, int companyID, String email, String phone, int apprenticeID, String workExperience, String generalExpertise){
        this.CPR = CPR;
        this.name = name;
        this.companyID = companyID;
        this.email = email;
        this.phone = phone;
        this.apprenticeID = apprenticeID;
        this.workExperience = workExperience;
        this.generalExpertise = generalExpertise;
    }
    public String getCPR() {
        return CPR;
    }

    public void setCPR(String CPR) {
        this.CPR = CPR;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Integer companyID) {
        this.companyID = companyID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getApprenticeID() {
        return apprenticeID;
    }

    public void setApprenticeID(int apprenticeID) {
        this.apprenticeID = apprenticeID;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public String getGeneralExpertise() {
        return generalExpertise;
    }

    public void setGeneralExpertise(String generalExpertise) {
        this.generalExpertise = generalExpertise;
    }
}
