package com.uc.mybatis.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

@Table(name = "uc_users")
@Data
public class UcUsers implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "user_Id")
    private Integer userId;

    @Column(name = "user_account")
    private String userAccount;

    @Column(name = "user_pwd")
    private String userPwd;

    @Column(name = "user_DESc")
    private String userDesc;

    @Column(name = "Enabled")
    private Integer enabled;

    /**
     * @return user_Id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return user_account
     */
    public String getUserAccount() {
        return userAccount;
    }

    /**
     * @param userAccount
     */
    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    /**
     * @return user_pwd
     */
    public String getUserPwd() {
        return userPwd;
    }

    /**
     * @param userPwd
     */
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    /**
     * @return user_DESc
     */
    public String getUserDesc() {
        return userDesc;
    }

    /**
     * @param userDesc
     */
    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }

    /**
     * @return Enabled
     */
    public Integer getEnabled() {
        return enabled;
    }

    /**
     * @param enabled
     */
    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }
}