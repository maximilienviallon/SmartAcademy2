package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class PermissionDetailController  extends Controller implements Initializable {
    public void backToPermisionOverviewHandle(ActionEvent actionEvent) {
    }

    public void PermisionExportHandle(ActionEvent actionEvent) {
    }

    public void PermisionPrintHandle(ActionEvent actionEvent) {
    }

    public void PermisionEditHandle(ActionEvent actionEvent) {
    }

    public void PermisionRemoveHandle(ActionEvent actionEvent) {
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String userName = KeeperOfKeys.getInstance().currentUserName().getUserName();
        System.out.println(userName);
    }
}
