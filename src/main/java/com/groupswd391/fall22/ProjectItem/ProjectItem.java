package com.groupswd391.fall22.ProjectItem;


import com.groupswd391.fall22.Project.Project;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;


@CrossOrigin
@Entity
@Table(name = "projectItem")
public class ProjectItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = Project.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "project_ID", referencedColumnName = "id")
    private Project project;

    private double minPrice;
    private double maxPrice;
    private String requirement;
    private Integer neededNum;
    private Integer soldNum;
    private Integer appliedNum;
    private boolean status;

    public ProjectItem() {
    }

    public ProjectItem(int id, Project project, double minPrice, double maxPrice,
                       String requirement, Integer neededNum, Integer soldNum,
                       Integer appliedNum, boolean status) {
        this.id = id;
        this.project = project;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.requirement = requirement;
        this.neededNum = neededNum;
        this.soldNum = soldNum;
        this.appliedNum = appliedNum;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public Integer getNeededNum() {
        return neededNum;
    }

    public void setNeededNum(Integer neededNum) {
        this.neededNum = neededNum;
    }

    public Integer getSoldNum() {
        return soldNum;
    }

    public void setSoldNum(Integer soldNum) {
        this.soldNum = soldNum;
    }

    public Integer getAppliedNum() {
        return appliedNum;
    }

    public void setAppliedNum(Integer appliedNum) {
        this.appliedNum = appliedNum;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
