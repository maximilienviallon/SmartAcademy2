package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class CompanyCreationController  extends Controller implements Initializable {
    public void companyCreationSaveHandle(ActionEvent actionEvent) {
    }

    public void companyCreationCancelHandle(ActionEvent actionEvent) {
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String userName = KeeperOfKeys.getUserNameInstance().currentUserName().getUserName();
        System.out.println(userName);
    }
}
