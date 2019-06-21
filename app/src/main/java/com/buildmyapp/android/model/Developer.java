package com.buildmyapp.android.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Developer implements Serializable {
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


    public Developer(String firstname, String lastName, String email, String devType, String skills, String linkedIn, String gitHub, String twitter) {
        this.firstName = firstname;
        this.lastName = lastName;
        this.email = email;
        this.devType = devType;
        this.skills = skills;
        this.linkedIn = linkedIn;
        this.gitHub = gitHub;
        this.twitter = twitter;
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
}

    /**
     *  PUT	/api/account/developer/update-profile-developer
     * DELETE	/api/account/developer/delete-profile-developer
     * POST	/api/account/developer/submit-plan/:project_id
     * PUT	/api/account/developer/update-plan/:plan_id
     * DELETE	/api/account/developer/delete-plan/:plan_id
     **/
