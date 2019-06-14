package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * this controller is used to create apprentices it extends the controller class for the fxmlLoader method
 */
public class ApprenticeCreationController  extends Controller implements Initializable {
    FXMLLoader fxmlLoader;
    String title;
    String username;
    Integer apprenticeID;

    /**
     * this button creates a brand new apprentice based on user inputs
     * @param actionEvent
     * @throws IOException
     */
    public void apprenticeCreationSaveHandle(ActionEvent actionEvent) throws IOException {
        title = "Apprentice Detail";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/apprentice detail.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
    /**
     * this button deletes apprentices
     * @param actionEvent
     * @throws IOException
     */
    public void apprenticeCreationCancelHandle(ActionEvent actionEvent) throws IOException {
        title = "Apprentice Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/apprentice overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * this class initialiizes the FXML and get's a username which is useful for a lot of the
     * db related functions as an identification
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username = KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();
        System.out.println(username);
    }
}
