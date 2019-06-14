package Domain;

import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

public class Matrix {
private Integer AMU;
private String name;
private String provider;
private String city;
private  ArrayList<String> names;
private static ArrayList<String> priorities;


    public Matrix(Integer AMU, String name, String provider, String city, ArrayList<String> names, ArrayList<String> priorities){
        this.AMU = AMU;
        this.name = name;
        this.provider = provider;
        this.city = city;
        this.names = names;
        this.priorities = priorities;
    }



    public Integer getAMU() {
        return AMU;
    }

    public void setAMU(Integer AMU) {
        this.AMU = AMU;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public void setNames(ArrayList<String> names) {
        this.names = names;
    }

    public static ArrayList<String> getPriorities() {
        return priorities;
    }

    public void setPriorities(ArrayList<String> priorities) {
        this.priorities = priorities;
    }


}
