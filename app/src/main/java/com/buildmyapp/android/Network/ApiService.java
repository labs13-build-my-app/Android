package com.buildmyapp.android.Network;


import com.buildmyapp.android.model.model.developers.DeveloperList;
import com.buildmyapp.android.model.model.project.Project;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("api/projects/paginated-list-of-projects")
    Call<Project> getProjects(
            @Query("per") int per,
            @Query("page") int pageIndex
    );

    @GET("api/users/list-developers")
    Call<DeveloperList> getDevelopers(
            @Query("per") int per,
            @Query("page") int pageIndex
    );
}