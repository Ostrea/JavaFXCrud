package uni.projects.javafxcrud.models.dbService.dataSets;

import javax.persistence.*;

@Entity
@Table (name = "catalog")
public class CatalogDataSet {
    @ManyToOne
    @JoinColumn(name = "commodityTypeId")
    private CommodityTypeDataSet commodityType;

    @Id
    @Column(name = "commodityCode")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long commodityCode;
    @Column(name = "supplierId")
    private long supplierId;
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

    public CatalogDataSet(long supplierId, long commodityCode, String name, String characteristic, String measure, int quantity, long price) {
        this.supplierId = supplierId;
        this.commodityCode = commodityCode;
        this.name = name;
        this.characteristic = characteristic;
        this.measure = measure;
        this.quantity = quantity;
        this.price = price;
        this.commodityCode = -1;
    }

    public long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(long postId) {
        this.supplierId = supplierId;
    }

    public long getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(long commodityCode) {
        this.commodityCode = commodityCode;
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
