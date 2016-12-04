package com.ellis.user.dal.db;

import com.ellis.user.dal.db.UserInfoPo;
import com.ellis.user.dal.db.UserInfoPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserInfoPoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Wed Nov 30 00:54:26 CST 2016
     */
    int countByExample(UserInfoPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Wed Nov 30 00:54:26 CST 2016
     */
    int deleteByExample(UserInfoPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Wed Nov 30 00:54:26 CST 2016
     */
    int deleteByPrimaryKey(Long uid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Wed Nov 30 00:54:26 CST 2016
     */
    int insert(UserInfoPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Wed Nov 30 00:54:26 CST 2016
     */
    int insertSelective(UserInfoPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Wed Nov 30 00:54:26 CST 2016
     */
    List<UserInfoPo> selectByExample(UserInfoPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Wed Nov 30 00:54:26 CST 2016
     */
    UserInfoPo selectByPrimaryKey(Long uid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Wed Nov 30 00:54:26 CST 2016
     */
    int updateByExampleSelective(@Param("record") UserInfoPo record, @Param("example") UserInfoPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Wed Nov 30 00:54:26 CST 2016
     */
    int updateByExample(@Param("record") UserInfoPo record, @Param("example") UserInfoPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Wed Nov 30 00:54:26 CST 2016
     */
    int updateByPrimaryKeySelective(UserInfoPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Wed Nov 30 00:54:26 CST 2016
     */
    int updateByPrimaryKey(UserInfoPo record);
}