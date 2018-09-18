package cn.gov.learn.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorld {

        private static final String SUCCESS = "success";
        /*
         *1.使用@RequestMapping注解来映射请求的URL
         * 2.返回值会通过视图解析器解析为实际的物理视图。对于InternalResourceViewResolver视图解析器，会做
         * 如下解析 前缀 /WEB-INF/views/success.jsp 的页面  后缀为.jsp  前后缀在springmvc里配置
         *
         */
        @RequestMapping("/helloworld")
        public String hello(){
            System.out.println("HelloWorld");
            return SUCCESS;
        }


}
