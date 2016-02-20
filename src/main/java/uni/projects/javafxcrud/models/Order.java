package uni.projects.javafxcrud.models;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private final LongProperty id;
    private final LongProperty contractId;
    private final StringProperty supplier;
    private final ObjectProperty<LocalDate> date;
    private final ObservableList<Commodity> commodities;

    public Order(long id, long contractId,
                 String  supplier, LocalDate date, List<Commodity> commodities) {
        this.id = new SimpleLongProperty(id);
        this.contractId = new SimpleLongProperty(contractId);
        this.supplier = new SimpleStringProperty(supplier);
        this.date = new SimpleObjectProperty<>(date);
        this.commodities = FXCollections.observableArrayList(
                Collections.unmodifiableList(new ArrayList<>(commodities)));
    }

    public long getId() {
        return id.get();
    }

    public long getContractId() {
        return contractId.get();
    }

    public String getSupplier() {
        return supplier.get();
    }

    public LocalDate getDate() {
        return date.get();
    }

    public ObservableList<Commodity> getCommodities() {
        return commodities;
    }
}
