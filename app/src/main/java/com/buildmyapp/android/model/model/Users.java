package com.buildmyapp.android.model.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Users implements Serializable {
    @SerializedName("Id")
    @Expose
    private Integer id;

    @SerializedName("role")
    @Expose
    private String role;


    @SerializedName("firstName")
    @Expose
    private String firstName;

    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("devType")
    @Expose
    private String devType;
    @SerializedName("skills")
    @Expose
    private String skills;

    @SerializedName("linkedIn")
    @Expose
    private String linkedIn;

    @SerializedName("gitHub")
    @Expose
    private String gitHub;

    @SerializedName("twitter")
    @Expose
    private String twitter;


    public Users(Integer id, String role, String firstName, String lastName, String email, String devType, String skills, String linkedIn, String gitHub, String twitter) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.devType = devType;
        this.skills = skills;
        this.linkedIn = linkedIn;
        this.gitHub = gitHub;
        this.twitter = twitter;
        this.id = id;
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstname(String firstname) {
        this.firstName = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDevType() {
        return devType;
    }

    public void setDevType(String devType) {
        this.devType = devType;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getGitHub() {
        return gitHub;
    }

    public void setGitHub(String gitHub) {
        this.gitHub = gitHub;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

/**
 *  GET	/api/users/profile/:user_id	200 - returns user data
 * 404 - user not found	User data for profile page
 * GET	/api/users/list-users	200 - list of all users
 * 404 - users not found
 * 500 - server error	list of all users, no specific purpose other than testing
 * GET	/api/users/list-developers	200 - list of developers
 * 404 - developers not found
 * 500 - server error	paginated list of developers
 **/
