package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class LogBrowserController  extends Controller implements Initializable {
    public void logSearchHandle(ActionEvent actionEvent) {
    }

    public void logBackToOverviewHandle(ActionEvent actionEvent) {
    }

    public void logExportHandle(ActionEvent actionEvent) {
    }

    public void logPrintHandle(ActionEvent actionEvent) {
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String userName = KeeperOfKeys.getLoggedUserNameInstance().currentUserName().getUserName();
        System.out.println(userName);
    }
}
