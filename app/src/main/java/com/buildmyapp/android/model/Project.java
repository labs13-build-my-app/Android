package com.buildmyapp.android.model;

import android.widget.Button;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Project implements Serializable {

    @SerializedName("Id")
    @Expose
    private Integer id;

    @SerializedName("Name")
    @Expose
    private String Name;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("image_url")
    @Expose
    private String image_url;

    @SerializedName("budget")
    @Expose
    private String budget;

    @SerializedName("dueDate")
    @Expose
    private String dueDate;

    @SerializedName("projectStatus")
    @Expose
    private String projectStatus;

    @SerializedName("paymentStatus")
    @Expose
    private String paymentStatus;

    @SerializedName("user_id")
    @Expose
    private Integer user_id;

    @SerializedName("created_at")
    @Expose
    private String created_at;

    @SerializedName("updated_at")
    @Expose
    private String updated_at;



    public Project(Integer id, String Name, String description, String image_url, String budget, String dueDate, String projectStatus, String paymentStatus, Integer user_id, String created_at, String updated_at ) {

        this.Name = Name;
        this.description = description;
        this.image_url = image_url;
        this.budget = budget;
        this.dueDate = dueDate;
        this.projectStatus = projectStatus;
        this.paymentStatus = paymentStatus;
        this.created_at = created_at;
        this.id = id;
        this.user_id = user_id;
        this.updated_at= updated_at;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }
    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate  (String dueDate) {
        this.dueDate = dueDate;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

}

/**
 *  GET	/
 * GET	/api/projects/paginated-list-of-projects
 * GET	/api/projects/plan-list-project/:project_id
 * GET	/api/projects/plan-list-developer/:developer_id
 * GET	/api/projects/project-view/:project_id
 * GET	/api/projects/plan-view/:plan_id
 * GET	/api/projects/project-list/:project_owner_id
 * GET	/api/projects/developer-feedback/:developer_id
 **/
