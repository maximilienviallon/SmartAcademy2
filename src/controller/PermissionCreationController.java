package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class PermissionCreationController  extends Controller implements Initializable {
    public void permissionCreationSaveHandle(ActionEvent actionEvent) {
    }

    public void permissionCreationCancelHandle(ActionEvent actionEvent) {
    }

    public void permissionCreationPickCompanyHandle(ActionEvent actionEvent) {
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String userName = KeeperOfKeys.getLoggedUserNameInstance().currentUserName().getUserName();
        System.out.println(userName);
    }
}
