package cn.gov.zjport.javastudy;

public abstract class UFO {
    String colour;
    String shade;

    public UFO(){
        this.colour="黄色";
        this.shade="椭圆";
    }

    public void fly(){
        System.out.println(this.shade+"fly");
    }

    public abstract void engine();

    public static void main(String[] args) {
        NewUFO ufo = new NewUFO();
        ufo.engine();
        ufo.fly();
    }

}
