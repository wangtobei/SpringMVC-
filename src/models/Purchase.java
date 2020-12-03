package models;

import java.util.Date;

//进货单
public class Purchase {
    private int pcID;//进货单单号
    private Product product;//购买的产品   db int pid
    private Supplier supplier;//供货商    db int sid
    private int count; //购买的数量
    private Date date;//进货的时间

    public int getPcID() {
        return pcID;
    }

    public void setPcID(int pcID) {
        this.pcID = pcID;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "pcID=" + pcID +
                ", product=" + product +
                ", supplier=" + supplier +
                ", count=" + count +
                ", date=" + date +
                '}';
    }
}
