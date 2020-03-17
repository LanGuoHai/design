package com.yunduo.service.serviceImp;

import com.yunduo.bean.AddPraiseInfoReq;
import com.yunduo.dao.PraisepowerMapper;
import com.yunduo.entities.Praisepower;
import com.yunduo.service.PraisePowerService;
import com.yunduo.utils.CloneUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PraisePowerServiceImp  implements PraisePowerService {

    @Autowired
    PraisepowerMapper praisepowerMapper;
    @Override
    public Integer addPraiseInfo(AddPraiseInfoReq model) {
        Praisepower praisepower= CloneUtil.cloneObj(model,Praisepower.class);
        Praisepower result=praisepowerMapper.selectByShareIdAndPersonId(praisepower);
        if(result==null){
            praisepowerMapper.insertSelective(praisepower);
            //点赞成功
            return 1;
        }else{
            //取消点赞
            praisepowerMapper.deleteByPrimaryKey(result.getId());
            return 2;
        }
    }
}
