package controller;

import Domain.Apprentices;
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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * this gives an overview of all the apprentices depending on the company ID that you get
 */
public class ApprenticeOverviewController  extends Controller implements Initializable {
    @FXML
    TableView<Apprentices> AOTableView = new TableView();
    @FXML
    TableColumn<Apprentices,String> colCPR = new TableColumn();
    @FXML
    TableColumn<Apprentices,String> colName = new TableColumn();
    @FXML
    TableColumn<Apprentices,String> colEmail = new TableColumn();
    @FXML
    TableColumn<Apprentices,String> colPhone = new TableColumn();
    @FXML
    TableColumn <Apprentices,String> colCompID = new TableColumn();
    @FXML
    private TextField AOSeaText;

    FXMLLoader fxmlLoader;
    String title;
    Integer CompanyID;
    Integer ApprenticeID;
    String username;

    /**
     * this method loads the logged user detail
     * @param actionEvent
     * @throws IOException
     */
    public void AOSetButHandle(ActionEvent actionEvent) throws IOException {
        title = "Logged User Detail Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/logged user detail.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * this method sends you to education overview
     * @param actionEvent
     * @throws IOException
     */
    public void AOEduOverButHandle(ActionEvent actionEvent) throws IOException{
        title = "Education Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/education overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * this method sends you to user overview
     * @param actionEvent
     * @throws IOException
     */
    public void AOUseOverButHandle(ActionEvent actionEvent) throws IOException{
        title = "User Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/user overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * this method sends you to company overview
     * @param actionEvent
     * @throws IOException
     */
    public void AOComOverButHandle(ActionEvent actionEvent) throws IOException{
        title = "Company Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/company overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * this method allows you to export in csv and inherits the super Controller method to export
     * @param actionEvent
     */
    public void AOExpCsvButHandle(ActionEvent actionEvent) {
        saveCSV();
    }
    /**
     * this method allows you to print and inherits the super Controller method to print
     * @param actionEvent
     */
    public void AOPrintButHandle(ActionEvent actionEvent) {
        printScreen();
    }

    /**
     * this method will send you to apprentice creation granted that you have the right permissions
     * @param actionEvent
     * @throws IOException
     */
    public void AOCreaNewButHandle(ActionEvent actionEvent) throws IOException{
        title = "Apprentice Creation";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/apprentice creation.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * this method sends you to apprenitce detail
     * @param actionEvent
     * @throws IOException
     */
    public void AOSelectButHandle(ActionEvent actionEvent) throws IOException{
        Apprentices apprentices = AOTableView.getSelectionModel().getSelectedItem();
        KeeperOfKeys.getLoggedUserNameInstance().currentApprenticeID().setsApprenticeID(apprentices.getApprenticeID());
        title = "Apprentice Detail";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/apprentice detail.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void AODisMatButHandle(ActionEvent actionEvent) throws IOException{
    }
    public Integer getsApprenticeID() {
        return ApprenticeID;
    }

    public void setsApprenticeID(Integer apprenticeID) {
        ApprenticeID = apprenticeID;
    }
    /**
     * this method initialiizes the FXML and get's a username which is useful for a lot of the
     * db related functions as an identification
     *
     * it also initializes the table view as well as an implementation for the search function of the table view
     * utilising fileteredList as well as lambda expressions
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username = KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();
        CompanyID = KeeperOfKeys.getLoggedUserNameInstance().currentCompanyID().getsCompanyID();
        ObservableList<Apprentices> apprenticeList = FXCollections.observableArrayList(DBFacade.retrieveApprentices());

        AOTableView.setItems(apprenticeList);

        colCPR.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getCPR()));
        colName.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getName()));
        colEmail.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getEmail()));
        colPhone.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getPhone()));
        colCompID.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getCompanyID().toString()));

        AOTableView.getColumns().setAll(colCPR,colName,colEmail,colPhone,colCompID);

        FilteredList<Apprentices> filteredData = new FilteredList<>(apprenticeList, p -> true); // Set the filter Predicate whenever the filter changes.
        AOSeaText.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Apprentices -> { // If filter text is empty, display all.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                if(Apprentices.getCPR() == null) {
                    Apprentices.setCPR("");
                }
                if(Apprentices.getEmail() == null) {
                    Apprentices.setEmail("");
                }
                if(Apprentices.getPhone() == null) {
                    Apprentices.setPhone(" ");
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (Apprentices.getCPR().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (Apprentices.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (Apprentices.getEmail().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (Apprentices.getPhone().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }
                return false; // Does not match.
            });
        });//Wrap the FilteredList in a SortedList.
        SortedList<Apprentices> sortedData = new SortedList<>(filteredData); //Bind the SortedList comparator to the TableView comparator. Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(AOTableView.comparatorProperty()); //Add sorted (and filtered) data to the table.
        AOTableView.setItems(sortedData);
    }
}
