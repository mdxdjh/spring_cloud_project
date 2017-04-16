//package com.ellis.pay.component;
//
//import com.ellis.common.service.common.PayChannel;
//import com.ellis.pay.dal.db.MerAcctInfoPo;
//import com.ellis.pay.dal.db.MerAcctInfoPoExample;
//import com.ellis.pay.dal.db.MerAcctInfoPoKey;
//import com.ellis.pay.dal.db.MerAcctInfoPoMapper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @author ellis.luo
// * @date 16/12/1 上午10:59
// * @description 支付客户账户管理类
// */
//@Component("merAcctManager")
//public class MerAcctManager
//{
//    private Logger logger = LoggerFactory.getLogger(MerAcctManager.class);
//
//    @Autowired
//    private MerAcctInfoPoMapper merAcctMapper;
//
//    private Map<String, Map<Integer, MerAcctInfoPo>> merAccts;
//
//    @PostConstruct
//    public void load()
//    {
//        logger.info("init MerAcct begin");
//        MerAcctInfoPoExample example = new MerAcctInfoPoExample();
//        List<MerAcctInfoPo> merAcctList = merAcctMapper.selectByExample(example);
//        if (merAcctList.size() > 0 && merAcctList != null)
//        {
//            Map<String, Map<Integer, MerAcctInfoPo>> temp = new HashMap<String, Map<Integer, MerAcctInfoPo>>();
//            Map<Integer, MerAcctInfoPo> merAcct = new HashMap<Integer, MerAcctInfoPo>();
//            for (MerAcctInfoPo merAcctPo : merAcctList)
//            {
//                merAcct.put(merAcctPo.getPayChannel().intValue(), merAcctPo);
//            }
//            temp.put(merAcctList.get(0).getMerId(), merAcct);
//            merAccts = temp;
//        }
//
//        logger.info("init MerAcct end , merAccts:{}", merAccts);
//    }
//
//    public MerAcctInfoPo getMerAcct(String merId, PayChannel payChannel)
//    {
//        logger.info("getMerAcct, merId :{}, payChannel :{}", merId, payChannel);
//        Map<Integer, MerAcctInfoPo> merAcct = merAccts.get(merId);
//        if (merAcct == null || merAcct.get(payChannel.getKey()) == null)
//        {
//            reload(merId, payChannel);
//            return merAccts.get(merId).get(payChannel.getKey());
//        }
//        else
//        {
//            return merAcct.get(payChannel.getKey());
//        }
//    }
//
//    public void reload()
//    {
//        logger.info("reload MerAcct");
//        load();
//    }
//
//    public void reload(String merId, PayChannel payChannel)
//    {
//        MerAcctInfoPoKey key = new MerAcctInfoPoKey();
//        key.setMerId(merId);
//        key.setPayChannel((byte) payChannel.getKey());
//        MerAcctInfoPo merAcctPo = merAcctMapper.selectByPrimaryKey(key);
//
//        if (merAcctPo != null)
//        {
//            Map<Integer, MerAcctInfoPo> merAcct = new HashMap<Integer, MerAcctInfoPo>();
//            merAcct.put(payChannel.getKey(), merAcctPo);
//            merAccts.put(merId, merAcct);
//        }
//    }
//}
