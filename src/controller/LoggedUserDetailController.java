package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class LoggedUserDetailController  extends Controller implements Initializable {
    public void backToApprenticeOverviewHandle(ActionEvent actionEvent) {
    }

    public void loggedUserDetailPrintHandle(ActionEvent actionEvent) {
    }

    public void LoggedUserDetailEditHandle(ActionEvent actionEvent) {
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String userName = KeeperOfKeys.getLoggedUserNameInstance().currentUserName().getUserName();
        System.out.println(userName);
    }
}
