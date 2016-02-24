package uni.projects.javafxcrud;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import uni.projects.javafxcrud.controllers.OrderController;

@SpringBootApplication
public class Main extends Application {
    private ConfigurableApplicationContext applicationContext;

    @Override
    public void start(Stage primaryStage) throws Exception {
        applicationContext = SpringApplication.run(getClass());
        applicationContext.getAutowireCapableBeanFactory().autowireBean(this);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("order.fxml"));

        primaryStage.setTitle("Заказ");
        primaryStage.setScene(new Scene(fxmlLoader.load(), 800, 600));
        primaryStage.setResizable(false);
        primaryStage.show();

        OrderController orderController = fxmlLoader.getController();
        orderController.setPrimaryStage(primaryStage);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        applicationContext.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
