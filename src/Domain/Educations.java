package Domain;

import java.sql.Date;

public class Educations {
    private Integer eduID;
    private String name;
    private String city;
    private Date eduStart;
    private Date eduEnd;
    private Integer AMU;
    private String zipcode;
    private String description;

    public Educations(Integer eduID, String name, String city, Date eduStart, Date eduEnd, Integer AMU, String zipcode, String description){
        this.eduID = eduID;
        this.name = name;
        this.city = city;
        this.eduStart = eduStart;
        this.eduEnd = eduEnd;
        this.AMU = AMU;
        this.zipcode = zipcode;
        this.description = description;
    }

    public Integer getEduID() {
        return eduID;
    }

    public void setEduID(Integer eduID) {
        this.eduID = eduID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getEduStart() {
        return eduStart;
    }

    public void setEduStart(Date eduStart) {
        this.eduStart = eduStart;
    }

    public Date getEduEnd() {
        return eduEnd;
    }

    public void setEduEnd(Date eduEnd) {
        this.eduEnd = eduEnd;
    }

    public Integer getAMU() {
        return AMU;
    }

    public void setAMU(Integer AMU) {
        this.AMU = AMU;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
//JESUS