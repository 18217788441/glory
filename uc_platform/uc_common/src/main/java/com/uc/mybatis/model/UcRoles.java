package com.uc.mybatis.model;

import javax.persistence.*;

@Table(name = "uc_roles")
public class UcRoles {
    @Id
    @Column(name = "role_Id")
    private Integer roleId;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "role_DESc")
    private String roleDesc;

    @Column(name = "Enabled")
    private Integer enabled;

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
     * @return role_name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * @param roleName
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * @return role_DESc
     */
    public String getRoleDesc() {
        return roleDesc;
    }

    /**
     * @param roleDesc
     */
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
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