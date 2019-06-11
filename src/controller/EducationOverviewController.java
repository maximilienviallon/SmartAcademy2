package controller;

import Domain.Apprentices;
import Domain.Educations;
import Persistence.DBFacade;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
    TableColumn<Educations,String> colCity = new TableColumn<>();
    @FXML
    TableColumn<Educations,String> colEduStart = new TableColumn<>();
    @FXML
    TableColumn<Educations,String> colEduEnd = new TableColumn<>();
    @FXML
    TableColumn<Educations,String> colAMU = new TableColumn<>();
    @FXML
    TableColumn<Educations,String> colZipCode = new TableColumn<>();

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
    }

    public void EOSelectButHandle(ActionEvent actionEvent) throws IOException{
        Educations educations = EOTableView.getSelectionModel().getSelectedItem();
        KeeperOfKeys.getLoggedUserNameInstance().currentEducationID().setsEducationID(educations.getEduID());
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String userName = KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();
        System.out.println(userName);
        ObservableList<Educations> educationList = FXCollections.observableArrayList(DBFacade.retrieveEducations());
        EOTableView.setItems(educationList);

        colEducationID.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getEduID().toString()));
        colName.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getName()));
        colCity.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getCity()));
        colEduStart.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getEduStart().toString()));
        colEduEnd.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getEduEnd().toString()));
        colAMU.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getAMU().toString()));
        colZipCode.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getZipcode()));
        EOTableView.getColumns().setAll(colName,colCity,colEduStart,colEduEnd,colAMU,colZipCode);
    }
    public Integer getsEducationID() {
        return EducationID;
    }

    public void setsEducationID(Integer educationID) {
        EducationID = educationID;
    }

}
