package objects;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;



public class Messege {

    @FXML
    private Button btnOk;

    @FXML
    private Label lblMessege;

    private Stage stgMessege;

    public Messege(Stage stgOwner, String strMessege, String strMessegeName, String strPathFxml, String strPathIcon) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource(strPathFxml));
        stgMessege.setTitle(strMessegeName);
        stgMessege.getIcons().add(new Image(strPathIcon));
        stgMessege.setScene(new Scene(root));
        stgMessege.setResizable(false);

        stgMessege.initModality(Modality.WINDOW_MODAL);
        stgMessege.initOwner(stgOwner);

        stgMessege.show();
    }

    @FXML
    private void handleBtnOk(){

        stgMessege.close();

    }

}
