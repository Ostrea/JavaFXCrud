package uni.projects.javafxcrud.controllers;

import javafx.stage.Stage;

public abstract class BaseController {
    protected Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    protected BaseController() {}
}
