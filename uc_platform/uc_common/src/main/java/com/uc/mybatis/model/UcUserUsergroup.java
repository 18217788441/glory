package com.uc.mybatis.model;

import javax.persistence.*;

@Table(name = "uc_user_usergroup")
public class UcUserUsergroup {
    @Id
    @SequenceGenerator(name="",sequenceName="SELECT LAST_INSERT_ID()")
    private Integer id;

    @Column(name = "userGroup_Id")
    private Integer usergroupId;

    @Column(name = "user_Id")
    private Integer userId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return userGroup_Id
     */
    public Integer getUsergroupId() {
        return usergroupId;
    }

    /**
     * @param usergroupId
     */
    public void setUsergroupId(Integer usergroupId) {
        this.usergroupId = usergroupId;
    }

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
}