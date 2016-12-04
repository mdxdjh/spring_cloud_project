package com.ellis.order.dal.db.convert;

import com.ellis.order.dal.db.OrderInfoPo;
import com.ellis.order.service.entity.OrderInfo;

/**
 * @author ellis.luo
 * @date 16/11/21 下午6:55
 * @description
 */
public class OrderConvertUtil
{
    public static OrderInfoPo info2Po(OrderInfo userInfo)
    {
        OrderInfoPo po = new OrderInfoPo();
        po.setAmount(userInfo.getAmount());
        po.setChannel(userInfo.getChannel());
        po.setCreateTime(userInfo.getCreateTime());
        po.setCurrencyType(userInfo.getCurrencyType().byteValue());
        po.setDeleted(userInfo.getDeleted());
        po.setGoodsId(userInfo.getGoodsId());
        po.setGoodsType(userInfo.getGoodsType());
        po.setOrderNo(userInfo.getOrderNo());
        po.setOrderType(userInfo.getOrderType().byteValue());
        po.setStatus(userInfo.getStatus().byteValue());
        po.setUid(userInfo.getUid());
        po.setSource(userInfo.getSource().byteValue());

        return po;
    }

    public static OrderInfo po2Info(OrderInfoPo po)
    {
        OrderInfo info = new OrderInfo();
        info.setAmount(po.getAmount());
        info.setChannel(po.getChannel());
        info.setCreateTime(po.getCreateTime());
        info.setCurrencyType(po.getCurrencyType().intValue());
        info.setDeleted(po.getDeleted());
        info.setGoodsId(po.getGoodsId());
        info.setGoodsType(po.getGoodsType());
        info.setOrderNo(po.getOrderNo());
        info.setOrderType(po.getOrderType().intValue());
        info.setStatus(po.getStatus().intValue());
        info.setUid(po.getUid());
        info.setSource(po.getSource().intValue());

        return info;
    }
}
