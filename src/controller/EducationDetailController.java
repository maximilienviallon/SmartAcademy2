package controller;

import Domain.Educations;
import Persistence.DB;
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
 * this class allows you to see the details of an education based on the education ID
 */
public class EducationDetailController  extends Controller implements Initializable {
    @FXML
    TextArea educationInfoArea;
    FXMLLoader fxmlLoader;
    String title;
    String username;
    Integer educationID;

    /**
     * this method sends you back to the education overview as you press a button
     * @param actionEvent
     * @throws IOException
     */
    public void backToEducationOverviewHandle(ActionEvent actionEvent)throws IOException {
        title = "Education Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/education Overview.fxml"));
        fxmlLoading(fxmlLoader, title);
        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * this method will export the education detail to .csv file
     * @param actionEvent
     */
    public void EducationExportHandle(ActionEvent actionEvent) {
        saveCSV();
    }

    /**
     * this method will print out the education detail screen
     * @param actionEvent
     */
    public void EducationPrintHandle(ActionEvent actionEvent) {
        printScreen();
    }

    /**
     * this method will take you to education modification for the selected education
     * @param actionEvent
     * @throws IOException
     */
    public void EducationEditHandle(ActionEvent actionEvent) throws IOException{
        title = "Education Modification";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/education modification.fxml"));
        fxmlLoading(fxmlLoader, title);
        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * this will take you back to the education overview and remove the selected education
     * @param actionEvent
     * @throws IOException
     */
    public void EducationRemoveHandle(ActionEvent actionEvent) throws IOException{
        title = "education Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/education Overview.fxml"));
        fxmlLoading(fxmlLoader, title);
        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * this method will initialize the text area of the education detail.fxml based on the education ID
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username = KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();
        educationID = KeeperOfKeys.getLoggedUserNameInstance().currentEducationID().getsEducationID();
        Educations view = DBFacade.retrieveEducationDetail(educationID).get(0);
        educationInfoArea.setText(view.getName() + "\n" + view.getProvider() + "\n" + view.getCity() + "\n" + view.getEduStart() + "\n" + view.getEduEnd() + "\n" + view.getZipcode() + "\n" + view.getAMU() + "\n" + view.getDescription() + "\n");
    }
}
