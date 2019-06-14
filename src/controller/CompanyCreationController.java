package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * this controller allows you to create new companies
 */
public class CompanyCreationController  extends Controller implements Initializable {
    String title;
    FXMLLoader fxmlLoader;
    String username;

    /**
     * This method handles the button for saving.
     * @param actionEvent '
     * @throws IOException
     */
    public void companyCreationSaveHandle(ActionEvent actionEvent)throws IOException {
        title = "Company Detail";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/company detail.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * This method handles the button for cancelling.
     * @param actionEvent
     * @throws IOException
     */
    public void companyCreationCancelHandle(ActionEvent actionEvent) throws IOException{
        title = "Company Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/Company overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * This method is for initializing.
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username = KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();
        System.out.println(username);
    }
}
