package com.ellis.goods.dal.db.convert;

import com.ellis.goods.dal.db.GoodsInfoPo;
import com.ellis.goods.service.entity.GoodsInfo;

/**
 * @author ellis.luo
 * @date 16/11/21 下午6:55
 * @description
 */
public class GoodsConvertUtil
{
    public static GoodsInfoPo info2Po(GoodsInfo goodsInfo)
    {
        GoodsInfoPo po = new GoodsInfoPo();
        po.setStatus(goodsInfo.getStatus());
        po.setEndTime(goodsInfo.getEndTime());
        po.setStartTime(goodsInfo.getStartTime());
        po.setId(goodsInfo.getId());
        po.setRemark(goodsInfo.getRemark());
        po.setName(goodsInfo.getName());
        po.setPrice(goodsInfo.getPrice());
        po.setType(goodsInfo.getType());
        return po;
    }

    public static GoodsInfo po2Info(GoodsInfoPo po)
    {
        GoodsInfo info = new GoodsInfo();
        info.setStatus(po.getStatus());
        info.setEndTime(po.getEndTime());
        info.setStartTime(po.getStartTime());
        info.setId(po.getId());
        info.setRemark(po.getRemark());
        info.setName(po.getName());
        info.setPrice(po.getPrice());
        info.setType(po.getType());
        return info;
    }
}
