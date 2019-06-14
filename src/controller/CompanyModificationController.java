package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * this is company modification controller class, made for modifying data in company
 */
public class CompanyModificationController  extends Controller implements Initializable {
   String title;
   FXMLLoader fxmlLoader;
   String username;

    /**
     * this method is handling the "save" button, made for saving and leading the user back to company detail.
     * @param actionEvent
     * @throws IOException
     */
    public void ComMSaveButHandle(ActionEvent actionEvent) throws IOException{
        title = "Company Detail";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/company detail.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * this method is handling the "Back to overview" button, leading the user back to Company overview.
     * @param actionEvent
     * @throws IOException
     */
    public void ComMBackToOButHandle(ActionEvent actionEvent) throws IOException {
        title = "Company Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/company Overview.fxml"));
        fxmlLoading(fxmlLoader, title);
        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * this method is handling the "Back to detail" button, which does what it says.
     * @param actionEvent
     * @throws IOException
     */
    public void ComMBackToDetButHandle(ActionEvent actionEvent) throws IOException{
        title = "Company Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/company Overview.fxml"));
        fxmlLoading(fxmlLoader, title);
        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * this method is handling the "remove" button, which is made for deletion.
     * @param actionEvent
     * @throws IOException
     */
    public void ComMRemoveButHandle(ActionEvent actionEvent) throws IOException{
        title = "Company Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/company Overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * This method initializes.
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username = KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();
    }
}
