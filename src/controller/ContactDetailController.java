package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class ContactDetailController  extends Controller implements Initializable {
    public void backToContactOverviewHandle(ActionEvent actionEvent) {
    }

    public void ContactExportHandle(ActionEvent actionEvent) {
    }

    public void ContactPrintHandle(ActionEvent actionEvent) {
    }

    public void ContactEditHandle(ActionEvent actionEvent) {
    }

    public void ContactRemoveHandle(ActionEvent actionEvent) {
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String userName = KeeperOfKeys.getUserNameInstance().currentUserName().getUserName();
        System.out.println(userName);
    }
}
