package cn.gov.zjport.function;

import cn.gov.zjport.entity.UserEntity;
import org.springframework.transaction.annotation.Transactional;

public interface UserFunction {
    public UserEntity login(String account,String password) throws Exception;
    //事务管理配置
    @Transactional
    public UserEntity updatePassword(String id,String oldPassword,String newPassword,String newPasswordConfirm)throws Exception;
}
