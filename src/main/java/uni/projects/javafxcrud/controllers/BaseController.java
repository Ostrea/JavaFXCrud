package uni.projects.javafxcrud.controllers;

import javafx.stage.Stage;
import uni.projects.javafxcrud.utils.DialogCreator;

public abstract class BaseController {
    protected Stage primaryStage;
    protected final DialogCreator dialogCreator;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public BaseController(DialogCreator dialogCreator) {
        this.dialogCreator = dialogCreator;
    }
}
