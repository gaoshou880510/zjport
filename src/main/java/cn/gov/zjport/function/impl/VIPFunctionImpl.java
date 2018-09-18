package cn.gov.zjport.function.impl;

import cn.gov.zjport.common.ThisSystemException;
import cn.gov.zjport.common.ThisSystemUtil;
import cn.gov.zjport.dao.VIPDao;
import cn.gov.zjport.entity.VIPEntity;
import cn.gov.zjport.function.VIPFunction;
import cn.gov.zjport.web.vo.VIPAo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static cn.gov.zjport.common.ThisSystemUtil.*;

//业务层对象
@Service
public class VIPFunctionImpl implements VIPFunction {

    @Autowired
    VIPDao vdao;

    @Override
    public VIPEntity queryVip(String code) throws Exception {
        //1验证参数
        code=$("vip账号必须填写",code);
        //2业务处理
        VIPEntity v = vdao.select("code",code);
        if(v==null){
            throw new ThisSystemException("未找到此VIP客户["+code+"]");
        }

        //3封装业务结果

        return v;
    }

    @Override
    public VIPEntity addVip(VIPAo ao) throws Exception {
        //1验证参数
        if(ao==null){
            throw new IllegalArgumentException("ao不能为空");
        }
        //1.1验证是否必须输入字段
        String phone = $("手机号码必须填写",ao.getPhone());
        String name = $("姓名必须填写",ao.getName());

        //1.2验证手机号是否合法
        assertPatterMatch("手机号码不合法","\\d{11}",phone);

        //1.3验证手机号码是否已存在
        assertFalse("手机号已存在",vdao.exsits("code",phone));

        //1.4验证名字是否合法
        assertPatterMatch("姓名不合法","[\u4e00-\u9fa5]{2,}",name);

        //1.5获取性别
        boolean male = "1".equals(ao.getSex());

        //1.6获取年龄
        int age = ThisSystemUtil.parseInt(ao.getAge(),0);

        //2业务处理
        VIPEntity v = new VIPEntity();
        v.setId(uuid());
        v.setAddress(ao.getAddress());
        v.setAge(age);
        v.setAmount(0);
        v.setCode(phone);
        v.setEmail(ao.getEmail());
        v.setMale(male);
        v.setQq(ao.getQq());
        v.setName(name);
        v.setRank(0);
        v.setRemark(ao.getRemark());
        v.setZip(ao.getZip());
        vdao.insert(v);

        //3封装业务
        // 结果

        return v;
    }
}
