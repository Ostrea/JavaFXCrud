package uni.projects.javafxcrud.models.dbService.dataSets;


import javax.persistence.*;

/**
 * Created by qwe on 21.02.2016.
 * Недоделано, пока читаю про хайбер, не трогай этот датасет
 *
 */

@Entity
@Table(name = "commodityType")
public class CommodityTypeDataSet {
    @Column (name = "typeCode")
    private long typeCode;

    @Column (name = "commodityType")
    private String commodityType;

    public String getCommodityType() {
        return commodityType;
    }

    public void setCommodityType(String commodityType) {
        this.commodityType = commodityType;
    }

    public long getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(long typeCode) {
        this.typeCode = typeCode;
    }

}
