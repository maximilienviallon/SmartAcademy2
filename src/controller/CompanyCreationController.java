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

public class CompanyCreationController  extends Controller implements Initializable {
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

    public void companyCreationSaveHandle(ActionEvent actionEvent)throws IOException {
        KeeperOfKeys.getLoggedUserNameInstance().currentCompanyID().setsCompanyID(DBFacade.insertCompany(companyCreationName.getText(),CompanyCreationFieldOfExp.getText(),CompanyCreationZipCode.getText(),creationCvrNumber.getText(),creationPNumber.getText(),companyCreationCity.getText(),creationWebPage.getText(),companyCreationStreet.getText(), CompanyCreationInformation.getText()));
        title = "Company Detail";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/company detail.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void companyCreationCancelHandle(ActionEvent actionEvent) throws IOException{
        title = "Company Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/Company overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username = KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();

    }
}
