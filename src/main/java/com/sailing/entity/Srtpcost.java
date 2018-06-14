package com.sailing.entity;

import java.io.Serializable;

public class Srtpcost implements Serializable {
    private Integer id;

    private Integer srtp;

    private String detail;

    private Integer cost;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSrtp() {
        return srtp;
    }

    public void setSrtp(Integer srtp) {
        this.srtp = srtp;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", srtp=").append(srtp);
        sb.append(", detail=").append(detail);
        sb.append(", cost=").append(cost);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}