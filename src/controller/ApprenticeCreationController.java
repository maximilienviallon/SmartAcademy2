package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class ApprenticeCreationController  extends Controller implements Initializable {
    String username;
    public void apprenticeCreationSaveHandle(ActionEvent actionEvent) {
    }

    public void apprenticeCreationCancelHandle(ActionEvent actionEvent) {
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username = KeeperOfKeys.getUserNameInstance().currentUserName().getUserName();
    }
}
