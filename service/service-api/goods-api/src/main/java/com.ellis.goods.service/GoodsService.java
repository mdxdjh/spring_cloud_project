package com.ellis.goods.service;

import com.ellis.common.service.exception.BusinessException;
import com.ellis.goods.service.entity.GoodsInfo;
import com.ellis.goods.service.exception.GoodsException;

/**
 * @author ellis.luo
 * @date 16/11/19 下午10:40
 * @description
 */
public interface GoodsService
{
    /**
     * 通过商品号查询商品信息
     * 
     * @param goodsId
     * @throws GoodsException
     */
    public GoodsInfo queryGoodsById(int goodsId) throws BusinessException;

}
