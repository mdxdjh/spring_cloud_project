package com.ellis.order.service;

import com.ellis.common.service.exception.BusinessException;
import com.ellis.order.service.entity.OrderInfo;
import com.ellis.order.service.exception.OrderException;

/**
 * @author ellis.luo
 * @date 16/11/19 下午10:40
 * @description
 */
public interface OrderService
{
    /** 创建订单 **/
    public OrderInfo createOrder(OrderInfo orderInfo) throws BusinessException;

    /** 根据orderNo查询订单 **/
    public OrderInfo queryOrderInfo(String orderNo) throws BusinessException;


}
