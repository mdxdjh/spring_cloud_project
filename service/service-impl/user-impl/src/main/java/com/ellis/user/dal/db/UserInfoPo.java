package com.ellis.user.dal.db;

public class UserInfoPo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.uid
     *
     * @mbggenerated Wed Nov 30 00:54:26 CST 2016
     */
    private Long uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.username
     *
     * @mbggenerated Wed Nov 30 00:54:26 CST 2016
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.password
     *
     * @mbggenerated Wed Nov 30 00:54:26 CST 2016
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.phone
     *
     * @mbggenerated Wed Nov 30 00:54:26 CST 2016
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.name
     *
     * @mbggenerated Wed Nov 30 00:54:26 CST 2016
     */
    private String name;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.uid
     *
     * @return the value of user_info.uid
     *
     * @mbggenerated Wed Nov 30 00:54:26 CST 2016
     */
    public Long getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.uid
     *
     * @param uid the value for user_info.uid
     *
     * @mbggenerated Wed Nov 30 00:54:26 CST 2016
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.username
     *
     * @return the value of user_info.username
     *
     * @mbggenerated Wed Nov 30 00:54:26 CST 2016
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.username
     *
     * @param username the value for user_info.username
     *
     * @mbggenerated Wed Nov 30 00:54:26 CST 2016
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.password
     *
     * @return the value of user_info.password
     *
     * @mbggenerated Wed Nov 30 00:54:26 CST 2016
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.password
     *
     * @param password the value for user_info.password
     *
     * @mbggenerated Wed Nov 30 00:54:26 CST 2016
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.phone
     *
     * @return the value of user_info.phone
     *
     * @mbggenerated Wed Nov 30 00:54:26 CST 2016
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.phone
     *
     * @param phone the value for user_info.phone
     *
     * @mbggenerated Wed Nov 30 00:54:26 CST 2016
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.name
     *
     * @return the value of user_info.name
     *
     * @mbggenerated Wed Nov 30 00:54:26 CST 2016
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.name
     *
     * @param name the value for user_info.name
     *
     * @mbggenerated Wed Nov 30 00:54:26 CST 2016
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}