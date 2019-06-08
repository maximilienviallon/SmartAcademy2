package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class CompanyDetailController  extends Controller implements Initializable {
    public void backToCompanyOverviewHandle(ActionEvent actionEvent) {
    }

    public void CompanyExportHandle(ActionEvent actionEvent) {
    }

    public void CompanyPrintHandle(ActionEvent actionEvent) {
    }

    public void CompanyEditHandle(ActionEvent actionEvent) {
    }

    public void CompanyRemoveHandle(ActionEvent actionEvent) {
    }

    public void ShowEmployeeHandle(ActionEvent actionEvent) {
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String userName = KeeperOfKeys.getInstance().currentUserName().getUserName();
        System.out.println(userName);
    }
}
