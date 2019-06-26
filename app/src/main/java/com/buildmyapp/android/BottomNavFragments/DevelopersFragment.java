
package com.buildmyapp.android.BottomNavFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.buildmyapp.android.Network.ApiService;
import com.buildmyapp.android.Network.PaginationScrollListener;
import com.buildmyapp.android.Network.RetrofitClient;
import com.buildmyapp.android.R;
import com.buildmyapp.android.adapter.DeveloperPaginationAdapter;
import com.buildmyapp.android.adapter.EndlessRecyclerOnScrollListener;
import com.buildmyapp.android.model.model.developers.Developer;
import com.buildmyapp.android.model.model.developers.DeveloperList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DevelopersFragment extends Fragment {

    private static final String TAG = "MainActivity";

    DeveloperPaginationAdapter adapter;
    LinearLayoutManager linearLayoutManager;

    RecyclerView rv;
    ProgressBar progressBar;

    private static final int PAGE_START = 1;
    private boolean isLoading = false;
    private boolean isLastPage = false;
    // limiting to 5 for this tutorial, since total pages in actual API is very large. Feel free to modify.
    private int TOTAL_PAGES = 0;
    private int currentPage = PAGE_START;

    private ApiService apiService;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_developers, container, false);

        rv = (RecyclerView) view.findViewById(R.id.main_recycler);
        progressBar = (ProgressBar) view.findViewById(R.id.main_progress);

        adapter = new DeveloperPaginationAdapter(getContext());

        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(linearLayoutManager);

        rv.setItemAnimator(new DefaultItemAnimator());

        rv.setAdapter(adapter);


        rv.addOnScrollListener(new EndlessRecyclerOnScrollListener(linearLayoutManager) {
            @Override
            public void onScrolledToEnd() {
                Log.e("Position", "Last item reached");
                if (!isLastPage) {
                    currentPage += 1;
                    loadNextPage();
                }
            }
        });

//        rv.addOnScrollListener(new PaginationScrollListener(linearLayoutManager) {
//            @Override
//            protected void loadMoreItems() {
//                isLoading = true;
//                currentPage += 1;
//                loadNextPage();
//            }
//
//            @Override
//            public int getTotalPageCount() {
//                return TOTAL_PAGES;
//            }
//
//            @Override
//            public boolean isLastPage() {
//                return isLastPage;
//            }
//
//            @Override
//            public boolean isLoading() {
//                return isLoading;
//            }
//        });

        //init service and load data
        apiService = RetrofitClient.getClient(getContext()).create(ApiService.class);

        loadFirstPage();


        return view;
    }


    private void loadFirstPage() {
        Log.d(TAG, "loadFirstPage: ");

        getDevelopers().enqueue(new Callback<DeveloperList>() {
            @Override
            public void onResponse(Call<DeveloperList> call, Response<DeveloperList> response) {
                // Got data. Send it to adapter

                List<Developer> results = fetchResults(response);
                progressBar.setVisibility(View.GONE);
                adapter.addAll(results);

                assert response.body() != null;
                TOTAL_PAGES = response.body().getTotalPages();
                Log.d("TOTAL_PAGES", String.valueOf(TOTAL_PAGES));
                if (currentPage <= TOTAL_PAGES) adapter.addLoadingFooter();
                else isLastPage = true;
            }

            @Override
            public void onFailure(Call<DeveloperList> call, Throwable t) {
                t.printStackTrace();
                // TODO: 08/11/16 handle failure
            }
        });

    }


    private List<Developer> fetchResults(Response<DeveloperList> response) {
        DeveloperList topRatedMovies = response.body();
        assert topRatedMovies != null;
        return topRatedMovies.getDevelopers();
    }

    private void loadNextPage() {
        Log.d(TAG, "loadNextPage: " + currentPage);


        getDevelopers().enqueue(new Callback<DeveloperList>() {
            @Override
            public void onResponse(Call<DeveloperList> call, Response<DeveloperList> response) {
                adapter.removeLoadingFooter();
                isLoading = false;

                List<Developer> results = fetchResults(response);
                adapter.addAll(results);

                if (currentPage != TOTAL_PAGES) adapter.addLoadingFooter();
                else isLastPage = true;
            }

            @Override
            public void onFailure(Call<DeveloperList> call, Throwable t) {
                t.printStackTrace();
                // TODO: 08/11/16 handle failure
            }
        });
    }


    /**
     * Performs a Retrofit call to the top rated movies API.
     * Same API call for Pagination.
     * As {@link #currentPage} will be incremented automatically
     * by @{@link PaginationScrollListener} to load next page.
     */
    private Call<DeveloperList> getDevelopers() {
        return apiService.getDevelopers(
                15,
                currentPage
        );
    }
}