package com.ellis.pay.common;

/**
 * @author ellis.luo
 * @date 16/12/1 上午11:01
 * @description
 */
public class PayConfig
{
    // 字符编码
    public static String encode = "utf-8";

    // 红人说APP_ID
    public static String appId = "2088102168994734";

    // 客户id
    public static String merId = "ellis";

    /** ＝＝＝＝＝＝＝＝＝ iphone ＝＝＝＝＝＝＝＝＝ **/
    // ios验证url (测试的时候用sandbox，生产用buy)
    public static String iosVerifyUrl = "https://buy.itunes.apple.com/verifyReceipt";

    public static String iosSandboxVerifyUrl = "https://sandbox.itunes.apple.com/verifyReceipt";

    /** ＝＝＝＝＝＝＝＝＝ 支付宝 ＝＝＝＝＝＝＝＝＝ **/

    // 支付宝Android请求url
//    public static String aliAppReqUrl = "https://mapi.alipay.com/gateway.do";
    public static String aliAppReqUrl = "https://openapi.alipay.com/gateway.do";

    // 支付宝支付回调url
    public static String aliAppNotifyUrl = "http://101.200.196.99:19080/v1/pay/aliAppCallBack";
    // 支付宝Android验证url
    public static String aliAppVerifyUrl = "https://mapi.alipay.com/gateway.do?service=notify_verify&";
    // 支付宝退款回调url
    public static String aliAppRefundNotifyUrl = "http://101.200.196.99:19080/v1/pay/aliAppRefundCallBack";

}
