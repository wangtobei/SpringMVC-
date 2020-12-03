package models;
// 客户信息
public class User {
    private int empID;          //用户id
    private String userName;    //用户名
    private String passWord;    //密码
    private String empPost;     //职工
    private String phone;       //电话号码
    private int privilege;      //用户权限

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmpPost() {
        return empPost;
    }

    public void setEmpPost(String empPost) {
        this.empPost = empPost;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    @Override
    public String toString() {
        return "User{" +
                "empID=" + empID +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", empPost='" + empPost + '\'' +
                ", phone='" + phone + '\'' +
                ", privilege=" + privilege +
                '}';
    }
}
