package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * this class allows you to create contacts for the company you come from
 */
public class ContactCreationController  extends Controller implements Initializable {

    String title;
    FXMLLoader fxmlLoader;
    String username;


    public void contactCreationSaveHandle(ActionEvent actionEvent) throws IOException {
        title = "Contact Detail";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/contact detail.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void contactCreationCancelHandle(ActionEvent actionEvent)throws IOException {
        title = "Contact Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/contact Overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String username = KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();
        System.out.println(username);
    }
}
