///**
// *
// */
//package com.ellis.web.controller;
//
//import com.alibaba.fastjson.JSON;
//import com.ellis.common.service.common.PayChannel;
//import com.ellis.pay.service.PayService;
//import com.ellis.pay.service.entity.PayNotify;
//import com.ellis.pay.service.exception.PayException;
//import com.ellis.web.BaseController;
//import com.ellis.web.FrameResp;
//import com.ellis.web.util.RequestParamUtil;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.Map;
//
///**
// * @author ellis.luo
// * @date 16/11/18 上午12:35
// * @description
// */
//@Controller
//@RequestMapping(value = "{version}/pay")
//public class PayController extends BaseController
//{
//    private org.slf4j.Logger Logger = LoggerFactory.getLogger(PayController.class);
//
//    @Autowired
//    private PayService payService;
//
//    /**
//     * 移动支付－支付宝回调
//     */
//    @RequestMapping(value = "/aliAppCallBack", method = RequestMethod.POST)
//    @ResponseBody
//    public FrameResp aliAppCallBack() throws PayException
//    {
//        Map<String, String> reqParams = RequestParamUtil.extractRequestParams(getRequest());
//        Logger.info("支付宝APP回调入参： " + JSON.toJSONString(reqParams));
//
//        PayNotify payNotify = new PayNotify();
//        payNotify.setReqParams(reqParams);
//
//        String result = payService.payNotify(payNotify);
//        Logger.info("支付宝APP反馈结果，result:{}", result);
//
//        try
//        {
//            PrintWriter out = getResponse().getWriter();
//            out.print(result);
//            out.flush();
//            out.close();
//        }
//        catch (IOException e)
//        {
//            Logger.error("支付宝App回调反馈失败! orderNo:{}", reqParams.get("out_trade_no"));
//        }
//
//        return null;
//    }
//
//}
