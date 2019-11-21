package com.infosky.entity;

import java.io.Serializable;

public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer departmentRecId;

    private Integer departmentId;

    private String departmentName;

    private String departmentManager;

    private String departmentDescription;

    public Integer getDepartmentRecId() {
        return departmentRecId;
    }

    public void setDepartmentRecId(Integer departmentRecId) {
        this.departmentRecId = departmentRecId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public String getDepartmentManager() {
        return departmentManager;
    }

    public void setDepartmentManager(String departmentManager) {
        this.departmentManager = departmentManager == null ? null : departmentManager.trim();
    }

    public String getDepartmentDescription() {
        return departmentDescription;
    }

    public void setDepartmentDescription(String departmentDescription) {
        this.departmentDescription = departmentDescription == null ? null : departmentDescription.trim();
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentRecId=" + departmentRecId +
                ", departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", departmentManager='" + departmentManager + '\'' +
                ", departmentDescription='" + departmentDescription + '\'' +
                '}';
    }
}