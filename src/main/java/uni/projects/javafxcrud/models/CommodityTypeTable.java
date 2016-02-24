package uni.projects.javafxcrud.models;

import javax.persistence.*;

@Entity
public class CommodityTypeTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String typeName;

    protected CommodityTypeTable() {}

    public CommodityTypeTable(String typeName) {
        this.typeName = typeName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
