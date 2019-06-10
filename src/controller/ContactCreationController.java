package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class ContactCreationController  extends Controller implements Initializable {
    public void contactCreationSaveHandle(ActionEvent actionEvent) {
    }

    public void contactCreationCancelHandle(ActionEvent actionEvent) {
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String userName = KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();
        System.out.println(userName);
    }
}
