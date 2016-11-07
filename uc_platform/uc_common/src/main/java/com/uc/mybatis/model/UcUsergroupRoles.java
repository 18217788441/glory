package com.uc.mybatis.model;

import javax.persistence.*;

@Table(name = "uc_usergroup_roles")
public class UcUsergroupRoles {
    @Id
    @SequenceGenerator(name="",sequenceName="SELECT LAST_INSERT_ID()")
    private Integer id;

    @Column(name = "userGroup_Id")
    private Integer usergroupId;

    @Column(name = "role_Id")
    private Integer roleId;

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
     * @return role_Id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}