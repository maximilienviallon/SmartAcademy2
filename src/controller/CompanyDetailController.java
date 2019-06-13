package controller;

import Domain.Companies;
import Persistence.DBFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CompanyDetailController  extends Controller implements Initializable {
    @FXML
    TextArea CompanyInfoArea;
    FXMLLoader fxmlLoader;
    String title;
    String username;
    Integer companyID;

    public void backToCompanyOverviewHandle(ActionEvent actionEvent) throws IOException {
        title = "Company Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/Company Overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void CompanyExportHandle(ActionEvent actionEvent) {
    }

    public void CompanyPrintHandle(ActionEvent actionEvent) {
    }

    public void CompanyEditHandle(ActionEvent actionEvent) throws IOException {
        title = "Company Modification";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/company modification.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void CompanyRemoveHandle(ActionEvent actionEvent) throws IOException {
        title = "Company Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/company overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void ShowEmployeesHandle(ActionEvent actionEvent) throws IOException {
        title = "Employee Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/apprentice overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }


    public void goToMatrixHandle(ActionEvent actionEvent) throws IOException{
        title = "Education Matrix";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/matrix.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username = KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();
        companyID = KeeperOfKeys.getLoggedUserNameInstance().currentCompanyID().getsCompanyID();
        Companies detailView =  DBFacade.retrieveCompanyDetail(companyID).get(0);
        CompanyInfoArea.setText(detailView.getName() + "\n" + detailView.getFieldOfExpertise() + "\n" + detailView.getCity() + "\n" + detailView.getStreet() + "\n" + detailView.getZipcode() + "\n" + detailView.getWebpage() + "\n" + detailView.getCvr() + "\n" + detailView.getpNum() + "\n" + detailView.getInfo());

    }

}
