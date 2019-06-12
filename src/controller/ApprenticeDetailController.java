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
    public void backToApprenticeOverviewHandle(ActionEvent actionEvent) throws IOException {
        title = "Apprentice Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/apprentice Overview.fxml"));
        fxmlLoading(fxmlLoader, title);
        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void ApprenticeExportHandle(ActionEvent actionEvent) {
    }

    public void ApprenticePrintHandle(ActionEvent actionEvent) {
    }

    public void ApprenticeEditHandle(ActionEvent actionEvent) throws IOException {
        title = "Apprentice Modification";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/apprentice modification.fxml"));
        fxmlLoading(fxmlLoader, title);
        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }

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
