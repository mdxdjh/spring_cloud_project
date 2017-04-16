//package com.ellis.pay.utils.ali.sign;
//
//import com.ellis.common.service.common.OrderSource;
//import com.ellis.common.service.common.PayChannel;
//import com.ellis.pay.dal.db.MerAcctInfoPo;
//import com.ellis.pay.service.common.ErrorCodeConst;
//import com.ellis.pay.service.exception.PayException;
//import com.ellis.commons.crypto.MD5Coding;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.UnsupportedEncodingException;
//import java.net.URLEncoder;
//import java.util.*;
//
///**
// * @author ellis.luo
// * @date 2016年7月3日 上午11:02:28
// */
//public class PayUtils
//{
//    private static org.slf4j.Logger Logger = LoggerFactory.getLogger(PayUtils.class);
//
//    private static final String ENCODE = "utf-8";
//
//    /** 获取拼接URL **/
//    public static String getSpliceUrl(Map<String, String> reqParams)
//    {
//        StringBuilder sign = new StringBuilder();
//        Iterator<String> iter = reqParams.keySet().iterator();
//        while (iter.hasNext())
//        {
//            String key = iter.next();
//            String value = reqParams.get(key);
//            if (key.equals("sign") || key.equals("sign_type"))
//            {
//                continue;
//            }
//            sign.append(key).append("=\"").append(value).append("\"&");
//        }
//
//        sign.setLength(sign.length() - 1);
//        return sign.toString();
//    }
//
//    /** 生成32位的随机字符串 **/
//    public static String getNonceStr()
//    {
//        Random random = new Random();
//        return MD5Coding.encodeForWx(random.nextInt(10000) + "");
//    }
//
//    /** 生成微信支付签名 **/
//    public static String getWeixinSign(Map<String, String> reqParams, String signKey)
//    {
//        StringBuilder sign = new StringBuilder();
//        String url = getSpliceUrl(reqParams);
//        sign.append(url).append("key=").append(signKey);
//        return MD5Coding.encodeForWx(sign.toString()).toUpperCase();
//    }
//
//    /** 生成支付宝支付签名 **/
//    public static String getAliSign(String signStr, String privateKey, String encode)
//    {
//        String sign = RSA.sign(signStr, privateKey, encode);
//        Logger.info("sign:{} ", sign);
//        try
//        {
//            sign = URLEncoder.encode(sign, encode);
//        }
//        catch (UnsupportedEncodingException e)
//        {
//            throw new PayException(ErrorCodeConst.SIGN_ENCODE_ERROR);
//        }
//
//        return sign;
//    }
//
//    /** 生成微博支付签名 **/
//    public static String getWeiboVerifySign(String signStr, String privateKey, String encode)
//    {
//        String sign = RSA.sign(signStr, privateKey, encode);
//
//        return sign;
//    }
//
//    public static String encode(String str)
//    {
//        try
//        {
//            str = URLEncoder.encode(str, "UTF-8");
//        }
//        catch (UnsupportedEncodingException e)
//        {
//            Logger.error("encode error str:{}", str);
//        }
//
//        return str;
//    }
//
//    /**
//     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
//     *
//     * @param params
//     *        需要排序并参与字符拼接的参数组
//     * @param withDoubleQuotation
//     *        是否带双引号
//     * @return 拼接后字符串
//     */
//    public static String getSignData(Map<String, String> params, boolean withDoubleQuotation)
//    {
//
//        List<String> keys = new ArrayList<String>(params.keySet());
//        Collections.sort(keys);
//
//        String prestr = "";
//
//        for (int i = 0; i < keys.size(); i++)
//        {
//            String key = keys.get(i);
//            String value = params.get(key);
//            if (key.equals("sign") || key.equals("sign_type") || value == null || value.equals(""))
//            {
//                continue;
//            }
//
//            if (withDoubleQuotation)
//            {
//                prestr = prestr + key + "=\"" + value + "\"&";
//            }
//            else
//            {
//                prestr = prestr + key + "=" + value + "&";
//            }
//        }
//
//        prestr = prestr.substring(0, prestr.length() - 1);
//
//        return prestr;
//    }
//
//    /**
//     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
//     *
//     * @param params
//     *        需要排序并参与字符拼接的参数组
//     * @param withDoubleQuotation
//     *        是否带双引号
//     * @return 拼接后字符串
//     */
//    public static String getWebSignData(Map<String, String> params, boolean withDoubleQuotation)
//    {
//
//        List<String> keys = new ArrayList<String>(params.keySet());
//        Collections.sort(keys);
//
//        String prestr = "";
//
//        for (int i = 0; i < keys.size(); i++)
//        {
//            String key = keys.get(i);
//            String value = params.get(key);
//            if (key.equals("sign") || value == null || value.equals(""))
//            {
//                continue;
//            }
//
//            if (withDoubleQuotation)
//            {
//                prestr = prestr + key + "=\"" + value + "\"&";
//            }
//            else
//            {
//                prestr = prestr + key + "=" + value + "&";
//            }
//        }
//
//        prestr = prestr.substring(0, prestr.length() - 1);
//
//        return prestr;
//    }
//
//    /**
//     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
//     *
//     * @param params
//     *        需要排序并参与字符拼接的参数组
//     * @param withDoubleQuotation
//     *        是否带双引号
//     * @return 拼接后字符串
//     */
//    public static String getWeiboSDKSignData(Map<String, String> params, boolean withDoubleQuotation)
//    {
//
//        List<String> keys = new ArrayList<String>(params.keySet());
//        Collections.sort(keys);
//
//        String prestr = "";
//
//        for (int i = 0; i < keys.size(); i++)
//        {
//            String key = keys.get(i);
//            String value = params.get(key);
//            if (key.equals("sign") || key.equals("sign_type") || value == null || value.equals(""))
//            {
//                continue;
//            }
//
//            if (withDoubleQuotation)
//            {
//                prestr = prestr + key + "=\"" + value + "\"&";
//            }
//            else
//            {
//                prestr = prestr + key + "=" + value + "&";
//            }
//        }
//
//        prestr = prestr.substring(0, prestr.length() - 1);
//
//        return prestr;
//    }
//
//    /**
//     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
//     *
//     * @param params
//     *        需要排序并参与字符拼接的参数组
//     * @param withDoubleQuotation
//     *        是否带双引号
//     * @return 拼接后字符串
//     */
//    public static String getWeiboSignData(Map<String, String> params, boolean withDoubleQuotation)
//    {
//
//        List<String> keys = new ArrayList<String>(params.keySet());
//        Collections.sort(keys);
//
//        String prestr = "";
//
//        for (int i = 0; i < keys.size(); i++)
//        {
//            String key = keys.get(i);
//            String value = params.get(key);
//            if (value == null || value.equals(""))
//            {
//                continue;
//            }
//
//            if (withDoubleQuotation)
//            {
//                prestr = prestr + key + "=\"" + value + "\"&";
//            }
//            else
//            {
//                prestr = prestr + key + "=" + value + "&";
//            }
//        }
//
//        prestr = prestr.substring(0, prestr.length() - 1);
//
//        return prestr;
//    }
//
//    public static PayChannel getPayChannel(OrderSource orderSource)
//    {
//        PayChannel channel = PayChannel.UN_KNOWN;
//        if (orderSource.equals(OrderSource.ANDROID))
//        {
//            channel = PayChannel.ALI_APP_PAY;
//        }
//        else if (orderSource.equals(OrderSource.IOS))
//        {
//            channel = PayChannel.ALI_IOS_PAY;
//        }
//
//        return channel;
//    }
//
//    /**
//     * 除去数组中的空值和签名参数
//     *
//     * @param sArray
//     *        签名参数组
//     * @return 去掉空值与签名参数后的新签名参数组
//     */
//    public static Map<String, String> paraFilter(Map<String, String> sArray)
//    {
//
//        Map<String, String> result = new HashMap<String, String>();
//
//        if (sArray == null || sArray.size() <= 0)
//        {
//            return result;
//        }
//
//        for (String key : sArray.keySet())
//        {
//            String value = sArray.get(key);
//            if (value == null || value.equals("") || key.equalsIgnoreCase("sign") || key.equalsIgnoreCase("sign_type"))
//            {
//                continue;
//            }
//            result.put(key, value);
//        }
//
//        return result;
//    }
//
//    /**
//     * 生成签名结果
//     *
//     * @param sPara
//     *        要签名的数组
//     * @return 签名结果字符串
//     */
//    public static String buildRequestMysign(String signType, MerAcctInfoPo acct, Map<String, String> sPara)
//    {
//        String prestr = createLinkString(sPara); // 把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
//        String mysign = "";
//        if (signType.equals("RSA"))
//        {
//            mysign = RSA.sign(prestr, acct.getPrivateKeyPwd(), ENCODE);
//        }
//        return mysign;
//    }
//
//    /**
//     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
//     *
//     * @param params
//     *        需要排序并参与字符拼接的参数组
//     * @return 拼接后字符串
//     */
//    public static String createLinkString(Map<String, String> params)
//    {
//
//        List<String> keys = new ArrayList<String>(params.keySet());
//        Collections.sort(keys);
//
//        String prestr = "";
//
//        for (int i = 0; i < keys.size(); i++)
//        {
//            String key = keys.get(i);
//            String value = params.get(key);
//
//            if (i == keys.size() - 1)
//            {// 拼接时，不包括最后一个&字符
//                prestr = prestr + key + "=" + value;
//            }
//            else
//            {
//                prestr = prestr + key + "=" + value + "&";
//            }
//        }
//
//        return prestr;
//    }
//
//}
