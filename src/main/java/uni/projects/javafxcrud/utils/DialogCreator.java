package uni.projects.javafxcrud.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import uni.projects.javafxcrud.controllers.BaseController;

import java.io.IOException;
import java.net.URL;

@Component
public class DialogCreator {
    private final ApplicationContext applicationContext;
    private Stage dialogStage;

    @Autowired
    public DialogCreator(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void createAndShowModalDialog(final String title,
                                         final Stage primaryStage, final URL pathToFxml) {
        dialogStage = new Stage();

        // Create the dialog Stage.
        dialogStage.setTitle(title);
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);

        final FXMLLoader fxmlLoader = loadAndSetScene(pathToFxml);
        injectStageInController(dialogStage, fxmlLoader);

        dialogStage.showAndWait();
    }

    public void createAndShowPrimaryDialog(final String title,
                                           final Stage primaryStage, final URL pathToFxml) {
        dialogStage = new Stage();

        // Create the dialog Stage.
        dialogStage.setTitle(title);
        dialogStage.setResizable(false);

        final FXMLLoader fxmlLoader = loadAndSetScene(pathToFxml);
        injectStageInController(primaryStage, fxmlLoader);

        dialogStage.show();
    }

    private void injectStageInController(final Stage stage, final FXMLLoader loader) {
        final BaseController controller = loader.getController();
        controller.setPrimaryStage(stage);
    }

    private FXMLLoader loadAndSetScene(final URL pathToFxml) {
        final FXMLLoader fxmlLoader = new FXMLLoader(pathToFxml);

        // Set Spring as controller factory to make Spring aware of controller.
        fxmlLoader.setControllerFactory(applicationContext::getBean);

        Scene scene;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
            return fxmlLoader;
        }
        dialogStage.setScene(scene);
        return fxmlLoader;
    }
}
