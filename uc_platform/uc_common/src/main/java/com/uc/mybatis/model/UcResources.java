package com.uc.mybatis.model;

import javax.persistence.*;

@Table(name = "uc_resources")
public class UcResources {
    @Id
    @Column(name = "resource_Id")
    private Integer resourceId;

    @Column(name = "parent_resource_Id")
    private String parentResourceId;

    @Column(name = "resource_name")
    private String resourceName;

    @Column(name = "resource_type")
    private String resourceType;

    private Integer priority;

    @Column(name = "resource_string")
    private String resourceString;

    @Column(name = "resource_DESc")
    private String resourceDesc;

    @Column(name = "Enabled")
    private Integer enabled;

    /**
     * @return resource_Id
     */
    public Integer getResourceId() {
        return resourceId;
    }

    /**
     * @param resourceId
     */
    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    /**
     * @return parent_resource_Id
     */
    public String getParentResourceId() {
        return parentResourceId;
    }

    /**
     * @param parentResourceId
     */
    public void setParentResourceId(String parentResourceId) {
        this.parentResourceId = parentResourceId;
    }

    /**
     * @return resource_name
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * @param resourceName
     */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    /**
     * @return resource_type
     */
    public String getResourceType() {
        return resourceType;
    }

    /**
     * @param resourceType
     */
    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    /**
     * @return priority
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * @param priority
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * @return resource_string
     */
    public String getResourceString() {
        return resourceString;
    }

    /**
     * @param resourceString
     */
    public void setResourceString(String resourceString) {
        this.resourceString = resourceString;
    }

    /**
     * @return resource_DESc
     */
    public String getResourceDesc() {
        return resourceDesc;
    }

    /**
     * @param resourceDesc
     */
    public void setResourceDesc(String resourceDesc) {
        this.resourceDesc = resourceDesc;
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