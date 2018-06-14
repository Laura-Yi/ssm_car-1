package com.sailing.entity;

import java.io.Serializable;

public class Srtpmanager implements Serializable {
    private Integer id;

    private Integer teacher;

    private String student;

    private String srtpname;

    private String srtpdescription;

    private String apllication;

    private String midcheck;

    private String complete;

    private String status;

    private Integer cost;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeacher() {
        return teacher;
    }

    public void setTeacher(Integer teacher) {
        this.teacher = teacher;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getSrtpname() {
        return srtpname;
    }

    public void setSrtpname(String srtpname) {
        this.srtpname = srtpname;
    }

    public String getSrtpdescription() {
        return srtpdescription;
    }

    public void setSrtpdescription(String srtpdescription) {
        this.srtpdescription = srtpdescription;
    }

    public String getApllication() {
        return apllication;
    }

    public void setApllication(String apllication) {
        this.apllication = apllication;
    }

    public String getMidcheck() {
        return midcheck;
    }

    public void setMidcheck(String midcheck) {
        this.midcheck = midcheck;
    }

    public String getComplete() {
        return complete;
    }

    public void setComplete(String complete) {
        this.complete = complete;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        sb.append(", teacher=").append(teacher);
        sb.append(", student=").append(student);
        sb.append(", srtpname=").append(srtpname);
        sb.append(", srtpdescription=").append(srtpdescription);
        sb.append(", apllication=").append(apllication);
        sb.append(", midcheck=").append(midcheck);
        sb.append(", complete=").append(complete);
        sb.append(", status=").append(status);
        sb.append(", cost=").append(cost);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }


}