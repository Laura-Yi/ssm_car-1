package com.sailing.entity;

import java.io.Serializable;

public class Graduationmanager implements Serializable {
    private Integer id;

    private Integer teacher;

    private Integer student;

    private String assignmentbook;

    private String topicselectionreport;

    private String midcheck;

    private String graduationstudy;

    private String reviewform;

    private String revieweropinionform;

    private String resultform;

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

    public Integer getStudent() {
        return student;
    }

    public void setStudent(Integer student) {
        this.student = student;
    }

    public String getAssignmentbook() {
        return assignmentbook;
    }

    public void setAssignmentbook(String assignmentbook) {
        this.assignmentbook = assignmentbook;
    }

    public String getTopicselectionreport() {
        return topicselectionreport;
    }

    public void setTopicselectionreport(String topicselectionreport) {
        this.topicselectionreport = topicselectionreport;
    }

    public String getMidcheck() {
        return midcheck;
    }

    public void setMidcheck(String midcheck) {
        this.midcheck = midcheck;
    }

    public String getGraduationstudy() {
        return graduationstudy;
    }

    public void setGraduationstudy(String graduationstudy) {
        this.graduationstudy = graduationstudy;
    }

    public String getReviewform() {
        return reviewform;
    }

    public void setReviewform(String reviewform) {
        this.reviewform = reviewform;
    }

    public String getRevieweropinionform() {
        return revieweropinionform;
    }

    public void setRevieweropinionform(String revieweropinionform) {
        this.revieweropinionform = revieweropinionform;
    }

    public String getResultform() {
        return resultform;
    }

    public void setResultform(String resultform) {
        this.resultform = resultform;
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
        sb.append(", assignmentbook=").append(assignmentbook);
        sb.append(", topicselectionreport=").append(topicselectionreport);
        sb.append(", midcheck=").append(midcheck);
        sb.append(", graduationstudy=").append(graduationstudy);
        sb.append(", reviewform=").append(reviewform);
        sb.append(", revieweropinionform=").append(revieweropinionform);
        sb.append(", resultform=").append(resultform);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}