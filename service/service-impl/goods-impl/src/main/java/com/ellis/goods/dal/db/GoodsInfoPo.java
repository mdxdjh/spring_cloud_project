package com.ellis.goods.dal.db;

import java.util.Date;

public class GoodsInfoPo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_info.id
     *
     * @mbggenerated Wed Nov 30 00:52:58 CST 2016
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_info.name
     *
     * @mbggenerated Wed Nov 30 00:52:58 CST 2016
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_info.type
     *
     * @mbggenerated Wed Nov 30 00:52:58 CST 2016
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_info.price
     *
     * @mbggenerated Wed Nov 30 00:52:58 CST 2016
     */
    private Long price;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_info.start_time
     *
     * @mbggenerated Wed Nov 30 00:52:58 CST 2016
     */
    private Date startTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_info.end_time
     *
     * @mbggenerated Wed Nov 30 00:52:58 CST 2016
     */
    private Date endTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_info.status
     *
     * @mbggenerated Wed Nov 30 00:52:58 CST 2016
     */
    private Byte status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_info.remark
     *
     * @mbggenerated Wed Nov 30 00:52:58 CST 2016
     */
    private String remark;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_info.id
     *
     * @return the value of goods_info.id
     *
     * @mbggenerated Wed Nov 30 00:52:58 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_info.id
     *
     * @param id the value for goods_info.id
     *
     * @mbggenerated Wed Nov 30 00:52:58 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_info.name
     *
     * @return the value of goods_info.name
     *
     * @mbggenerated Wed Nov 30 00:52:58 CST 2016
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_info.name
     *
     * @param name the value for goods_info.name
     *
     * @mbggenerated Wed Nov 30 00:52:58 CST 2016
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_info.type
     *
     * @return the value of goods_info.type
     *
     * @mbggenerated Wed Nov 30 00:52:58 CST 2016
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_info.type
     *
     * @param type the value for goods_info.type
     *
     * @mbggenerated Wed Nov 30 00:52:58 CST 2016
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_info.price
     *
     * @return the value of goods_info.price
     *
     * @mbggenerated Wed Nov 30 00:52:58 CST 2016
     */
    public Long getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_info.price
     *
     * @param price the value for goods_info.price
     *
     * @mbggenerated Wed Nov 30 00:52:58 CST 2016
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_info.start_time
     *
     * @return the value of goods_info.start_time
     *
     * @mbggenerated Wed Nov 30 00:52:58 CST 2016
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_info.start_time
     *
     * @param startTime the value for goods_info.start_time
     *
     * @mbggenerated Wed Nov 30 00:52:58 CST 2016
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_info.end_time
     *
     * @return the value of goods_info.end_time
     *
     * @mbggenerated Wed Nov 30 00:52:58 CST 2016
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_info.end_time
     *
     * @param endTime the value for goods_info.end_time
     *
     * @mbggenerated Wed Nov 30 00:52:58 CST 2016
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_info.status
     *
     * @return the value of goods_info.status
     *
     * @mbggenerated Wed Nov 30 00:52:58 CST 2016
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_info.status
     *
     * @param status the value for goods_info.status
     *
     * @mbggenerated Wed Nov 30 00:52:58 CST 2016
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_info.remark
     *
     * @return the value of goods_info.remark
     *
     * @mbggenerated Wed Nov 30 00:52:58 CST 2016
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_info.remark
     *
     * @param remark the value for goods_info.remark
     *
     * @mbggenerated Wed Nov 30 00:52:58 CST 2016
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}