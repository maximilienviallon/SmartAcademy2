package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * this class allows you to modify a single education based on the education ID
 */
public class EducationModificationController  extends Controller implements Initializable {
    String title;
    FXMLLoader fxmlLoader;
    String username;

    /**
     * this method will allow you to save a new education based on the information placed in the TextFields/TextAreas
     * and take you back to education detail
     */
    public void EMSaveButHandle(ActionEvent actionEvent)  throws IOException{
        title = "Education Detail";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/education detail.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * this method will remove the selected education and take you back to the education overview
     * @param actionEvent
     * @throws IOException
     */
    public void CMRemoveButHandle(ActionEvent actionEvent)  throws IOException{
        title = "Education Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/education Overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * this method will take you back to education overivew
     * @param actionEvent
     * @throws IOException
     */
    public void EMBacToOveButHandle(ActionEvent actionEvent)  throws IOException{
        title = "Education Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/education Overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * this method will simply take you back to education detail without affecting the DataBase
     * @param actionEvent
     * @throws IOException
     */
    public void CMBackToDetButHandle(ActionEvent actionEvent)  throws IOException {
        title = "Education Detail";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/education detail.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username = KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();
    }

}
