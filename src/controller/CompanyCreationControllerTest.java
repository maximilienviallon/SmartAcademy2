package controller;

import static org.junit.Assert.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class CompanyCreationControllerTest {
    public CompanyCreationController instance;

    @org.junit.Before
    public void setUp() throws Exception {
        instance = new CompanyCreationController();
    }

    @Test
    public void companyValidationEmpty() {
        String name = "";
        String fieldOfExp = "";
        String zipcode = "";
        String CVR = "";
        String pNum = "";
        String city = "";
        String webpage = "";
        String street = "";
        String info = "";


boolean expected = false;
boolean actual = instance.companyValidation(name,fieldOfExp,zipcode,CVR,pNum,city,webpage,street,info);
        assertEquals(expected,actual);
    }

    @Test
    public void companyValidationTrue() {
        String name = "xh";
        String fieldOfExp = "xth";
        String zipcode = "xthf";
        String CVR = "xhtf";
        String pNum = "xthf";
        String city = "xthf";
        String webpage = "xhft";
        String street = "xhft";
        String info = "xhtf";


        boolean expected = true;
        boolean actual = instance.companyValidation(name,fieldOfExp,zipcode,CVR,pNum,city,webpage,street,info);
        assertEquals(expected,actual);
    }

    @Test
    public void companyValidationNull() {
        String name = null;
        String fieldOfExp = null;
        String zipcode = null;
        String CVR = null;
        String pNum = null;
        String city = null;
        String webpage = null;
        String street = null;
        String info = null;


        boolean expected = false;
        boolean actual;
        try {
            actual = instance.companyValidation(name, fieldOfExp, zipcode, CVR, pNum, city, webpage, street, info);
        }
        catch(NullPointerException e)
        {
            actual = false;
        }
        assertEquals(expected,actual);
    }

    @Test
    public void companyValidationPartial() {
        String name = "xhtf";
        String fieldOfExp = "";
        String zipcode = "xhtf";
        String CVR = "xhtf";
        String pNum = "";
        String city = "xhtf";
        String webpage = "";
        String street = "xfht";
        String info = "";


        boolean expected = true;
        boolean actual = instance.companyValidation(name,fieldOfExp,zipcode,CVR,pNum,city,webpage,street,info);
        assertEquals(expected,actual);
    }
}