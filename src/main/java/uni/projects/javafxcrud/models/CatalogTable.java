package uni.projects.javafxcrud.models;

import javax.persistence.*;

@Entity
public class CatalogTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @JoinColumn(nullable = false)
    private CommodityTypeTable commodityType;

    @Column(nullable = false)
    private long supplierId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String characteristic;

    @Column(nullable = false)
    private String unitOfMeasurement;
    
    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private int price;

    protected CatalogTable() {}

    public CatalogTable(CommodityTypeTable commodityType,
                        long supplierId, String name,
                        String characteristic, String unitOfMeasurement,
                        int quantity, int price) {
        this.commodityType = commodityType;
        this.supplierId = supplierId;
        this.name = name;
        this.characteristic = characteristic;
        this.unitOfMeasurement = unitOfMeasurement;
        this.quantity = quantity;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CommodityTypeTable getCommodityType() {
        return commodityType;
    }

    public void setCommodityType(CommodityTypeTable commodityType) {
        this.commodityType = commodityType;
    }

    public long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(long supplierId) {
        this.supplierId = supplierId;
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

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
