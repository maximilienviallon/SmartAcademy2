package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * this class is to create an education and add it to the DB
 */
public class EducationCreationController  extends Controller implements Initializable {
    String title;
    FXMLLoader fxmlLoader;
    String username;

    /**
     * this methods is to insert values into the education table of the DB
     * it will also take you back to education detail screen
     * @param actionEvent
     * @throws IOException
     */
    public void educationCreationSaveHandle(ActionEvent actionEvent) throws IOException {
        title = "Education Detail";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/education detail.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * this will cancel the creation of and education and send you back to the education overview
     * @param actionEvent
     * @throws IOException
     */
    public void educationCreationCancelHandle(ActionEvent actionEvent) throws IOException{
        title = "Education Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/education overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username = KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();

    }
}
