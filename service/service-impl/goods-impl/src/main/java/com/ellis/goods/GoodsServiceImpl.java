package com.ellis.goods;

import com.ellis.common.service.exception.BusinessException;
import com.ellis.goods.dal.db.GoodsInfoPo;
import com.ellis.goods.dal.db.GoodsInfoPoMapper;
import com.ellis.goods.dal.db.convert.GoodsConvertUtil;
import com.ellis.goods.service.GoodsService;
import com.ellis.goods.service.common.ErrorCodeConst;
import com.ellis.goods.service.entity.GoodsInfo;
import com.ellis.goods.service.exception.GoodsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ellis.luo
 * @date 16/11/20 上午8:18
 * @description
 */
public class GoodsServiceImpl implements GoodsService
{
    private Logger logger = LoggerFactory.getLogger(GoodsServiceImpl.class);

    @Autowired
    private GoodsInfoPoMapper goodsInfoPoMapper;

    @Override
    public GoodsInfo queryGoodsById(int goodsId) throws BusinessException
    {
        GoodsInfoPo po = goodsInfoPoMapper.selectByPrimaryKey(goodsId);

        if (po == null)
        {
            logger.error("goods is null. goodsId:{}", goodsId);
            throw new GoodsException(ErrorCodeConst.GOODS_NOT_EXISTS);
        }

        GoodsInfo goods = GoodsConvertUtil.po2Info(po);

        return goods;
    }
}
