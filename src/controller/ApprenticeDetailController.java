package controller;

import Domain.Apprentices;
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
 * this controller extends the Controller class it shows the details of a selected apprentice
 */
public class ApprenticeDetailController extends Controller implements Initializable {
    FXMLLoader fxmlLoader;
    String title;
    String username;
    @FXML
    TextArea apprenticePersInfoArea;
    @FXML
    TextArea ApprenticePendingInfo;
    Integer apprenticeID;
    Apprentices view;

    /**
     * this button simply takes you back to the apprentice overview handle
     * @param actionEvent
     * @throws IOException
     */
    public void backToApprenticeOverviewHandle(ActionEvent actionEvent) throws IOException {
        title = "Apprentice Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/apprentice Overview.fxml"));
        fxmlLoading(fxmlLoader, title);
        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * this button allows you to export the apprentice details into a .csv file
     * @param actionEvent
     */
    public void ApprenticeExportHandle(ActionEvent actionEvent) {
        saveCSV();
    }

    /**
     * this button allows you to print the apprentice detail screen
     * @param actionEvent
     */
    public void ApprenticePrintHandle(ActionEvent actionEvent) {
        printScreen();
    }

    /**
     * this button takes you to the apprentice modification screen
     * @param actionEvent
     * @throws IOException
     */
    public void ApprenticeEditHandle(ActionEvent actionEvent) throws IOException {
        title = "Apprentice Modification";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/apprentice modification.fxml"));
        fxmlLoading(fxmlLoader, title);
        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * this button allows you to remove an apprentice and then takes you back to the apprentice overview
     * @param actionEvent
     * @throws IOException
     */
    public void ApprenticeRemoveHandle(ActionEvent actionEvent) throws IOException {
        title = "Apprentice Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/apprentice Overview.fxml"));
        fxmlLoading(fxmlLoader, title);
        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username = KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();
        apprenticeID = KeeperOfKeys.getLoggedUserNameInstance().currentApprenticeID().getsApprenticeID();
        view = DBFacade.retrieveApprenticeDetail(apprenticeID).get(0);
        apprenticePersInfoArea.setText(view.getName() + "\n" + view.getEmail() + "\n" + view.getCPR() + "\n" + view.getPhone() + "\n" + view.getGeneralExpertise() + "\n" + view.getWorkExperience() + "\n");

    }
}
