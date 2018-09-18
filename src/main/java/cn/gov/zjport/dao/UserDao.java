package cn.gov.zjport.dao;

import cn.gov.zjport.common.AbstractDao;
import cn.gov.zjport.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

public interface UserDao extends AbstractDao<UserEntity> {
    //public UserEntity selectByAccount(@Param("account") String account) throws  Exception;
}
