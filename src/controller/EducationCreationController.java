package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class EducationCreationController  extends Controller implements Initializable {
    public void educationCreationSaveHandle(ActionEvent actionEvent) {
    }

    public void educationCreationCancelHandle(ActionEvent actionEvent) {
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String userName = KeeperOfKeys.getInstance().currentUserName().getUserName();
        System.out.println(userName);
    }
}
