package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * This class allows you to modify a selected apprentice (The selection is based on the apprentice ID within our Database)
 */
public class ApprenticeModificationController  extends Controller implements Initializable {
    FXMLLoader fxmlLoader;
    String title;
    String username;

    /**
     * this method inserts new values for the selected apprentice into the database based on the user input
     * @param actionEvent
     * @throws IOException
     */
    public void AMSaveButHandle(ActionEvent actionEvent) throws IOException {
        title = "Apprentice Detail";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/apprentice detail.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
    /**
     * this method takes you back to Apprentice overview Handle
     * @param actionEvent
     * @throws IOException
     */
    public void AMBacToOveButHandle(ActionEvent actionEvent) throws IOException {
        title = "Apprentice Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/apprentice Overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
    /**
     * this method allows you to go back to Apprentice detail
     * @param actionEvent
     * @throws IOException
     */
    public void AMBacToDetButHandle(ActionEvent actionEvent) throws IOException {
        title = "Apprentice Detail";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/apprentice detail.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
    /**
     * this method allows remove the selected apprentice
     * @param actionEvent
     * @throws IOException
     */
    public void AMRemButHandle(ActionEvent actionEvent) throws IOException {
        title = "Apprentice Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/apprentice Overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * this method initialiizes the FXML and get's a username which is useful for a lot of the
     * db related functions as an identification
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username = KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();
    }
}
