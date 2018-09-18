package cn.gov.zjport.handler;

import cn.gov.zjport.entity.VipRankEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public abstract class AbstractHandler {
    public VipRankEntity getRank(HttpServletRequest req, int rank){
        //RANKS-MAP
        Map<Integer,VipRankEntity> rankMap = (Map<Integer, VipRankEntity>) req.getServletContext().getAttribute("RANKS-MAP");


        return rankMap.get(rank);
    }
}
