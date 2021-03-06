package uni.projects.javafxcrud.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uni.projects.javafxcrud.utils.DialogCreator;
import uni.projects.javafxcrud.viewmodels.Commodity;
import uni.projects.javafxcrud.viewmodels.Order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrderController extends BaseController {
    private final ObservableList<Order> orders = FXCollections.observableArrayList();
    private final List<List<Commodity>> commodities = new ArrayList<>();

    // Text fields
    @FXML
    private TextField orderIdTextField;
    @FXML
    private TextField contractIdTextField;
    @FXML
    private TextField supplierTextField;
    @FXML
    private TextField orderDateTextField;

    // Buttons
    @FXML
    private Button nextOrderButton;
    @FXML
    private Button previousOrderButton;
    @FXML
    private Button lastOrderButton;
    @FXML
    private Button firstOrderButton;

    // Commodity table
    @FXML
    private TableView<Commodity> commodityTable;
    @FXML
    private TableColumn<Commodity, String> commodityTypeColumn;
    @FXML
    private TableColumn<Commodity, String> commodityModelColumn;
    @FXML
    private TableColumn<Commodity, Integer> commodityPriceColumn;
    @FXML
    private TableColumn<Commodity, Integer> commodityQuantityColumn;

    private int currentOrderNumber = 0;

    @Autowired
    public OrderController(DialogCreator dialogCreator) {
        super(dialogCreator);
    }

    private void initOrders() {
        for (int i = 1; i < 7; i++) {
            orders.add(new Order(i, 7 - i, i + " Supplier",
                    LocalDate.of(2003 + i, 4 + i, 19 + i), commodities.get(i - 1)));
        }
    }

    @FXML
    private void initialize() {
        initCommodities();
        initOrders();
        initColumnValues();

        previousOrderButton.setDisable(true);
        firstOrderButton.setDisable(true);

        showOrder(0);
    }

    private void initColumnValues() {
        commodityTypeColumn.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
        commodityModelColumn.setCellValueFactory(cellData -> cellData.getValue().modelProperty());
        commodityPriceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        commodityQuantityColumn.setCellValueFactory(cellData -> cellData.getValue().quantityProperty().asObject());
    }

    private void initCommodities() {
        for (int i = 0; i < 6; i++) {
            final List<Commodity> temp = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                temp.add(new Commodity(i + ":" + j + " type", i + ":" + j + "model", i + j, i + j));
            }
            commodities.add(temp);
        }
    }

    private void showOrder(int orderNumber) {
        final Order currentOrder = orders.get(orderNumber);
        orderIdTextField.setText(Long.toString(currentOrder.getId()));
        contractIdTextField.setText(Long.toString(currentOrder.getContractId()));
        supplierTextField.setText(currentOrder.getSupplier());
        orderDateTextField.setText(currentOrder.getDate().toString());
        commodityTable.setItems(currentOrder.getCommodities());
    }

    @FXML
    private void handleAddOrderButton() {
        dialogCreator.createAndShowModalDialog("Новый заказ", primaryStage,
                getClass().getClassLoader().getResource("new_order.fxml"));
    }

    @FXML
    private void handleNextOrderButton() {
        if (currentOrderNumber + 1 < orders.size()) {
            currentOrderNumber++;
        }
        if (currentOrderNumber == orders.size() - 1) {
            nextOrderButton.setDisable(true);
            lastOrderButton.setDisable(true);
        }

        showOrder(currentOrderNumber);

        previousOrderButton.setDisable(false);
        firstOrderButton.setDisable(false);
    }

    @FXML
    private void handlePreviousOrderButton() {
        if (currentOrderNumber - 1 > -1) {
            currentOrderNumber--;
        }
        if (currentOrderNumber == 0) {
            previousOrderButton.setDisable(true);
            firstOrderButton.setDisable(true);
        }

        showOrder(currentOrderNumber);

        nextOrderButton.setDisable(false);
        lastOrderButton.setDisable(false);
    }

    @FXML
    private void handleLastOrderButton() {
        currentOrderNumber = orders.size() - 1;

        nextOrderButton.setDisable(true);
        previousOrderButton.setDisable(false);
        lastOrderButton.setDisable(true);
        firstOrderButton.setDisable(false);

        showOrder(currentOrderNumber);
    }

    @FXML
    private void handleFirstOrderButton() {
        currentOrderNumber = 0;

        nextOrderButton.setDisable(false);
        previousOrderButton.setDisable(true);
        lastOrderButton.setDisable(false);
        firstOrderButton.setDisable(true);

        showOrder(currentOrderNumber);
    }
}
