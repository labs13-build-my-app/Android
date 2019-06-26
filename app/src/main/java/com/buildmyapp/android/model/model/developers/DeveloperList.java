
package com.buildmyapp.android.model.model.developers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DeveloperList {

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
    @SerializedName("developers")
    @Expose
    private List<Developer> developers = null;

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

    public List<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }

}
