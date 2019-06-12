package controller;

import Domain.Apprentices;
import Domain.Educations;
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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EducationOverviewController  extends Controller implements Initializable {
    @FXML
    TableView<Educations> EOTableView = new TableView<>();

    TableColumn<Educations,String> colEducationID = new TableColumn<>();
    @FXML
    TableColumn<Educations,String> colName = new TableColumn<>();
    @FXML
    TableColumn<Educations,String> colProvider = new TableColumn<>();
    @FXML
    TableColumn<Educations,String> colCity = new TableColumn<>();
    @FXML
    TableColumn<Educations,String> colEduStart = new TableColumn<>();
    @FXML
    TableColumn<Educations,String> colEduEnd = new TableColumn<>();
    @FXML
    TableColumn<Educations,String> colAMU = new TableColumn<>();
    @FXML
    TableColumn<Educations,String> colZipCode = new TableColumn<>();
    @FXML
    private TextField EduOSeaText;

    FXMLLoader fxmlLoader;
    String title;
    Integer EducationID;

    public void EOSetButHandle(ActionEvent actionEvent) throws IOException {
        title = "Logged User Detail Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/logged user detail.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void EOAppOverButHandle(ActionEvent actionEvent) throws IOException{
        title = "Apprentice Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/apprentice overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void EOUseOverButHandle(ActionEvent actionEvent) throws IOException{
        title = "User Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/user overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void EOComOButHandle(ActionEvent actionEvent)throws IOException {
        title = "Company Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/company overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void EOExpCsvButHandle(ActionEvent actionEvent) {
    }

    public void EOPrintButHandle(ActionEvent actionEvent) {
    }

    public void EOCreaNewButHandle(ActionEvent actionEvent) throws IOException{
        title = "Education creation";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/education creation.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void EOSelectButHandle(ActionEvent actionEvent) throws IOException{
        Educations educations = EOTableView.getSelectionModel().getSelectedItem();
        KeeperOfKeys.getLoggedUserNameInstance().currentEducationID().setsEducationID(educations.getEduID());
        title = "Education Detail";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/education detail.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String userName = KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();
        System.out.println(userName);
        ObservableList<Educations> educationList = FXCollections.observableArrayList(DBFacade.retrieveEducations());
        EOTableView.setItems(educationList);

        colEducationID.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getEduID().toString()));
        colName.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getName()));
        colProvider.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getProvider()));
        colCity.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getCity()));
        colEduStart.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getEduStart().toString()));
        colEduEnd.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getEduEnd().toString()));
        colAMU.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getAMU().toString()));
        colZipCode.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getZipcode()));
        EOTableView.getColumns().setAll(colName,colProvider,colCity,colEduStart,colEduEnd,colAMU,colZipCode);

       FilteredList<Educations> filteredData = new FilteredList<>(educationList, p -> true); // Set the filter Predicate whenever the filter changes.
        EduOSeaText.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Educations -> { // If filter text is empty, display all.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (Educations.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (Educations.getCity().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(Educations.getAMU()).toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (Educations.getZipcode().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }
                return false; // Does not match.
            });
        });//Wrap the FilteredList in a SortedList.
        SortedList<Educations> sortedData = new SortedList<>(filteredData); //Bind the SortedList comparator to the TableView comparator. Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(EOTableView.comparatorProperty()); //Add sorted (and filtered) data to the table.
        EOTableView.setItems(sortedData);
    }
    public Integer getsEducationID() {
        return EducationID;
    }

    public void setsEducationID(Integer educationID) {
        EducationID = educationID;
    }

}
