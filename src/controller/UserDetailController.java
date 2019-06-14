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

public class UserDetailController  extends Controller implements Initializable {


    String title;
    FXMLLoader fxmlLoader;
    String username;
    String loggedUsername;

    /**
     * Method that transports user to the user overview
     * @param actionEvent
     * @throws IOException
     */
    public void backToUserOverviewHandle(ActionEvent actionEvent) throws IOException {
        title = "User Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/user Overview.fxml"));
        fxmlLoading(fxmlLoader, title);
        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * Method was supposed to transport data formatted in the text area into the new .csv file
     * @param actionEvent
     */
    public void UserExportHandle(ActionEvent actionEvent) {
        saveCSV();
    }

    /**
     * Method that was supposed to print the graphic content of the window to the newly created .png file
     * @param actionEvent
     */
    public void UserPrintHandle(ActionEvent actionEvent) {
        printScreen();
    }

    /**
     * Method that transports user to the User Modification
     * @param actionEvent
     * @throws IOException
     */
    public void UserEditHandle(ActionEvent actionEvent) throws IOException {
        title = "User Modification";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/user modification.fxml"));
        fxmlLoading(fxmlLoader, title);
        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * Method that transports user to the User Overview and was supposed to remove given user from the DB
     * @param actionEvent
     * @throws IOException
     */
    public void UserRemoveHandle(ActionEvent actionEvent) throws IOException {
        title = "User Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/user Overview.fxml"));
        fxmlLoading(fxmlLoader, title);
        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * Initialize loads the shared parameters that are relevant to the current screen and was supposed to populates the text area with data from DB
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loggedUsername = KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();
        username = KeeperOfKeys.getLoggedUserNameInstance().currentUserName().getsUserName();
        Users view = DBFacade.retrieveUsers().get(0);
    }
}
