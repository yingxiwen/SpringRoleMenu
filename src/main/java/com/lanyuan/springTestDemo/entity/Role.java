package com.lanyuan.springTestDemo.entity;

public class Role {
    private Long roleid;

    private String rolename;

    private String status;

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roleid=").append(roleid);
        sb.append(", rolename=").append(rolename);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}