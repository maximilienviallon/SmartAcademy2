package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 */
public class UserModificationController  extends Controller implements Initializable {
    String title;
    FXMLLoader fxmlLoader;
    String username;


    /**
     * Method that shoul dhave saved the input data and transported user to the detail of newly created user
     * @param actionEvent
     * @throws IOException
     */
    public void UMSavButHandle(ActionEvent actionEvent) throws IOException {
        title = "Employee Detail";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/apprentice detail.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * Method that should have unlinked the apprentice or contact from the user
     * @param actionEvent
     */
    public void UMRemButHandle(ActionEvent actionEvent) {

    }

    /**
     * Method that should have linked an apprentice or contact to the user
     * @param actionEvent
     */
    public void UMAddButHandle(ActionEvent actionEvent) {
    }

    /**
     * Method that transports user to the apprentice overview
     * @param actionEvent
     * @throws IOException
     */
    public void UMBacToOveButHandle(ActionEvent actionEvent) throws IOException{
        title = "Employee Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/apprentice Overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * Method that transports user to the detail of previously selected user
     * @param actionEvent
     * @throws IOException
     */
    public void UMBacToDetButHandle(ActionEvent actionEvent) throws IOException{
        title = "Employee Detail";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/apprentice detail.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * Method that transports user to the overview whilst deleting the currently modified user
     * @param actionEvent
     * @throws IOException
     */
    public void UMDelButHandle(ActionEvent actionEvent)  throws IOException{
        title = "Employee Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/apprentice Overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
         username = KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();
    }
}
