package controller;

import Domain.Matrix;
import Persistence.DBFacade;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MatrixController  extends Controller implements Initializable {
    FXMLLoader fxmlLoader;
    String title;
    Integer CompanyID;
    String username;
    @FXML
    TableView<Matrix> matrixTableView = new TableView();
    TableColumn<Matrix,String> colAMU = new TableColumn<>();
    TableColumn<Matrix,String> colEduTitle = new TableColumn<>();
    TableColumn<Matrix,String> colProvider = new TableColumn<>();

   //SimpleStringProperty getProperties;
    public void matrixBackToOverviewHandle(ActionEvent actionEvent) throws IOException {
        title = "Company Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/company overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void matrixExportHandle(ActionEvent actionEvent) {
    }

    public void matrixPrintHandle(ActionEvent actionEvent) {
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username = KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();
        CompanyID = KeeperOfKeys.getLoggedUserNameInstance().currentCompanyID().getsCompanyID();
        ObservableList<Matrix> matrixList = FXCollections.observableList(DBFacade.retrieveMatrix(CompanyID));
        ArrayList<Matrix> matrix = new ArrayList<>();
        initializeMatrix(matrixList,matrix);
    }
    public TableView<Matrix> initializeMatrix(ObservableList<Matrix> matrixList,ArrayList<Matrix> matrix){

        ArrayList<TableColumn<Matrix,String>> nameColumn = new ArrayList<>();
        matrixTableView.setItems(matrixList);
        nameColumn.add(colAMU);
        colAMU.setText("AMU");

        nameColumn.add(colEduTitle);
        colEduTitle.setText("Education Title");

        nameColumn.add(colProvider);
        colProvider.setText("Provider");

        int i = 2;
        int j = 0;
        final ArrayList<String> getProperties = Matrix.getPriorities();

        for (Matrix object : matrixList) {
            i++;
            nameColumn.add(new TableColumn<>());
            nameColumn.get(i).setText(object.getNames().get(j));
            colAMU.setCellValueFactory(param -> new SimpleStringProperty((param.getValue().getAMU().toString())));
            colEduTitle.setCellValueFactory(param -> new SimpleStringProperty((param.getValue().getName())));
            colProvider.setCellValueFactory(param -> new SimpleStringProperty((param.getValue().getProvider())));
            System.out.println(object.getNames().get(j));
            if(j>= object.getNames().size()-1)
            {
                break;
            }

            j++;

        }



        int l = 3;
        int k =0;
        for (Matrix object : matrixList)
        {
            if(l>=nameColumn.size()){
            break;
        }
            //for ( k = 0; k<=Matrix.getPriorities().size()-1; k++) {
               // final int  kk = k;
                nameColumn.get(l).setCellValueFactory(param -> new SimpleStringProperty(object.getPriorities().get(k)));
                System.out.println(object.getPriorities().get(k));

            //}

            l++;
        }


        matrixTableView.getColumns().addAll(nameColumn);
        return matrixTableView;
    }


   /* public String getGetProperties() {
        return getProperties.get();
    }

    public SimpleStringProperty getPropertiesProperty() {
        return getProperties;
    }

    public void setGetProperties(String getProperties) {
        this.getProperties.set(getProperties);
    }*/




}
