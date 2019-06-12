package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoggedUserModificationController  extends Controller implements Initializable {

    String title;
    FXMLLoader fxmlLoader;
    String username;

    public void loggedUserModBackToOverviewHandle(ActionEvent actionEvent) throws IOException{
        title = "Logged User Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/logged browser.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();

    }

    public void LoggedUserModSaveHandle(ActionEvent actionEvent) throws IOException{
        title = "Logged User Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/logged browser.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void loggedUserModCancelHandle(ActionEvent actionEvent) throws IOException {
        title = "Logged User Detail";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/logged user detail.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username = KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();
        System.out.println(username);
    }
}
