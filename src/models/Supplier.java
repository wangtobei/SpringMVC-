package models;

public class Supplier {
    private int supID;  //供货商id
    private String supName; //供货商品名
    private String supContact; //联系人姓名
    private String supPhone; //供货商电话
    private String address; //供货商地址

    @Override
    public String toString() {
        return "Supplier{" +
                "supID='" + supID + '\'' +
                ", supName='" + supName + '\'' +
                ", supContact='" + supContact + '\'' +
                ", supPhone='" + supPhone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public int getSupID() {
        return supID;
    }

    public void setSupID(int supID) {
        this.supID = supID;
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
