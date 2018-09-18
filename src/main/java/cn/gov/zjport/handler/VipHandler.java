package cn.gov.zjport.handler;

import cn.gov.zjport.common.ThisSystemException;
import cn.gov.zjport.entity.VIPEntity;
import cn.gov.zjport.entity.VipRankEntity;
import cn.gov.zjport.function.VIPFunction;
import cn.gov.zjport.pojo.Account;
import cn.gov.zjport.pojo.User;
import cn.gov.zjport.web.vo.VIPAo;
import cn.gov.zjport.web.vo.VIPVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

//控制器
@Controller
//通过属性key值完成session的共享数据设置
//@SessionAttributes(value={"city"})
@SessionAttributes(types = {String.class})
//@RequestMapping("/springmvc")如果类这里加了这注解，那index.jsp那的 href="springmvc/learnMVC"就需要完整路径
public class VipHandler extends AbstractHandler {

        @Autowired
        VIPFunction fun;

        //占位符绑定到请求处理方法当中，配合请求处理方法的形参，获取到前端jsp的值13 href="learnMVC/13"
        @RequestMapping(value = "/learnMVC/{id}")
        public String learnMVC(@PathVariable(value="id") int id){
            System.out.println(id);
            System.out.println("自学Spring-MVC");
            return "welcome";
        }

        @RequestMapping(value = "/testFormat")
        public String testFormat(User user){
            System.out.println("自学gaoshou");
            System.out.println(user);
            return "welcome";
        }



        //Springmvc是通过处理方法的形参于请求参数进行绑定，加入注解@RequestParam（value="前端控件的name属性值"）
        @RequestMapping(value = "/learnMVCparam1")
        public String learnMVCparam1(@RequestParam(value = "id",required = true) Integer id,@RequestParam(value = "name") String name){
            System.out.println(id);
            System.out.println(name);
            System.out.println("gga");
            return "welcome";
        }

        @RequestMapping(value = "/learnMVCparam2")
        public String learnMVCparam2(User user){
            System.out.println("进来了");
            System.out.println(user);
            return "welcome";
        }

        @RequestMapping(value = "/learnMVCparam4")
        public ModelAndView learnMVCparam4(){
            ModelAndView mv = new ModelAndView();
            mv.setViewName("welcome");
            //ModelAndView模型数据的值放到request范围当中
            mv.addObject("name","GAOSHOU");
            return mv;
        }

        @RequestMapping(value = "/learnMVCparam3")
        public String learnMVCparam3(@RequestHeader("Accept") String a,@RequestHeader("User-Agent") String b,@CookieValue("JSESSIONID") String c){
            System.out.println("headg管理");
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
            return "welcome";
        }

        @RequestMapping(value = "/learnMVCparam5")
        public ModelAndView learnMVCparam5(){
            ModelAndView mv = new ModelAndView();
            mv.setViewName("welcome");
            //ModelAndView模型数据的值放到request范围当中
            mv.addObject("name","GAOSHOU");
            return mv;
        }

        @RequestMapping(value = "/learnMVCparam6")
        public String learnMVCparam6(Map<String,Object> map){
            map.put("age",13);
            return "welcome";
        }

        @RequestMapping(value = "/learnMVCparam7")
        public String learnMVCparam7(Model model){
            model.addAttribute("mail","332010328@qq.com");
            return "welcome";
        }

        @RequestMapping(value = "/learnMVCparam")
        public String learnMVCparam(ModelMap modelMap){
            modelMap.addAttribute("city","Beijing");
            return "welcome";
        }

        @RequestMapping(value = "/result")
        public String testResult(){
            return "result";
        }

        //此注解是所有控制器方法执行前先执行
        @ModelAttribute("abc")
        public Account start(){
            Account account = new Account(1,"TOM","2016-1-1");
            //map.put("abc",account);
            return account;
        }

        @RequestMapping("/testModeAttribute")
        public String update(@ModelAttribute("abc") Account account){
            System.out.println(account);
            return "welcome";
        }






        //控制器处理请求的业务方法的格式：返回的query会处理成/WEB-INF/views/query.jsp,这是前面spring-mvc前缀后缀配置所得
        @RequestMapping(path = "/query.do",method = RequestMethod.GET)
        public String queryViewGet() throws Exception{
            return "query";
        }

        @RequestMapping(path = "/query.do",method = RequestMethod.POST)
        public String queryViewPost(String code,HttpServletRequest req) throws Exception{
            try{
                VIPEntity v = fun.queryVip(code);

                VIPVo vo = new VIPVo();
                vo.setAddress(v.getAddress());
                vo.setAge(String.valueOf(v.getAge()));
                vo.setAmount(String.valueOf(v.getAmount()/100.0));
                vo.setCode(v.getCode());
                vo.setEmail(v.getEmail());
                vo.setName(v.getName());
                vo.setQq(v.getQq());
                //查询vip级别
                VipRankEntity rank = this.getRank(req,v.getRank());

                vo.setRank(rank.getName());
                vo.setRemark(v.getRemark());
                vo.setSex(v.isMale()?"男":"女");
                v.setZip(vo.getZip());

                req.setAttribute("v",vo);

            }catch (ThisSystemException e){
                req.setAttribute("message",e.getMessage());
            }

            return "query";
        }


        @RequestMapping(path = "/add.do",method = RequestMethod.GET)
        public String addView(){
            return "add";
        }

        @RequestMapping(path = "/add.do",method = RequestMethod.POST)
        public String addVip(VIPAo ao,HttpServletRequest req)throws Exception{
            //1.业务方法执行
            try{
                VIPEntity v = fun.addVip(ao);
                req.setAttribute("message","录入成功");
                return "add";
            }catch (ThisSystemException e){
                req.setAttribute("message",e.getMessage());
            }
            //2业务跳转

            //




            return "add";
        }



}
