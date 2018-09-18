package cn.gov.zjport.function;

import cn.gov.zjport.entity.VIPEntity;
import cn.gov.zjport.web.vo.VIPAo;
import org.springframework.transaction.annotation.Transactional;

public interface VIPFunction {
    /*
    VIP客户查询
     */
    public VIPEntity queryVip(String code) throws Exception;

    /*
    VIP客户录入
     */
    @Transactional
    public VIPEntity addVip(VIPAo ao) throws Exception;
}
