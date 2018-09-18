package cn.gov.zjport.function.impl;

import cn.gov.zjport.common.ThisSystemException;
import static cn.gov.zjport.common.ThisSystemUtil.*;

import cn.gov.zjport.common.ThisSystemUtil;
import cn.gov.zjport.dao.UserDao;
import cn.gov.zjport.entity.UserEntity;
import cn.gov.zjport.function.UserFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserFunctionImpl implements UserFunction {

    @Autowired
    UserDao dao;


    @Override
    public UserEntity login(String account, String password) throws Exception {

        account = $("账号不能为空！",account);
        password = $("密码不能为空！",password);

        UserEntity u = dao.select("account",account);
        if(u==null){
            throw new ThisSystemException("账号不存在");
        }

        password = ThisSystemUtil.md5(password);
        if(!u.getPassword().equals(password)){
            throw new ThisSystemException("密码错误");
        }

        return u;
    }

    @Override
    public UserEntity updatePassword(String id, String oldPassword, String newPassword, String newPasswordConfirm) throws Exception {
        //1.验证参数
        id=$("id不能为空",id);
        oldPassword=$("旧密码必须填写",oldPassword);
        newPassword=$("新密码必须填写",newPassword);
        newPasswordConfirm=$("新密码必须确认填写",newPasswordConfirm);
        assertEquals("两次密码不一致",newPassword,newPasswordConfirm);
        assertNotEquals("新密码和旧密码不能一样",oldPassword,newPassword);
        //2.找到用户
        UserEntity u = dao.select("id",id);
        assertNotNull("无法找到用户",u);
        oldPassword = ThisSystemUtil.md5(oldPassword);
        //3.验证旧密码
        assertEquals("旧密码不正确",u.getPassword(),oldPassword);
        //4更新密码
        newPassword = ThisSystemUtil.md5(newPassword);
        u.setPassword(newPassword);
        dao.update(u);

        return u;
    }


}
