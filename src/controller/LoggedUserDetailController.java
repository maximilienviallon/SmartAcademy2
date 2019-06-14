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

    /**
     * Method that transports user to the Apprentice Overview
     * @param actionEvent
     * @throws IOException
     */
    public void backToApprenticeOverviewHandle(ActionEvent actionEvent)throws IOException {
        title = "Employee Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/apprentice overview.fxml"));
        fxmlLoading(fxmlLoader, title);
        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     *Method that was supposed to print the graphic content of the window to the newly created .png file
     * @param actionEvent
     */
    public void loggedUserDetailPrintHandle(ActionEvent actionEvent) {
        printScreen();
    }

    /**
     * Method that transports user to the Logged user modification
     * @param actionEvent
     * @throws IOException
     */
    public void LoggedUserDetailEditHandle(ActionEvent actionEvent) throws IOException{
        title = "Logged User Modification";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/logged user modification.fxml"));
        fxmlLoading(fxmlLoader, title);
        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username= KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();
        loggedUserID = KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();
        Users view = DBFacade.retrieveUsers().get(0);
    }
}
