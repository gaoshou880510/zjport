package cn.gov.zjport.javastudy;

public interface IUserDao {

    String name = "张三";

    public abstract  void add();
    public void del();
    abstract  void query();
    void update();

}
