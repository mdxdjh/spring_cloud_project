package com.ellis.pay.component;

import com.alibaba.fastjson.JSON;
import com.ellis.common.service.common.OrderType;
import com.ellis.common.service.common.PayStatus;
import com.ellis.common.service.exception.BusinessException;
import com.ellis.pay.dal.db.*;
import com.ellis.pay.service.entity.PayNotify;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 支付服务管理类
 *
 * @author ellis.luo
 * @date 2016年6月29日 下午3:48:32
 */
@Component("payManager")
public class PayManager
{
    protected org.slf4j.Logger Logger = LoggerFactory.getLogger(PayManager.class);

//    @Autowired
    private PayLogInfoPoMapper payLogMapper;

//    @Autowired
    private IphonePayLogPoMapper iphonePayLogManager;

    @Async
    public void addPayLog(PayLogInfoPo payLogInfoPo)
    {
        payLogMapper.insert(payLogInfoPo);
    }

    public PayLogInfoPo queryPayLog(String tradeNo)
    {
        PayLogInfoPo po = null;
        // 从DB查询数据
        PayLogInfoPoExample example = new PayLogInfoPoExample();
        example.createCriteria().andTradeNoEqualTo(tradeNo);
        List<PayLogInfoPo> payLogs = payLogMapper.selectByExample(example);
        if (payLogs.size() == 0 || payLogs == null)
        {
            return po;
        }
        po = payLogs.get(0);

        return po;
    }

    public PayLogInfoPo queryPayLogByOrderNo(String orderNo)
    {
        PayLogInfoPo po = null;
        // 从DB查询数据
        PayLogInfoPoExample example = new PayLogInfoPoExample();
        example.createCriteria().andOrderNoEqualTo(orderNo);
        List<PayLogInfoPo> payLogs = payLogMapper.selectByExample(example);
        if (payLogs.size() == 0 || payLogs == null)
        {
            return po;
        }
        po = payLogs.get(0);

        return po;
    }

    public int updatePayLogByTradeNo(PayLogInfoPo payLogInfoPo)
    {
        PayLogInfoPoExample example = new PayLogInfoPoExample();
        example.createCriteria().andTradeNoEqualTo(payLogInfoPo.getTradeNo());
        return payLogMapper.updateByExampleSelective(payLogInfoPo, example);
    }

    public void recordPayLog(PayStatus payStatus, OrderType orderType, PayNotify payNotify)
    {
        PayLogInfoPo payLog = queryPayLog(payNotify.getTradeNo());
        boolean isPayLogExists = (payLog == null ? false : true);

        if (!isPayLogExists)
        {
            payLog = new PayLogInfoPo();
            assemblePayLog(payLog, orderType, payNotify);
        }
        payLog.setTradeNo(payNotify.getTradeNo());
        payLog.setPayTime(payNotify.getPayTime());
        payLog.setPayStatus((byte) payStatus.getKey());
        payLog.setRemark(payNotify.getRemark());

        if (!isPayLogExists)
        {
            Logger.debug("添加流水日志 {}", JSON.toJSONString(payLog));
            addPayLog(payLog);
        }
        else
        {
            Logger.debug("更新流水日志 {}", JSON.toJSONString(payLog));
            updatePayLogByTradeNo(payLog);
        }
    }

    private void assemblePayLog(PayLogInfoPo payLog, OrderType orderType, PayNotify payNotify)
    {
        /** 记录流水日志 **/
        payLog.setOrderNo(payNotify.getOrderNo());
        payLog.setPayAmount(payNotify.getPayAmount());
        payLog.setPayChannel((byte) payNotify.getPayChannel().getKey());
        payLog.setPayAcct(payNotify.getPayAcct());
        payLog.setUid(payNotify.getUid());
        payLog.setLastNotifyTime(new Date());
    }

    public IphonePayLogPo queryIphonePayLogByReceipt(String receipt)
    {
        IphonePayLogPo po = null;
        // 从DB查询数据
        IphonePayLogPoExample example = new IphonePayLogPoExample();
        example.createCriteria().andReceiptEqualTo(receipt);
        List<IphonePayLogPo> iphonePayLogs = iphonePayLogManager.selectByExample(example);
        if (iphonePayLogs.size() == 0 || iphonePayLogs == null)
        {
            return po;
        }
        po = iphonePayLogs.get(0);

        return po;
    }

    public void addIosPayLog(IphonePayLogPo iphonePayLogPo)
    {
        iphonePayLogManager.insert(iphonePayLogPo);
    }

}
