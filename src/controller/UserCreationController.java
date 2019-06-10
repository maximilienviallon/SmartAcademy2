package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class UserCreationController  extends Controller implements Initializable {
    public void userCreationSaveHandle(ActionEvent actionEvent) {
    }

    public void userCreationCancelHandle(ActionEvent actionEvent) {
    }

    public void userCreationPickApprenticeHandle(ActionEvent actionEvent) {
    }

    public void userCreationPickContactHandle(ActionEvent actionEvent) {
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String userName = KeeperOfKeys.getLoggedUserNameInstance().currentUserName().getUserName();
        System.out.println(userName);
    }
}
