package controller;

import Domain.Users;
import Persistence.DBFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoggedUserDetailController  extends Controller implements Initializable {
    String loggedUserID;
    FXMLLoader fxmlLoader;
    String title;
    String username;
    public void backToApprenticeOverviewHandle(ActionEvent actionEvent)throws IOException {
        title = "Apprentice Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/apprentice overview.fxml"));
        fxmlLoading(fxmlLoader, title);
        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void loggedUserDetailPrintHandle(ActionEvent actionEvent) {
        printScreen();
    }

    public void LoggedUserDetailEditHandle(ActionEvent actionEvent) throws IOException{
        title = "logged User Modification";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/logged user modification.fxml"));
        fxmlLoading(fxmlLoader, title);
        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username= KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();
        System.out.println(username);
        loggedUserID = KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();
        Users view = DBFacade.retrieveUsers().get(0);
    }
}
