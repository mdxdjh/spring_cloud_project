package com.ellis.pay.dal.db;

public class MerAcctInfoPo extends MerAcctInfoPoKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mer_acct_info.email
     *
     * @mbggenerated Thu Dec 01 10:59:02 CST 2016
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mer_acct_info.sign_key
     *
     * @mbggenerated Thu Dec 01 10:59:02 CST 2016
     */
    private String signKey;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mer_acct_info.private_key_pwd
     *
     * @mbggenerated Thu Dec 01 10:59:02 CST 2016
     */
    private String privateKeyPwd;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mer_acct_info.public_key_pwd
     *
     * @mbggenerated Thu Dec 01 10:59:02 CST 2016
     */
    private String publicKeyPwd;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mer_acct_info.used
     *
     * @mbggenerated Thu Dec 01 10:59:02 CST 2016
     */
    private String used;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mer_acct_info.email
     *
     * @return the value of mer_acct_info.email
     *
     * @mbggenerated Thu Dec 01 10:59:02 CST 2016
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mer_acct_info.email
     *
     * @param email the value for mer_acct_info.email
     *
     * @mbggenerated Thu Dec 01 10:59:02 CST 2016
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mer_acct_info.sign_key
     *
     * @return the value of mer_acct_info.sign_key
     *
     * @mbggenerated Thu Dec 01 10:59:02 CST 2016
     */
    public String getSignKey() {
        return signKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mer_acct_info.sign_key
     *
     * @param signKey the value for mer_acct_info.sign_key
     *
     * @mbggenerated Thu Dec 01 10:59:02 CST 2016
     */
    public void setSignKey(String signKey) {
        this.signKey = signKey == null ? null : signKey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mer_acct_info.private_key_pwd
     *
     * @return the value of mer_acct_info.private_key_pwd
     *
     * @mbggenerated Thu Dec 01 10:59:02 CST 2016
     */
    public String getPrivateKeyPwd() {
        return privateKeyPwd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mer_acct_info.private_key_pwd
     *
     * @param privateKeyPwd the value for mer_acct_info.private_key_pwd
     *
     * @mbggenerated Thu Dec 01 10:59:02 CST 2016
     */
    public void setPrivateKeyPwd(String privateKeyPwd) {
        this.privateKeyPwd = privateKeyPwd == null ? null : privateKeyPwd.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mer_acct_info.public_key_pwd
     *
     * @return the value of mer_acct_info.public_key_pwd
     *
     * @mbggenerated Thu Dec 01 10:59:02 CST 2016
     */
    public String getPublicKeyPwd() {
        return publicKeyPwd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mer_acct_info.public_key_pwd
     *
     * @param publicKeyPwd the value for mer_acct_info.public_key_pwd
     *
     * @mbggenerated Thu Dec 01 10:59:02 CST 2016
     */
    public void setPublicKeyPwd(String publicKeyPwd) {
        this.publicKeyPwd = publicKeyPwd == null ? null : publicKeyPwd.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mer_acct_info.used
     *
     * @return the value of mer_acct_info.used
     *
     * @mbggenerated Thu Dec 01 10:59:02 CST 2016
     */
    public String getUsed() {
        return used;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mer_acct_info.used
     *
     * @param used the value for mer_acct_info.used
     *
     * @mbggenerated Thu Dec 01 10:59:02 CST 2016
     */
    public void setUsed(String used) {
        this.used = used == null ? null : used.trim();
    }
}