package controller;

import Domain.Contacts;
import Persistence.DBFacade;
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
    Integer contactID;

    public void backToContactOverviewHandle(ActionEvent actionEvent) throws IOException {
        title = "Contact Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/contact overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void ContactExportHandle(ActionEvent actionEvent) {
        saveCSV();
    }

    public void ContactPrintHandle(ActionEvent actionEvent) {
        printScreen();
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
        username = KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();
        contactID = KeeperOfKeys.getLoggedUserNameInstance().currentContactID().getsContactID();
        Contacts view = DBFacade.retrieveContactDetail(contactID).get(0);
        ContactPersInfoArea.setText(view.getName() + "\n" + view.getEmail() + "\n" + view.getPhoneNo() + "\n" + view.getLandline() + "\n" + view.getCompanyID() + "\n");
    }
}
