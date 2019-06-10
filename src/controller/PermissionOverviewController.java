package controller;

import Domain.Educations;
import Persistence.DBFacade;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PermissionOverviewController  extends Controller implements Initializable {

    FXMLLoader fxmlLoader;
    String title;

    public void POSetButHandle(ActionEvent actionEvent) throws IOException {
        title = "Logged User Detail Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/logged user detail.fxml"));
        fxmlLoading(fxmlLoader,title);
    }

    public void POEduOverButHandle(ActionEvent actionEvent) throws IOException{
        title = "Apprentice Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/education overview.fxml"));
        fxmlLoading(fxmlLoader,title);
    }

    public void POAppOverButHandle(ActionEvent actionEvent) throws IOException{
        title = "Apprentice Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/apprentice overview.fxml"));
        fxmlLoading(fxmlLoader,title);
    }

    public void POUseOverButHandle(ActionEvent actionEvent)throws IOException{
        title = "User Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/user overview.fxml"));
        fxmlLoading(fxmlLoader,title);
    }

    public void POComOverButHandle(ActionEvent actionEvent) throws IOException{
        title = "Company Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/company overview.fxml"));
        fxmlLoading(fxmlLoader,title);
    }

    public void POExpCsvButHandle(ActionEvent actionEvent) {
    }

    public void POPrintButHandle(ActionEvent actionEvent) {
    }

    public void POCreaNewButHandle(ActionEvent actionEvent) throws IOException{
    }

    public void POSelectButHandle(ActionEvent actionEvent) throws IOException{
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String userName = KeeperOfKeys.getLoggedUserNameInstance().currentUserName().getUserName();
        System.out.println(userName);

        /*ObservableList<Educations> educationList = FXCollections.observableArrayList(DBFacade.retrieveEducations());
        EOTableView.setItems(educationList);

        colEducationID.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getEduID().toString()));
        colName.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getName()));
        colCity.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getCity()));
        colEduStart.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getEduStart().toString()));
        colEduEnd.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getEduEnd().toString()));
        colAMU.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getAMU().toString()));
        colZipCode.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getZipcode()));
        EOTableView.getColumns().setAll(colName,colCity,colEduStart,colEduEnd,colAMU,colZipCode);
    */}
}
