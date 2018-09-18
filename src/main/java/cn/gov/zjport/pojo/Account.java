package cn.gov.zjport.pojo;


public class Account {
    private Integer id;
    private String name;
    private String registerTime;

    public Account(){

    }

    public Account(Integer id, String name, String registerTime) {
        this.id = id;
        this.name = name;
        this.registerTime = registerTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", registerTime='" + registerTime + '\'' +
                '}';
    }
}
