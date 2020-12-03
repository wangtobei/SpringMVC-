package pojo;

public class ProductBindSupplier {
    private int id;         //产品id
    private String name;    //产品名称
    private float price;    //产品价格
    private int stockNum;   //产品库存
    private int salarmNum;  //报警线
    private int supId;      //供应商id
    private String supName; //供货商品名
    private String supContact; //联系人姓名
    private String supPhone; //供货商电话
    private String address; //供货商地址

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

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String getSupContact() {
        return supContact;
    }

    public void setSupContact(String supContact) {
        this.supContact = supContact;
    }

    public String getSupPhone() {
        return supPhone;
    }

    public void setSupPhone(String supPhone) {
        this.supPhone = supPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
