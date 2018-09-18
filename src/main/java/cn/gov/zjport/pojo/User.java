package cn.gov.zjport.pojo;

import org.springframework.format.annotation.NumberFormat;

public class User {
    private Integer age;
    private String name;

    //数据的格式化,前端页面数据格式控制（pattern自定义样式  style另一种样式）
    @NumberFormat(pattern = "#,###.##")
    private Double salary;


    public User(){

    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
