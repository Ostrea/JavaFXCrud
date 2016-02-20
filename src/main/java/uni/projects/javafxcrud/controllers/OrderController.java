package uni.projects.javafxcrud.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import uni.projects.javafxcrud.models.Order;

import java.io.IOException;
import java.time.LocalDate;

public class OrderController {
    private Stage primaryStage;
    private final ObservableList<Order> orders = FXCollections.observableArrayList();

    @FXML
    private TextField orderIdTextField;
    @FXML
    private TextField contractIdTextField;
    @FXML
    private TextField supplierTextField;
    @FXML
    private TextField orderDateTextField;
    @FXML
    private Button nextOrderButton;
    @FXML
    private Button previousOrderButton;

    private int currentOrderNumber = 0;

    private void initOrders() {
        for (int i = 1; i < 7; i++) {
            orders.add(new Order(i, 7 - i, i + " Supplier", LocalDate.of(2003 + i, 4 + i, 19 + i)));
        }
    }

    @FXML
    private void initialize() {
        initOrders();
        showOrder(0);

        previousOrderButton.setDisable(true);
    }

    private void showOrder(int orderNumber) {
        Order currentOrder = orders.get(orderNumber);
        orderIdTextField.setText(Long.toString(currentOrder.getId()));
        contractIdTextField.setText(Long.toString(currentOrder.getContractId()));
        supplierTextField.setText(currentOrder.getSupplier());
        orderDateTextField.setText(currentOrder.getDate().toString());
    }

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

        NewOrderController newOrderController = fxmlLoader.getController();
        newOrderController.setPrimaryStage(dialogStage);
    }

    @FXML
    private void handleNextOrderButton() {
        if (currentOrderNumber + 1 < orders.size()) {
            currentOrderNumber++;
        }
        if (currentOrderNumber == orders.size() - 1) {
            nextOrderButton.setDisable(true);
        }
        showOrder(currentOrderNumber);
        previousOrderButton.setDisable(false);
    }

    @FXML
    private void handlePreviousOrderButton() {
        if (currentOrderNumber - 1 > -1) {
            currentOrderNumber--;
        }
        if (currentOrderNumber == 0) {
            previousOrderButton.setDisable(true);
        }
        showOrder(currentOrderNumber);
        nextOrderButton.setDisable(false);
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
