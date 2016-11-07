package com.uc.mybatis.model;

import javax.persistence.*;

@Table(name = "uc_authorities")
public class UcAuthorities {
    @Id
    @Column(name = "authority_Id")
    private Integer authorityId;

    @Column(name = "Authority_name")
    private String authorityName;

    @Column(name = "Authority_DESc")
    private String authorityDesc;

    private Integer operation;

    @Column(name = "Enabled")
    private Integer enabled;

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

    /**
     * @return Authority_name
     */
    public String getAuthorityName() {
        return authorityName;
    }

    /**
     * @param authorityName
     */
    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    /**
     * @return Authority_DESc
     */
    public String getAuthorityDesc() {
        return authorityDesc;
    }

    /**
     * @param authorityDesc
     */
    public void setAuthorityDesc(String authorityDesc) {
        this.authorityDesc = authorityDesc;
    }

    /**
     * @return operation
     */
    public Integer getOperation() {
        return operation;
    }

    /**
     * @param operation
     */
    public void setOperation(Integer operation) {
        this.operation = operation;
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