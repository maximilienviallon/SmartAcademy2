package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class CompanyModificationController  extends Controller implements Initializable {
    public void ComMSaveButHandle(ActionEvent actionEvent) {
    }

    public void ComMBackToOButHandle(ActionEvent actionEvent) {
    }

    public void ComMBackToDetButHandle(ActionEvent actionEvent) {
    }

    public void ComMRemoveButHandle(ActionEvent actionEvent) {
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String userName = KeeperOfKeys.getLoggedUserNameInstance().currentUserName().getUserName();
        System.out.println(userName);
    }
}
