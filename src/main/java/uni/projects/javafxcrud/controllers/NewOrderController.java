package uni.projects.javafxcrud.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by qwe on 19.02.2016.
 */
public class NewOrderController {
    private Stage primaryStage;

    @FXML
    private void handleSuppliersButton() {

        // Create the dialog Stage.
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Поставщики по типу товара");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);

        FXMLLoader fxmlLoader =
                new FXMLLoader(getClass().getClassLoader().getResource("suppliers_query_by_product_type.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        dialogStage.setScene(scene);
        dialogStage.showAndWait();
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
