package controller;

import Domain.*;
import Persistence.DBFacade;
import javafx.beans.property.SimpleIntegerProperty;
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
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Company overview controller class. gives overview over companies.
 */
public class CompanyOverviewController extends Controller implements Initializable {
    @FXML
    public LogInController logInCont;
    @FXML
    TableView<Companies> ComOTableView = new TableView();

    TableColumn<Companies,String> colCompanyID = new TableColumn<>();
    @FXML
    TableColumn<Companies, String> colName = new TableColumn<>();
    @FXML
    TableColumn<Companies, String> colFieldOfExp = new TableColumn<>();
    @FXML
    TableColumn<Companies, String> colZipcode = new TableColumn<>();
    @FXML
    TableColumn<Companies, String> colCVR = new TableColumn<>();
    @FXML
    TableColumn<Companies, String> colPNumber = new TableColumn<>();
    @FXML
    TableColumn<Companies, String> colCity = new TableColumn<>();
    @FXML
    private TextField ComOSeaText;

    FXMLLoader fxmlLoader;
    String title;
    String username;
    Integer companyID;


    /**
     * handler for "settings" button
     * @param actionEvent
     * @throws IOException
     */
    public void ComOSetButHandle(ActionEvent actionEvent) throws IOException{
        title = "Logged User Detail Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/logged user detail.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * this method is handling the "Application overview" button, made to send the user to application overview, as name says.
     * @param actionEvent
     * @throws IOException
     */
    public void ComOAppOverButHandle(ActionEvent actionEvent)throws IOException {
        title = "Apprentice Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/apprentice overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * this method is handling the "user overview" button. leads you to the just mentioned overview.
     * @param actionEvent
     * @throws IOException
     */
    public void ComOUseOverButHandle(ActionEvent actionEvent) throws IOException {
        title = "User Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/user overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * this method is handling the "Education Overview" button, which leads you to said.
     * @param actionEvent
     * @throws IOException
     */
    public void ComOEduOverButHandle(ActionEvent actionEvent) throws IOException{
        title = "Education Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/education overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * this method is handling the "exp csv." button.
     * @param actionEvent
     */
    public void ComOExpCsvButHandle(ActionEvent actionEvent) {
        saveCSV();
    }

    /**
     * this method is handling the "print" button
     * @param actionEvent
     */
    public void ComOPrintButHandle(ActionEvent actionEvent) {
printScreen();
    }

    /**
     * this method is handling the "Create new" button, to create new companies.
     * @param actionEvent
     * @throws IOException
     */
    public void ComOCreaNewButHandle(ActionEvent actionEvent) throws IOException{
        title = "Company creation";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/company creation.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * this method is handling the "Select" button. which leads you to more details screen from selected company in this case.
     * @param actionEvent
     * @throws IOException
     */
    public void ComOSelectButHandle(ActionEvent actionEvent) throws IOException{
        Companies companies = ComOTableView.getSelectionModel().getSelectedItem();
        try {
            KeeperOfKeys.getLoggedUserNameInstance().currentCompanyID().setsCompanyID(companies.getCompanyID());
        }catch(NullPointerException e){
        }
        title = "Company Detail";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/company detail.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();


    }

    /**
     * this method is handling the "Contact overview" button, leads you to mentioned.
     * @param actionEvent
     * @throws IOException
     */
    public void ComOConOButHandle(ActionEvent actionEvent) throws IOException{
        title = "Contact Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/contact overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * Initialize celldata, use filteredlist and sortedlist for searching/filtering
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username = KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();
        ObservableList<Companies> companyList = FXCollections.observableArrayList(DBFacade.retrieveCompanies(DBFacade.checkYourPrivilege(username)));

        ComOTableView.setItems(companyList);
        colCompanyID.setCellValueFactory(cellData -> new SimpleStringProperty((cellData.getValue().getCompanyID().toString())));
        colName.setCellValueFactory(cellData -> new SimpleStringProperty((cellData.getValue().getName())));
        colCity.setCellValueFactory(cellData -> new SimpleStringProperty((cellData.getValue().getCity())));
        colCVR.setCellValueFactory(cellData -> new SimpleStringProperty((cellData.getValue().getCvr())));
        colFieldOfExp.setCellValueFactory(cellData -> new SimpleStringProperty((cellData.getValue().getFieldOfExpertise())));
        colPNumber.setCellValueFactory(cellData -> new SimpleStringProperty((cellData.getValue().getpNum())));
        colZipcode.setCellValueFactory(cellData -> new SimpleStringProperty((cellData.getValue().getZipcode())));

        //ComOTableView.getColumns().setAll(colName,colCity,colCVR,colFieldOfExp,colPNumber,colZipcode);




        FilteredList<Companies> filteredData = new FilteredList<>(companyList, p -> true); // Set the filter Predicate whenever the filter changes.
        ComOSeaText.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Companies -> { // If filter text is empty, display all.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                if(Companies.getFieldOfExpertise() == null) {
                    Companies.setFieldOfExpertise("");
                }
                if(Companies.getpNum() == null) {
                    Companies.setpNum("");
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (Companies.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (Companies.getCity().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (Companies.getCvr().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (Companies.getFieldOfExpertise().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (Companies.getpNum().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (Companies.getZipcode().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }
                return false; // Does not match.
            });
        });//Wrap the FilteredList in a SortedList.
        SortedList<Companies> sortedData = new SortedList<>(filteredData); //Bind the SortedList comparator to the TableView comparator. Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(ComOTableView.comparatorProperty()); //Add sorted (and filtered) data to the table.
        ComOTableView.setItems(sortedData);
    }


    public Integer getsCompanyID() {
        return companyID;
    }

    public void setsCompanyID(Integer companyID) {
        this.companyID = companyID;
    }


    public void ComOSeaButHandle(ActionEvent actionEvent) {
    }
}





