package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * contact modification controller class, screen for modifying contact files
 */
public class ContactModificationController  extends Controller implements Initializable {

    String title;
    FXMLLoader fxmlLoader;
    String username;

    /**
     * this method is handling the "save" button.
     * @param actionEvent
     * @throws IOException
     */
    public void CMSaveButHandle(ActionEvent actionEvent) throws IOException {
        title = "Company Detail";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/copmany detail.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * this method is handling the "back to overview" button. leads back to overview.
     * @param actionEvent
     * @throws IOException
     */
    public void CMBackToOButHandle(ActionEvent actionEvent) throws IOException{
        title = "Company Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/company Overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * this method is handling the "back to detail" button, leads back to detail.
     * @param actionEvent
     * @throws IOException
     */
    public void CMBackToDetButHandle(ActionEvent actionEvent) throws IOException{
        title = "Company Detail";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/company detail.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * this method is handling the "remove" button.
     * @param actionEvent
     * @throws IOException
     */
    public void CMRemoveButHandle(ActionEvent actionEvent) throws IOException{
        title = "Company Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/company Overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * initializes
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username = KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();
    }
}
