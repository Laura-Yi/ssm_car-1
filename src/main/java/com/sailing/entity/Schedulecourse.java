package com.sailing.entity;

import java.io.Serializable;

public class Schedulecourse implements Serializable {
    private Integer id;

    private Integer classroom;

    private Integer educationplan;

    private Integer time;

    private String building;

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClassroom() {
        return classroom;
    }

    public void setClassroom(Integer classroom) {
        this.classroom = classroom;
    }

    public Integer getEducationplan() {
        return educationplan;
    }

    public void setEducationplan(Integer educationplan) {
        this.educationplan = educationplan;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", classroom=").append(classroom);
        sb.append(", educationplan=").append(educationplan);
        sb.append(", time=").append(time);
        sb.append(", building=").append(building);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}