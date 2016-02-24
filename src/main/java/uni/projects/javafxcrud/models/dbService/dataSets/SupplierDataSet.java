package uni.projects.javafxcrud.models.dbService.dataSets;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "suppliers")
public class SupplierDataSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "supplierId")
    private long supplierId;
    @Column (name = "name")
    private String name;
    @Column (name = "address")
    private String address;
    @Column (name = "phoneNumber")
    private String phoneNumber;
    @Column (name = "faxNumber")
    private String faxNumber;
    @Column (name = "directorName")
    private String directorName;
    @Column (name = "bookerName")
    private String bookerName;
    @Column (name = "requisites")
    private String requisites;
    @Column (name = "INN")
    private String INN;
    @OneToMany(mappedBy = "supplier")
    private List<CatalogDataSet> catalog;

    public SupplierDataSet() {
        this.supplierId = -1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getBookerName() {
        return bookerName;
    }

    public void setBookerName(String bookerName) {
        this.bookerName = bookerName;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

    public String getINN() {
        return INN;
    }

    public void setINN(String INN) {
        this.INN = INN;
    }

    public List<CatalogDataSet> getCatalog() {
        return catalog;
    }

    public void setCatalog(List<CatalogDataSet> catalog) {
        this.catalog = catalog;
    }
}
