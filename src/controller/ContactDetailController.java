package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ContactDetailController  extends Controller implements Initializable {
    @FXML
    TextArea ContactPersInfoArea;
    FXMLLoader fxmlLoader;
    String title;
    String username;

    public void backToContactOverviewHandle(ActionEvent actionEvent) throws IOException {
        title = "Contact Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/contact overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void ContactExportHandle(ActionEvent actionEvent) {
    }

    public void ContactPrintHandle(ActionEvent actionEvent) {
    }

    public void ContactEditHandle(ActionEvent actionEvent) throws IOException{
        title = "Contact Modification";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/contact modification.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void ContactRemoveHandle(ActionEvent actionEvent) throws IOException{
        title = "Contact Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/contact overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String userName = KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();
        System.out.println(userName);
    }
}
