package uni.projects.javafxcrud.models;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Order {
    private final LongProperty id;
    private final LongProperty contractId;
    private final StringProperty supplier;
    private final ObjectProperty<LocalDate> date;

    public Order(long id, long contractId,
                 String  supplier, LocalDate date) {
        this.id = new SimpleLongProperty(id);
        this.contractId = new SimpleLongProperty(contractId);
        this.supplier = new SimpleStringProperty(supplier);
        this.date = new SimpleObjectProperty<>(date);
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
}
