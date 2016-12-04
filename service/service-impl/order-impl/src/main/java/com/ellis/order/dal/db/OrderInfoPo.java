package com.ellis.order.dal.db;

import java.util.Date;

public class OrderInfoPo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.id
     *
     * @mbggenerated Fri Dec 02 16:30:45 CST 2016
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.order_no
     *
     * @mbggenerated Fri Dec 02 16:30:45 CST 2016
     */
    private String orderNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.uid
     *
     * @mbggenerated Fri Dec 02 16:30:45 CST 2016
     */
    private Long uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.create_time
     *
     * @mbggenerated Fri Dec 02 16:30:45 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.order_type
     *
     * @mbggenerated Fri Dec 02 16:30:45 CST 2016
     */
    private Byte orderType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.currency_type
     *
     * @mbggenerated Fri Dec 02 16:30:45 CST 2016
     */
    private Byte currencyType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.amount
     *
     * @mbggenerated Fri Dec 02 16:30:45 CST 2016
     */
    private Long amount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.status
     *
     * @mbggenerated Fri Dec 02 16:30:45 CST 2016
     */
    private Byte status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.goods_id
     *
     * @mbggenerated Fri Dec 02 16:30:45 CST 2016
     */
    private Integer goodsId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.goods_type
     *
     * @mbggenerated Fri Dec 02 16:30:45 CST 2016
     */
    private Integer goodsType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.channel
     *
     * @mbggenerated Fri Dec 02 16:30:45 CST 2016
     */
    private Integer channel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.source
     *
     * @mbggenerated Fri Dec 02 16:30:45 CST 2016
     */
    private Byte source;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_info.deleted
     *
     * @mbggenerated Fri Dec 02 16:30:45 CST 2016
     */
    private Boolean deleted;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.id
     *
     * @return the value of order_info.id
     *
     * @mbggenerated Fri Dec 02 16:30:45 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.id
     *
     * @param id the value for order_info.id
     *
     * @mbggenerated Fri Dec 02 16:30:45 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.order_no
     *
     * @return the value of order_info.order_no
     *
     * @mbggenerated Fri Dec 02 16:30:45 CST 2016
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.order_no
     *
     * @param orderNo the value for order_info.order_no
     *
     * @mbggenerated Fri Dec 02 16:30:45 CST 2016
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.uid
     *
     * @return the value of order_info.uid
     *
     * @mbggenerated Fri Dec 02 16:30:45 CST 2016
     */
    public Long getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.uid
     *
     * @param uid the value for order_info.uid
     *
     * @mbggenerated Fri Dec 02 16:30:45 CST 2016
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.create_time
     *
     * @return the value of order_info.create_time
     *
     * @mbggenerated Fri Dec 02 16:30:45 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.create_time
     *
     * @param createTime the value for order_info.create_time
     *
     * @mbggenerated Fri Dec 02 16:30:45 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.order_type
     *
     * @return the value of order_info.order_type
     *
     * @mbggenerated Fri Dec 02 16:30:45 CST 2016
     */
    public Byte getOrderType() {
        return orderType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.order_type
     *
     * @param orderType the value for order_info.order_type
     *
     * @mbggenerated Fri Dec 02 16:30:45 CST 2016
     */
    public void setOrderType(Byte orderType) {
        this.orderType = orderType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.currency_type
     *
     * @return the value of order_info.currency_type
     *
     * @mbggenerated Fri Dec 02 16:30:45 CST 2016
     */
    public Byte getCurrencyType() {
        return currencyType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.currency_type
     *
     * @param currencyType the value for order_info.currency_type
     *
     * @mbggenerated Fri Dec 02 16:30:45 CST 2016
     */
    public void setCurrencyType(Byte currencyType) {
        this.currencyType = currencyType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.amount
     *
     * @return the value of order_info.amount
     *
     * @mbggenerated Fri Dec 02 16:30:45 CST 2016
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.amount
     *
     * @param amount the value for order_info.amount
     *
     * @mbggenerated Fri Dec 02 16:30:45 CST 2016
     */
    public void setAmount(Long amount) {
        this.amount = amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.status
     *
     * @return the value of order_info.status
     *
     * @mbggenerated Fri Dec 02 16:30:45 CST 2016
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.status
     *
     * @param status the value for order_info.status
     *
     * @mbggenerated Fri Dec 02 16:30:45 CST 2016
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.goods_id
     *
     * @return the value of order_info.goods_id
     *
     * @mbggenerated Fri Dec 02 16:30:45 CST 2016
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.goods_id
     *
     * @param goodsId the value for order_info.goods_id
     *
     * @mbggenerated Fri Dec 02 16:30:45 CST 2016
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.goods_type
     *
     * @return the value of order_info.goods_type
     *
     * @mbggenerated Fri Dec 02 16:30:45 CST 2016
     */
    public Integer getGoodsType() {
        return goodsType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.goods_type
     *
     * @param goodsType the value for order_info.goods_type
     *
     * @mbggenerated Fri Dec 02 16:30:45 CST 2016
     */
    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.channel
     *
     * @return the value of order_info.channel
     *
     * @mbggenerated Fri Dec 02 16:30:45 CST 2016
     */
    public Integer getChannel() {
        return channel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.channel
     *
     * @param channel the value for order_info.channel
     *
     * @mbggenerated Fri Dec 02 16:30:45 CST 2016
     */
    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.source
     *
     * @return the value of order_info.source
     *
     * @mbggenerated Fri Dec 02 16:30:45 CST 2016
     */
    public Byte getSource() {
        return source;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.source
     *
     * @param source the value for order_info.source
     *
     * @mbggenerated Fri Dec 02 16:30:45 CST 2016
     */
    public void setSource(Byte source) {
        this.source = source;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.deleted
     *
     * @return the value of order_info.deleted
     *
     * @mbggenerated Fri Dec 02 16:30:45 CST 2016
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.deleted
     *
     * @param deleted the value for order_info.deleted
     *
     * @mbggenerated Fri Dec 02 16:30:45 CST 2016
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}