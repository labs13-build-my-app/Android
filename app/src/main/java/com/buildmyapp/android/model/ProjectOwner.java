package com.buildmyapp.android.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ProjectOwner implements Serializable {
    @SerializedName("firstName")
    @Expose
    private String firstName;

    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("linkedIn")
    @Expose
    private String linkedIn;

    @SerializedName("gitHub")
    @Expose
    private String gitHub;

    @SerializedName("twitter")
    @Expose
    private String twitter;


    public ProjectOwner(String firstName, String lastName, String email, String linkedIn, String gitHub, String twitter) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.linkedIn = linkedIn;
        this.gitHub = gitHub;
        this.twitter = twitter;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstname(String firstName) {
        this.firstName = firstName;
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
 *  PUT	/api/account/project-owner/update-profile-project-owner
 * DELETE	/api/account/project-owner/delete-profile-project-owner
 * GET	/api/account/project-owner/project-page/:project_id
 * POST	/api/account/project-owner/create-project
 * PUT	/api/account/project-owner/update-project/:project_id
 * PUT	/api/account/project-owner/accept-plan/:project_id
 * DELETE	/api/account/project-owner/delete-project/:project_id
 **/
