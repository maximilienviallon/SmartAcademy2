package controller;

import Domain.Companies;
import Domain.Contacts;
import Persistence.DBFacade;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ContactOverviewController  extends Controller implements Initializable {

    @FXML
    TableView<Contacts> ConOTableView = new TableView();
    TableColumn<Contacts,String> colContactID = new TableColumn();
    @FXML
    TableColumn<Contacts,String> colCompanyID = new TableColumn();
    @FXML
    TableColumn<Contacts,String> colName = new TableColumn();
    @FXML
    TableColumn<Contacts,String> colEmail = new TableColumn<>();
    @FXML
    TableColumn<Contacts,String> colPhoneNumber = new TableColumn();
    @FXML
    private TextField ConOSeaText;

    FXMLLoader fxmlLoader;
    String title;
    String username;
    Contacts contacts;

    Integer contactID;
    private Integer CompanyID;

    public void ConOSetButHandle(ActionEvent actionEvent) throws IOException {
        title = "Logged User Detail Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/logged user detail.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void ConOAppOverButHandle(ActionEvent actionEvent) throws IOException{
        title = "Apprentice Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/apprentice overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void ConOUseOverButHandle(ActionEvent actionEvent) throws IOException{
        title = "User Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/user overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void ConOComOverButHandle(ActionEvent actionEvent) throws IOException{
        title = "Company Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/company overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void ConOEduOverButHandle(ActionEvent actionEvent) throws IOException{
        title = "Education Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/education overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void ConOExpCsvButHandle(ActionEvent actionEvent) {
    }

    public void ConOPrintButHandle(ActionEvent actionEvent) {
    }

    public void ConOCreaNewButHandle(ActionEvent actionEvent) throws IOException{
        title = "Contact Creation";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/contact creation.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void ConOSelectButHandle(ActionEvent actionEvent) throws IOException{
        contacts= ConOTableView.getSelectionModel().getSelectedItem();
        KeeperOfKeys.getLoggedUserNameInstance().currentContactID().setsContactID(contacts.getContactID());
        title = "Contact Detail";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/contact detail.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username = KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();
        CompanyID = KeeperOfKeys.getLoggedUserNameInstance().currentCompanyID().getsCompanyID();
        System.out.println(username);
        ObservableList<Contacts> contactList = FXCollections.observableArrayList(DBFacade.retrieveContacts());

        ConOTableView.setItems(contactList);

        colContactID.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getContactID().toString()));
        colCompanyID.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getCompanyID().toString()));
        colName.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getName()));
        colEmail.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getEmail()));
        colPhoneNumber.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getPhoneNo()));
        ConOTableView.getColumns().setAll(colCompanyID,colName,colEmail,colPhoneNumber);

        FilteredList<Contacts> filteredData = new FilteredList<>(contactList, p -> true); // Set the filter Predicate whenever the filter changes.
        ConOSeaText.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Contacts -> { // If filter text is empty, display all.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                if(Contacts.getEmail() == null) {
                    Contacts.setEmail("");
                }
                if(Contacts.getPhoneNo() == null) {
                    Contacts.setPhoneNo("");
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (Contacts.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (Contacts.getEmail().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (Contacts.getPhoneNo().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }
                return false; // Does not match.
            });
        });//Wrap the FilteredList in a SortedList.
        SortedList<Contacts> sortedData = new SortedList<>(filteredData); //Bind the SortedList comparator to the TableView comparator. Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(ConOTableView.comparatorProperty()); //Add sorted (and filtered) data to the table.
        ConOTableView.setItems(sortedData);
    }


    public Integer getsContactID() {
        return contactID;
    }

    public void setsContactID(Integer contactID) {
        this.contactID = contactID;
    }
}
