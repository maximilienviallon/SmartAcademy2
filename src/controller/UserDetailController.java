package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class UserDetailController  extends Controller implements Initializable {
    public void backToUserOverviewHandle(ActionEvent actionEvent) {
    }

    public void UserExportHandle(ActionEvent actionEvent) {
    }

    public void UserPrintHandle(ActionEvent actionEvent) {
    }

    public void UserEditHandle(ActionEvent actionEvent) {
    }

    public void UserRemoveHandle(ActionEvent actionEvent) {
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String userName = KeeperOfKeys.getLoggedUserNameInstance().currentUserName().getUserName();
        System.out.println(userName);
    }
}
