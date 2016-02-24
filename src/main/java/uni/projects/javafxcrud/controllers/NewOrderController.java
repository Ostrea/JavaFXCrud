package uni.projects.javafxcrud.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uni.projects.javafxcrud.utils.DialogCreator;

import java.io.IOException;

@Component
public class NewOrderController extends BaseController {

    @Autowired
    public NewOrderController(DialogCreator dialogCreator) {
       super(dialogCreator);
    }

    @FXML
    private void handleSuppliersButton() {
        dialogCreator.createAndShowModalDialog("Поставщики по типу товара", primaryStage,
                getClass().getClassLoader().getResource("suppliers_query_by_product_type.fxml"));
    }

    @FXML
    private void handleAddOrderButton() {

        // TODO check if contract with supplier is out of date
        dialogCreator.createAndShowModalDialog("Каталог поставщика", primaryStage,
                getClass().getClassLoader().getResource("supplier_catalog.fxml"));
    }
}
