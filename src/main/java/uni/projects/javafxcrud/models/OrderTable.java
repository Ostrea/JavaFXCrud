package uni.projects.javafxcrud.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class OrderTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    // TODO make this field foreign key
    private long contract;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private int quantityOfCommodity;

    @Column(nullable = false)
    private int totalAmount;

    protected OrderTable() {}

    public OrderTable(long contract, LocalDate date, int quantityOfCommodity, int totalAmount) {
        this.contract = contract;
        this.date = date;
        this.quantityOfCommodity = quantityOfCommodity;
        this.totalAmount = totalAmount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getContract() {
        return contract;
    }

    public void setContract(long contract) {
        this.contract = contract;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getQuantityOfCommodity() {
        return quantityOfCommodity;
    }

    public void setQuantityOfCommodity(int quantityOfCommodity) {
        this.quantityOfCommodity = quantityOfCommodity;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
}
