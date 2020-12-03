package models;
// 商品
public class Product {
    private int id;         //产品id
    private String name;    //产品名称
    private float price;    //产品价格
    private int stockNum;   //产品库存
    private int salarmNum;  //报警线
    private int supId;      //供应商id

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStockNum() {
        return stockNum;
    }

    public void setStockNum(int stockNum) {
        this.stockNum = stockNum;
    }

    public int getSalarmNum() {
        return salarmNum;
    }

    public void setSalarmNum(int salarmNum) {
        this.salarmNum = salarmNum;
    }

    public int getSupId() {
        return supId;
    }

    public void setSupId(int supId) {
        this.supId = supId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stockNum=" + stockNum +
                ", salarmNum=" + salarmNum +
                ", supId=" + supId +
                '}';
    }
}
