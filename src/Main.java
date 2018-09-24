import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import controllers.AuthorizationWindowController;

public class Main extends Application {

    //public static Stage stgAuthorization;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stgAuthorization) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/gui/AuthorizationWindow.fxml"));
        Parent root =  (Parent) fxmlLoader.load();
        AuthorizationWindowController controller = fxmlLoader.getController();
        controller.setStage(stgAuthorization);
        stgAuthorization.setTitle("Authorization");
        stgAuthorization.getIcons().add(new Image("/images/icon/icnMainWindow.png"));
        stgAuthorization.setScene(new Scene(root));
        stgAuthorization.show();

    }

}
