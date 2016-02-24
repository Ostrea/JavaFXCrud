package uni.projects.javafxcrud;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import uni.projects.javafxcrud.utils.DialogCreator;

@SpringBootApplication
public class Main extends Application {
    private ConfigurableApplicationContext applicationContext;

    @Autowired
    private DialogCreator dialogCreator;

    @Override
    public void start(Stage primaryStage) throws Exception {
        applicationContext = SpringApplication.run(getClass());
        applicationContext.getAutowireCapableBeanFactory().autowireBean(this);

        dialogCreator.createAndShowPrimaryDialog("Заказ", primaryStage,
                getClass().getClassLoader().getResource("order.fxml"));
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
