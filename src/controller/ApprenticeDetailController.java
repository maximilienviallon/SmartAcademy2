package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class ApprenticeDetailController  extends Controller implements Initializable {
    public void backToApprenticeOverviewHandle(ActionEvent actionEvent) {
    }

    public void ApprenticeExportHandle(ActionEvent actionEvent) {
    }

    public void ApprenticePrintHandle(ActionEvent actionEvent) {
    }

    public void ApprenticeEditHandle(ActionEvent actionEvent) {
    }

    public void ApprenticeRemoveHandle(ActionEvent actionEvent) {
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String userName = KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();
        System.out.println(userName);
    }
}
