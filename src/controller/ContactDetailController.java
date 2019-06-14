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

/**
 * contact detail controller class, used for details of contacts.
 */
public class ContactDetailController  extends Controller implements Initializable {
    @FXML
    TextArea ContactPersInfoArea;
    FXMLLoader fxmlLoader;
    String title;
    String username;
    Integer contactID;

    /**
     * back to contact overview handler, self-explanatory
     * @param actionEvent
     * @throws IOException
     */
    public void backToContactOverviewHandle(ActionEvent actionEvent) throws IOException {
        title = "Contact Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/contact overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * this method is handling the "export contact" button,
     * @param actionEvent
     */
    public void ContactExportHandle(ActionEvent actionEvent) {
        saveCSV();
    }

    /**
     * this method is handling the "print" button
     * @param actionEvent
     */
    public void ContactPrintHandle(ActionEvent actionEvent) {
        printScreen();
    }

    /**
     * this method is handling the "edit" button.
     * @param actionEvent
     * @throws IOException
     */
    public void ContactEditHandle(ActionEvent actionEvent) throws IOException{
        title = "Contact Modification";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/contact modification.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * this method is handling the "remove" button
     * @param actionEvent
     * @throws IOException
     */
    public void ContactRemoveHandle(ActionEvent actionEvent) throws IOException{
        title = "Contact Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/contact overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * initializes.
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username = KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();
        contactID = KeeperOfKeys.getLoggedUserNameInstance().currentContactID().getsContactID();
        Contacts view = DBFacade.retrieveContactDetail(contactID).get(0);
        ContactPersInfoArea.setText(view.getName() + "\n" + view.getEmail() + "\n" + view.getPhoneNo() + "\n" + view.getLandline() + "\n" + view.getCompanyID() + "\n");
    }
}
