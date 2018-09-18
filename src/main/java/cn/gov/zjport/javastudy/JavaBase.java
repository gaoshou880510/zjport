package cn.gov.zjport.javastudy;
/*1.类名首字母大写
  2.方法名称首字母小写
  3.变量首字母小写
  4.常量所有字母都大写
 */

/*八种基本数据类型
    4种整数型 byte short int long
    2中浮点型float double
    1中布尔型boolean
    1中字符串char
 */

public class JavaBase {
    public static void main(String[] args) {
        System.out.println("HelloWorld");
        //var();
        calc();
    }

    /*
    变量的讲解
     */
    public static void var(){
        //变量的定义及初始化
        float price = 3.4f;
        double rate = 0.32;
        int number = 999999;
        char ch = 'A';
        long num = 99999999999L;

        //数据类型强弱关系byte，char，short->int->long->float->double
        System.out.println((byte)price);
        System.out.println(ch+1);
    }

    public static void calc(){
        //////////////算术运算////////////////
        int number1 = 10;
        double number2 = 31.4;
        System.out.println("num1+num2="+(number1+number2));
        int count = 10;
        System.out.println(count++);
        System.out.println(++count);
        System.out.println(5%3);
        //////////////逻辑运算（运算结果只能true或者false）///////////////
        int a = 100;
        int b = 40;
        boolean flag = a>80 && b <100;
        boolean remark = a >180 || b<100;
        System.out.println(flag);
        System.out.println(remark);



    }

}
