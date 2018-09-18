package cn.gov.learn.test;

import cn.gov.learn.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
@SessionAttributes(value={"user"},types = {String.class})
@RequestMapping("/springmvc")
//表示修饰的类为springmvc的注解类
@Controller
public class SpringMVCTest {

    private static final String SUCCESS = "success";
    private static final String SUCCESS12 = "gaoshou";

    /*
    有modelattribute标记的方法，会在每个目标方法执行之前被springmvc调用
     */
    @ModelAttribute
    public void getUser(@RequestParam(value = "id",required = false) Integer id,Map<String,Object> map){
        System.out.println("modelAttribute method");
        if(id !=null){
            //模拟从数据库中获取对象
            User user = new User(1,"Tom","123456","tom@atgui.com",12);
            System.out.println("从数据库获取一个对象"+user);
            map.put("user",user);
        }
    }

    /*运行流程
    1.执行@ModelAttribute 注解修饰的方法，从数据库中取出对象，把对象放入到map中 键位：user
    2.springmvc把map中取出User对象，并把表单的请求参数赋给该User对象的对应属性
    3.springmvc把上诉对象传入目标方法的参数
    注意：在modelattribute修饰的方法中，放入到map时的键需要和目标方法入参类型的第一个字母小写的字符串一致
     */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(User user){
        System.out.println("修改："+user);
        return SUCCESS;
    }
    /*
    除了可以通过属性名指定需要放到会话中的属性外（实际上使用的是value属性值）
    还可以通过模型属性的对象类型指定哪些模型属性需要放到会话中（实际上使用的是value属性值）
    该注解只能放在类的上面，而不能修饰方法
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Map<String,Object> map){
        User user = new User("Tom","123456","06092853@163.com",16);
        map.put("user",user);
        map.put("school","hangzhoudianzi");
        return SUCCESS;
    }


    /*
    目标方法可以添加map类型（实际上可以是model类型或者modelmap类型）的参数
     */
    @RequestMapping("/testMap")
    public String testMap(Map<String,Object> map){
        System.out.println(map.getClass().getName());
        map.put("names", Arrays.asList("Tom","Jerry","gaoshou"));
        return SUCCESS;
    }



    /*
    目标方法的返回值可以是ModelAndView类型，其中可以包含视图和模型信息
    SpringMVC会把ModelAndView的model中数据放入到request域对象中
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        String viewName = SUCCESS;
        ModelAndView modelAndView = new ModelAndView(viewName);
        //添加模型数据导modelandview中
        modelAndView.addObject("time",new Date());
        return modelAndView;

    }

    /*
    可以使用serlvet原生的API作为目标方法的参数，具体支持以下类型
    HttpServletRequest，HttpServletResponse，HttpSession，Reader，Writer等
     */
    @RequestMapping("/testServletAPI")
    public void testServletAPI(HttpServletRequest request, HttpServletResponse response, Writer out) throws IOException {
        System.out.println("testServletAPI, " + request+","+response);
        out.write("hello springMVC");
        //return SUCCESS;
    }
    /*
    springmvc会按请求参数名和POJO属性名进行自动匹配
    自动为该对象填充属性值，支持级联属性如address.city
     */
    @RequestMapping("testPojo")
    public String testPojo(User user){
        System.out.println("testPojo: "+user);
        return SUCCESS;
    }

    /*
    @CookieValue:映射一个cookie值，属性同@requestparam
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String sessionId){
        System.out.println("testCookieValue: sessionId: "+sessionId);
        return SUCCESS;
    }


    /*
    映射请求头信息用法同@requestparam
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept-Language") String a1){
        System.out.println("testRequestHeader:"+a1 );
        return SUCCESS;
    }



    /*
    RequestParam来映射请求参数
    value值即请求参数的参数名
    required该参数是否必填，默认为true
    defaultvalue请求参数的默认值
     */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(value = "username") String un,@RequestParam(value="age",required = false,defaultValue = "0") int age){
        System.out.println("testRequestParam,username:"+un+",age:"+age);
        return SUCCESS;
    }


    @RequestMapping(value="/testRest/{id}",method = RequestMethod.GET)
    public String testRest(@PathVariable Integer id){
        System.out.println("testRest GET:"+id);
        return SUCCESS;
    }

    @RequestMapping(value="/testRest",method = RequestMethod.POST)
    public String testRest(){
        System.out.println("testRest POST:");
        return SUCCESS;
    }

    /*
    如何发送PUT请求和DELETE请求呢
    1。需要配置HiddenHttpMethodFilter
    2.需要发送post请求
    3.需要再发送post请求时携带一个name="_method"的隐藏域，值为delete或put
    在springmvc的目标方法中如何获得id呢？ 使用@PathVariable注解
     */

    @RequestMapping(value="/testRest/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public String testRestDelete(@PathVariable Integer id){
        System.out.println("testRest DELETE:"+id);
        return SUCCESS12;
    }

    /*
    发起的请求是个RESTFul风格的请求，调用了RESTFul风格的PUT方法。但是controller里testRestPUT返回的success字符串被映射到success.jsp。因此spring认为这应该是个JSP接口，且JSP接口仅仅支持GET方法和POST方法。所以系统提示提示了这个错误。
    rest风格的url，已CRUD为例，新增/order post   修改/order/1 PUT
    获取/order/1 GET   删除/order/1 DELETE
     */
    @RequestMapping(value="/testRest/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public String testRestPut(@PathVariable Integer id){
        System.out.println("testRest PUT:"+id);
        return SUCCESS12;
    }









    /*
    @pathvariable可以来映射URL中的占位符到目标方法的参数中
     */
    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") Integer id){
        System.out.println("testPathVariable:"+id);
        return SUCCESS;
    }

    @RequestMapping("/testAntPath/*/abc")
    public String testAntPath(){
        System.out.println("testAntPath");
        return SUCCESS;
    }


    /*
    了解：可以使用params和headers来更加精确的映射请求，params和header支持简单的表达式
     */
    @RequestMapping(value = "testParamsAndHeaders",params = {"username","age!=10"},headers = {"Accept-Language: zh-CN,zh;q=0.9"})
    public String testParamsAndHeaders(){
        System.out.println("testParamsAndHeaders");
        return SUCCESS;
    }


    /*
    使用method属性来指定请求方式
     */
    @RequestMapping(value="/testMethod",method=RequestMethod.POST)
    public String testMethod(){
        System.out.println("testMethod");
        return SUCCESS;
    }

    /*
    1.@RequestMapping除了修饰方法，还可来修饰类
    2.类定义处：提供初步的请求映射信息，相对于web应用的根目录
    2.方法处：提供进一步的细分映射信息，相对于类定义出的URL，若类定义出未标注@RequestMapping
    ，则方法处标记的url相当于web应用的根目录
     */

    @RequestMapping("/testRequestMapping")
    public String testRequestMapping(){
        System.out.println("testRequestMapping");
        return SUCCESS;
    }
}
