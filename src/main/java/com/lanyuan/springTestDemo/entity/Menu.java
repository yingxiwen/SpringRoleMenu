package com.lanyuan.springTestDemo.entity;

import java.util.List;

public class Menu {
    private Long menuid;

    private String url;

    private String name;

    private Integer parentid;

    private String status;

    private List<Menu> child;

    public List<Menu> getChild() {
        return child;
    }

    public void setChild(List<Menu> child) {
        this.child = child;
    }

    public Long getMenuid() {
        return menuid;
    }

    public void setMenuid(Long menuid) {
        this.menuid = menuid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
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
        sb.append(", menuid=").append(menuid);
        sb.append(", url=").append(url);
        sb.append(", name=").append(name);
        sb.append(", parentid=").append(parentid);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}