package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * All controller classes extend this class in order to get the FXML loading, we had planned for a few more thing
 * but time prevented us from implementing them
 */
public class Controller {
    /**
     * this class is made to make the loading of the FXML files a lot simpler and shorter to write
     * all it needs is an @fxmlLoader and @title to load the file location and set a title for the window that you are loading
     * @param fxmlLoader
     * @param title
     * @throws IOException
     */
    public void fxmlLoading (FXMLLoader fxmlLoader,String title) throws IOException {
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(new Scene(root,1900,1000));
        stage.show();
    }
}
