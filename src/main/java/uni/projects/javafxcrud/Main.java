package uni.projects.javafxcrud;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import uni.projects.javafxcrud.controllers.OrderController;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("order.fxml"));

        primaryStage.setTitle("Заказ");
        primaryStage.setScene(new Scene((Parent) fxmlLoader.load(), 800, 600));//попросил скастить к parent
        primaryStage.setResizable(false);
        primaryStage.show();

        OrderController orderController = fxmlLoader.getController();
        orderController.setPrimaryStage(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
