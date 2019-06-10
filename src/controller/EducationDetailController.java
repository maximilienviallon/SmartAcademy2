package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class EducationDetailController  extends Controller implements Initializable {
    public void backToEducationOverviewHandle(ActionEvent actionEvent) {
    }

    public void EducationExportHandle(ActionEvent actionEvent) {
    }

    public void EducationPrintHandle(ActionEvent actionEvent) {
    }

    public void EducationEditHandle(ActionEvent actionEvent) {
    }

    public void EducationRemoveHandle(ActionEvent actionEvent) {
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String userName = KeeperOfKeys.getUserNameInstance().currentUserName().getUserName();
        System.out.println(userName);
    }
}
