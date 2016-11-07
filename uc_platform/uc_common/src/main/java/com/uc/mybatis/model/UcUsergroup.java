package com.uc.mybatis.model;

import javax.persistence.*;

@Table(name = "uc_usergroup")
public class UcUsergroup {
    @Id
    @Column(name = "userGroup_Id")
    private Integer usergroupId;

    @Column(name = "userGroup_name")
    private String usergroupName;

    @Column(name = "userGroup_DESc")
    private String usergroupDesc;

    @Column(name = "Enabled")
    private Integer enabled;

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
     * @return userGroup_name
     */
    public String getUsergroupName() {
        return usergroupName;
    }

    /**
     * @param usergroupName
     */
    public void setUsergroupName(String usergroupName) {
        this.usergroupName = usergroupName;
    }

    /**
     * @return userGroup_DESc
     */
    public String getUsergroupDesc() {
        return usergroupDesc;
    }

    /**
     * @param usergroupDesc
     */
    public void setUsergroupDesc(String usergroupDesc) {
        this.usergroupDesc = usergroupDesc;
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