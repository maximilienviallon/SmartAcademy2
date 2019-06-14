package controller;

import Persistence.DBFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CompanyCreationController extends Controller implements Initializable {
    String title;
    FXMLLoader fxmlLoader;
    String username;
    @FXML
    TextField companyCreationName;
    @FXML
    TextField CompanyCreationFieldOfExp;
    @FXML
    TextField CompanyCreationZipCode;
    @FXML
    TextField creationCvrNumber;
    @FXML
    TextField companyCreationStreet;
    @FXML
    TextField creationPNumber;
    @FXML
    TextField creationWebPage;
    @FXML
    TextField companyCreationCity;
    @FXML
    TextArea CompanyCreationInformation;

    public void companyCreationSaveHandle(ActionEvent actionEvent) throws IOException {
        String name = companyCreationName.getText();
        String fieldOfExp = CompanyCreationFieldOfExp.getText();
        String zipcode = CompanyCreationZipCode.getText();
        String CVR = creationCvrNumber.getText();
        String pNum = creationPNumber.getText();
        String city = companyCreationCity.getText();
        String webpage = creationWebPage.getText();
        String street = companyCreationStreet.getText();
        String info = CompanyCreationInformation.getText();

        if (companyValidation(name, fieldOfExp, zipcode, CVR, pNum, city, webpage, street, info)) {
            KeeperOfKeys.getLoggedUserNameInstance().currentCompanyID().setsCompanyID(DBFacade.insertCompany(name, fieldOfExp, zipcode, CVR, pNum, city, webpage, street, info));
            title = "Company Detail";
            fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/company detail.fxml"));
            fxmlLoading(fxmlLoader, title);
            ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
        }
    }

    public boolean companyValidation(String name, String fieldOfExp, String zipcode, String CVR, String pNum, String city, String webpage, String street, String info) {
if (!name.isEmpty()&&!zipcode.isEmpty()&&!CVR.isEmpty()&&!city.isEmpty()&&!street.isEmpty()){
        return true;
}
return false;
    }

    public void companyCreationCancelHandle(ActionEvent actionEvent) throws IOException {
        title = "Company Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/Company overview.fxml"));
        fxmlLoading(fxmlLoader, title);
        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username = KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();

    }
}
