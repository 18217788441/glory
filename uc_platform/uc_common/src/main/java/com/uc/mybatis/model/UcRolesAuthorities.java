package com.uc.mybatis.model;

import javax.persistence.*;

@Table(name = "uc_roles_authorities")
public class UcRolesAuthorities {
    @Id
    @SequenceGenerator(name="",sequenceName="SELECT LAST_INSERT_ID()")
    private Integer id;

    @Column(name = "role_Id")
    private Integer roleId;

    @Column(name = "authority_Id")
    private Integer authorityId;

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

    /**
     * @return authority_Id
     */
    public Integer getAuthorityId() {
        return authorityId;
    }

    /**
     * @param authorityId
     */
    public void setAuthorityId(Integer authorityId) {
        this.authorityId = authorityId;
    }
}