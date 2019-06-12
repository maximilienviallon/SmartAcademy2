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

public class EducationDetailController  extends Controller implements Initializable {
    @FXML
    TextArea educationInfoArea;
    FXMLLoader fxmlLoader;
    String title;
    String username;
    Integer educationID;

    public void backToEducationOverviewHandle(ActionEvent actionEvent)throws IOException {
        title = "Education Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/education Overview.fxml"));
        fxmlLoading(fxmlLoader, title);
        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void EducationExportHandle(ActionEvent actionEvent) {
    }

    public void EducationPrintHandle(ActionEvent actionEvent) {
    }

    public void EducationEditHandle(ActionEvent actionEvent) throws IOException{
        title = "Education Modification";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/education modification.fxml"));
        fxmlLoading(fxmlLoader, title);
        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void EducationRemoveHandle(ActionEvent actionEvent) throws IOException{
        title = "education Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/education Overview.fxml"));
        fxmlLoading(fxmlLoader, title);
        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username = KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();
        educationID = KeeperOfKeys.getLoggedUserNameInstance().currentEducationID().getsEducationID();
        Educations view = DBFacade.retrieveEducationDetail(educationID).get(0);
        educationInfoArea.setText(view.getName() + "\n" + view.getProvider() + "\n" + view.getCity() + "\n" + view.getEduStart() + "\n" + view.getEduEnd() + "\n" + view.getZipcode() + "\n" + view.getAMU() + "\n" + view.getDescription() + "\n");
    }
}
