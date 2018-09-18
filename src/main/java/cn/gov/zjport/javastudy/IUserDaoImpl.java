package cn.gov.zjport.javastudy;

public class IUserDaoImpl implements IUserDao{


    @Override
    public void add() {
        System.out.println(name);

    }

    @Override
    public void del() {

    }

    @Override
    public void query() {

    }

    @Override
    public void update() {

    }

    public static void main(String[] args) {
        new IUserDaoImpl().add();
    }
}
