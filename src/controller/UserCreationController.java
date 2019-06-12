package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserCreationController  extends Controller implements Initializable {

    String title;
    FXMLLoader fxmlLoader;
    String username;

    public void userCreationSaveHandle(ActionEvent actionEvent) throws IOException {
        title = "User Detail";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/user detail.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void userCreationCancelHandle(ActionEvent actionEvent) throws IOException{
        title = "Employee Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/user overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void userCreationPickApprenticeHandle(ActionEvent actionEvent) {
    }

    public void userCreationPickContactHandle(ActionEvent actionEvent) {
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
         username = KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();
        System.out.println(username);
    }
}
