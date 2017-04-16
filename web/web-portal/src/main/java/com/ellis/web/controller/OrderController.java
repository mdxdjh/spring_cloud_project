//package com.ellis.web.controller;
//
//import com.ellis.common.service.common.CurrencyType;
//import com.ellis.common.service.common.OrderSource;
//import com.ellis.common.service.common.OrderType;
//import com.ellis.common.service.common.PayChannel;
//import com.ellis.order.service.OrderService;
//import com.ellis.order.service.entity.OrderInfo;
//import com.ellis.order.service.exception.OrderException;
//import com.ellis.pay.service.PayService;
//import com.ellis.pay.service.entity.PayInfo;
//import com.ellis.pay.service.entity.PayMessage;
//import com.ellis.web.BaseController;
//import com.ellis.web.FrameResp;
//import com.ellis.web.common.RequiredLogin;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author ellis.luo
// * @date 16/11/18 上午12:35
// * @description
// */
//@RestController
//@RequestMapping("/order")
//public class OrderController extends BaseController
//{
//    private Logger logger = LoggerFactory.getLogger(OrderController.class);
//
//    @Autowired
//    private OrderService orderService;
//
//    @Autowired
//    private PayService payService;
//
//    @RequiredLogin
//    @RequestMapping(value = "/createOrder", method = RequestMethod.POST)
//    public FrameResp createOrder(@Validated OrderInfo order, BindingResult result) throws OrderException
//    {
//        checkParams(result);
//
//        logger.info("OrderController createOrder begin, orderInfo:{}", order);
//
//        order.setUid(getLoginUid());
//
//        order = orderService.createOrder(order);
//
//        PayInfo payInfo = assemblePay(order);
//
//        PayMessage payMessage = payService.toPay(payInfo);
//        order.setPayMessage(payMessage);
//
//        return successResp(order);
//    }
//
//    // 集成去支付的数据
//    private PayInfo assemblePay(OrderInfo order)
//    {
//        logger.info("order assemblePay :{}", order);
//        PayInfo pay = new PayInfo();
//        pay.setPayChannel(PayChannel.get(order.getChannel()));
//        pay.setOrderNo(order.getOrderNo());
//        pay.setGoodsName(order.getGoodsName() == null ? null : order.getGoodsName());
//        pay.setGoodsId(order.getGoodsId());
//        pay.setUid(order.getUid());
//        pay.setOrderType(OrderType.get(order.getOrderType()));
//        pay.setCurrencyType(CurrencyType.get(order.getCurrencyType()));
//        pay.setSource(OrderSource.get(order.getSource()));
//        pay.setAmount(order.getAmount());
//        pay.setReceipt(order.getReceipt());
//
//        return pay;
//    }
//
//}
