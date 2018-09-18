package cn.gov.zjport.dao;

import cn.gov.zjport.entity.VipRankEntity;

import java.util.List;

public interface VIPRankDao {
    List<VipRankEntity> selectAll() throws Exception;
}
