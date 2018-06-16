package com.sailing.entity;

import java.io.Serializable;

public class Projectmanager implements Serializable {
    private Integer id;

    private String projectname;

    private String content;

    private String reviewresult;

    private String status;

    private String projectresult;

    private Integer teacher;

    private Integer buget;

    private String type;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReviewresult() {
        return reviewresult;
    }

    public void setReviewresult(String reviewresult) {
        this.reviewresult = reviewresult;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProjectresult() {
        return projectresult;
    }

    public void setProjectresult(String projectresult) {
        this.projectresult = projectresult;
    }

    public Integer getTeacher() {
        return teacher;
    }

    public void setTeacher(Integer teacher) {
        this.teacher = teacher;
    }

    public Integer getBuget() {
        return buget;
    }

    public void setBuget(Integer buget) {
        this.buget = buget;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", projectname=").append(projectname);
        sb.append(", content=").append(content);
        sb.append(", reviewresult=").append(reviewresult);
        sb.append(", status=").append(status);
        sb.append(", projectresult=").append(projectresult);
        sb.append(", teacher=").append(teacher);
        sb.append(", buget=").append(buget);
        sb.append(", type=").append(type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}