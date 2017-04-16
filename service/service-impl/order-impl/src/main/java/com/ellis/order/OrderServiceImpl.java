package com.ellis.order;

import com.alibaba.fastjson.JSON;
import com.ellis.common.service.common.OrderStatus;
import com.ellis.common.service.exception.BusinessException;
//import com.ellis.commons.utils.OrderGenerUtil;
import com.ellis.goods.service.GoodsService;
import com.ellis.goods.service.entity.GoodsInfo;
import com.ellis.order.dal.db.OrderInfoPo;
import com.ellis.order.dal.db.OrderInfoPoMapper;
import com.ellis.order.dal.db.convert.OrderConvertUtil;
import com.ellis.order.service.OrderService;
import com.ellis.order.service.entity.OrderInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author ellis.luo
 * @date 16/11/20 上午8:18
 * @description
 */
public class OrderServiceImpl implements OrderService
{
    private Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderInfoPoMapper orderInfoPoMapper;

    @Autowired
    private GoodsService goodsService;

    @Override
    public OrderInfo createOrder(OrderInfo orderInfo) throws BusinessException
    {
        logger.info("创建订单请求 = {}", JSON.toJSONString(orderInfo));

        orderInfo = assembleOrder(orderInfo);
        OrderInfoPo po = OrderConvertUtil.info2Po(orderInfo);
        orderInfoPoMapper.insert(po);

        return OrderConvertUtil.po2Info(po);
    }

    @Override
    public OrderInfo queryOrderInfo(String orderNo) throws BusinessException
    {
        return null;
    }

    private OrderInfo assembleOrder(OrderInfo orderInfo)
    {
        String orderNo = "";

        GoodsInfo goods = goodsService.queryGoodsById(orderInfo.getGoodsId());

        orderInfo.setGoodsType(goods.getType());
        orderInfo.setAmount(goods.getPrice());
        orderInfo.setGoodsName(goods.getName());
        orderInfo.setOrderNo(orderNo);
        orderInfo.setStatus(OrderStatus.WAIT_DEAL.getKey());
        orderInfo.setCreateTime(new Date());
        orderInfo.setDeleted(false);

        return orderInfo;
    }
}
