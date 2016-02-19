package uni.projects.javafxcrud.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class OrderController {

    private Stage primaryStage;

    @FXML
    private void handleAddOrderButton() {

        // Create the dialog Stage.
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Новый заказ");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("new_order.fxml"));
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
