package cn.gov.zjport.handler.listener;

import cn.gov.zjport.dao.VIPRankDao;
import cn.gov.zjport.entity.VipRankEntity;
import jdk.internal.org.objectweb.asm.TypeReference;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplicationListener extends ContextLoaderListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        super.contextInitialized(servletContextEvent);
        ServletContext sc = servletContextEvent.getServletContext();
        //初始化系统数据
        try{
            this.initVipRank(sc);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        super.contextDestroyed(servletContextEvent);
    }

    private void initVipRank(ServletContext param)throws Exception{
        WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(param);
        //获取dao
        VIPRankDao rdao = ac.getBean(VIPRankDao.class);
        List<VipRankEntity> ranks = rdao.selectAll();

        Map<Integer,VipRankEntity> ranksMap = new HashMap<>();
        for(VipRankEntity r:ranks){
            ranksMap.put(r.getCode(),r);
        }

        param.setAttribute("RANKS-MAP",ranksMap);


    }
}
