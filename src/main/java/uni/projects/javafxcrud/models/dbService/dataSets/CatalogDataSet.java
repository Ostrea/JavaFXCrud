package uni.projects.javafxcrud.models.dbService.dataSets;

import javax.persistence.*;

@Entity
@Table (name = "catalog")
public class CatalogDataSet {
    @ManyToOne
    @JoinColumn(name = "commodityTypeId")
    private CommodityTypeDataSet commodityType;

    @Id
    @Column(name = "commodityId")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long commodityId;

    @ManyToOne
    @JoinColumn(name = "supplierId")
    private SupplierDataSet supplier;
    @Column(name = "name")
    private String name;
    @Column(name = "characteristic")
    private String characteristic;
    @Column(name = "measure")
    private String measure;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "price")
    private long price;

    public CatalogDataSet(long commodityCode, String name, String characteristic, String measure, int quantity, long price) {
        this.commodityId = commodityCode;
        this.name = name;
        this.characteristic = characteristic;
        this.measure = measure;
        this.quantity = quantity;
        this.price = price;
    }

    public CatalogDataSet() {
    }

    public SupplierDataSet getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierDataSet supplier) {
        this.supplier = supplier;
    }

    public long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(long commodityCode) {
        this.commodityId = commodityCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
