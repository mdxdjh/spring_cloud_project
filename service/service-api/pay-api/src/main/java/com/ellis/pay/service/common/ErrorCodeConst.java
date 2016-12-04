package com.ellis.pay.service.common;

import com.ellis.common.service.exception.BaseErrorCode;

/**
 * @author ellis.luo
 * @date 16/11/22 上午12:17
 * @description 支付错误 3000 ~ 4000
 */
public class ErrorCodeConst
{
    public static final BaseErrorCode ORDER_IS_NULL = new BaseErrorCode(3001, "订单信息为空");
    public static final BaseErrorCode PAY_CHANNEL_ERROR = new BaseErrorCode(3002, "暂不支持此种支付方式");
    public static final BaseErrorCode GET_PAY_NOTIFY_HANDLER_ERROR = new BaseErrorCode(3004, "获取支付回调处理器失败");
    public static final BaseErrorCode MER_ACCT_CHANNEL_NOT_EXISTS = new BaseErrorCode(3007, "客户支付渠道不存在");
    public static final BaseErrorCode UPD_ACCT_BALANCE_ERROR = new BaseErrorCode(3008, "更新账户金币钻石异常");
    public static final BaseErrorCode GIFT_IS_NOT_EXISTS = new BaseErrorCode(3009, "礼物不存在");
    public static final BaseErrorCode SIGN_ENCODE_ERROR = new BaseErrorCode(3010, "签名encode失败");
    public static final BaseErrorCode PAY_ERROR = new BaseErrorCode(3011, "支付失败");
    public static final BaseErrorCode PAY_NOTIFY_ORDER_LOCK_FAIL = new BaseErrorCode(3012, "支付回调锁订单失败");
    public static final BaseErrorCode CHECK_WAIT_PAY_ORDER_LOCK_FAIL = new BaseErrorCode(3013, "待处理订单获取锁失败");
    public static final BaseErrorCode GET_PAY_QUERY_HANDLER_ERROR = new BaseErrorCode(3014, "获取支付查询处理器失败");
    public static final BaseErrorCode PAY_LOG_NOT_EXIST = new BaseErrorCode(3015, "支付流水日志不存在");
    public static final BaseErrorCode GET_REFUND_HANDLER_ERROR = new BaseErrorCode(3016, "获取退款处理器失败");
    public static final BaseErrorCode GET_REFUND_NOTIFY_HANDLER_ERROR = new BaseErrorCode(3017, "获取退款回调处理器失败");
}
