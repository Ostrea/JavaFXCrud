package uni.projects.javafxcrud.models.dbService.dataSets;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "commodityType")
public class CommodityTypeDataSet {

    @Id
    @Column (name = "typeCode")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long typeCode;
    @OneToMany(mappedBy = "commodityType")
    private List<CatalogDataSet> catalogDataSets;

    @Column (name = "commodityType")
    private String typeName;

    public long getTypeCode() {
        return typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public CommodityTypeDataSet(String typeName) {
        this.typeName = typeName;
        this.typeCode = -1;
        this.catalogDataSets = new ArrayList<>();
    }
}
