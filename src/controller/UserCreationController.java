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

    /**
     * Method that transports user to the detail of the newly created user
     * @param actionEvent
     * @throws IOException
     */
    public void userCreationSaveHandle(ActionEvent actionEvent) throws IOException {
        title = "User Detail";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/user detail.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * Method that transports user to the overview, not saving any changes
     * @param actionEvent
     * @throws IOException
     */
    public void userCreationCancelHandle(ActionEvent actionEvent) throws IOException{
        title = "User Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/user overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * method for allowing user to pick which apprentice is any is the user supposed to be linked to
     * @param actionEvent
     */
    public void userCreationPickApprenticeHandle(ActionEvent actionEvent) {
    }

    /**
     * method for allowing user to pick which contact is any is the user supposed to be linked to
     * @param actionEvent
     */
    public void userCreationPickContactHandle(ActionEvent actionEvent) {
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
         username = KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();
    }
}
