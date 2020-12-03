package pojo;

public class Purchasepjo {
    private int pcID;//进货单单号
    private int pid;//购买的产品   db int pid
    private int sid;//供货商    db int sid
    private int count; //购买的数量
    private String date;//进货的时间

    public int getPcID() {
        return pcID;
    }

    public void setPcID(int pcID) {
        this.pcID = pcID;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
