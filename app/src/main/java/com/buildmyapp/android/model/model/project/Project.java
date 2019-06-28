
package com.buildmyapp.android.model.model.project;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Project {

    @SerializedName("per")
    @Expose
    private Integer per;
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("has_more")
    @Expose
    private Boolean hasMore;
    @SerializedName("projects")
    @Expose
    private List<SingleProject> projects = null;

    public Integer getPer() {
        return per;
    }

    public void setPer(Integer per) {
        this.per = per;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    public List<SingleProject> getProjects() {
        return projects;
    }

    public void setProjects(List<SingleProject> projects) {
        this.projects = projects;
    }

}
