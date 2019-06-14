package controller;


import Persistence.DBFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import javafx.scene.control.TextField;

import java.io.IOException;

public class LogInController extends Controller {
    @FXML
    TextField loginIDTextField;
    @FXML
    public TextField logInPasswordID;



    private String userName;
    String title;


    /**
     * Method that takes the username and password entered into text fields and sends them to the DB for checking then sends you to your permissions appropriate starting screen
     * sadly there was no time left to make the buttons user should not have permission to press invisible and disabled
     * @param actionEvent
     * @throws IOException
     */
    public void logInButtonHandle(ActionEvent actionEvent) throws IOException {
        KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().setUserName(loginIDTextField.getText());
        if (DBFacade.checkLogin(true, loginIDTextField.getText(), logInPasswordID.getText())) {
            String permissionValue = DBFacade.checkPermission(loginIDTextField.getText());
            FXMLLoader fxmlLoader;
            switch(permissionValue) {
                case "SmartAdmin":
                    title = "Company Overview";
                    fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/company overview.fxml"));
                    break;
                case "Administrator":
                    title = "Company Overview";
                    fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/company overview.fxml"));
                    break;
                case "HR":
                    title = "Apprentice Overview";
                    fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/apprentice overview.fxml"));
                    break;
                case "Interviewer":
                    title = "Company Overview";
                    fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/company overview.fxml"));
                    break;
                default:
                    title = "Logged User Detail Overview";
                    fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/logged user detail.fxml"));
                    break;
            }
            fxmlLoading(fxmlLoader,title);
            ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
        }

}

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getUserName() {
        return userName;
    }
}