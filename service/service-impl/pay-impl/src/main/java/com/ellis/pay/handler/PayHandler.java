package com.ellis.pay.handler;

import com.ellis.pay.dal.db.MerAcctInfoPo;
import com.ellis.pay.entity.PayOrder;
import com.ellis.pay.service.entity.PayMessage;

/**
 * 支付处理器
 * 
 * @author ellis.luo
 * @date 2016年6月30日 下午8:08:04
 */
public interface PayHandler
{
    PayMessage getPayMessage(PayOrder payOrder, MerAcctInfoPo acct);
}
