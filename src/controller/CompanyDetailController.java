package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CompanyDetailController  extends Controller implements Initializable {
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
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        companyID = KeeperOfKeys.getLoggedUserNameInstance().currentCompanyID().getsCompanyID();
        String userName = KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();
        System.out.println(userName);
    }
}
