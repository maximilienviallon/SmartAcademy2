package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class LoggedUserModificationController  extends Controller implements Initializable {
    public void loggedUserModBackToOverviewHandle(ActionEvent actionEvent) {
    }

    public void LoggedUserModSaveHandle(ActionEvent actionEvent) {
    }

    public void loggedUserModCancelHandle(ActionEvent actionEvent) {
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String userName = KeeperOfKeys.getLoggedUserNameInstance().currentUserName().getUserName();
        System.out.println(userName);
    }
}
