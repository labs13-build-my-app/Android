package com.buildmyapp.android.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.buildmyapp.android.DevDetailsActivity;
import com.buildmyapp.android.R;
import com.buildmyapp.android.model.model.developers.Developer;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

public class DeveloperPaginationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int ITEM = 0;
    private static final int LOADING = 1;
    private static final String BASE_URL_IMG = "https://image.tmdb.org/t/p/w150";

    private List<Developer> movieResults;
    private Context context;

    private boolean isLoadingAdded = false;

    public DeveloperPaginationAdapter(Context context) {
        this.context = context;
        movieResults = new ArrayList<>();
    }

    public List<Developer> getMovies() {
        return movieResults;
    }

    public void setMovies(List<Developer> movieResults) {
        this.movieResults = movieResults;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case ITEM:
                viewHolder = getViewHolder(parent, inflater);
                break;
            case LOADING:
                View v2 = inflater.inflate(R.layout.item_progress, parent, false);
                viewHolder = new DeveloperPaginationAdapter.LoadingVH(v2);
                break;
        }
        return viewHolder;
    }

    @NonNull
    private RecyclerView.ViewHolder getViewHolder(ViewGroup parent, LayoutInflater inflater) {
        RecyclerView.ViewHolder viewHolder;
        View v1 = inflater.inflate(R.layout.card_plan_web, parent, false);
        viewHolder = new DeveloperPaginationAdapter.MovieVH(v1);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        final Developer result = movieResults.get(position); // Movie

        switch (getItemViewType(position)) {
            case ITEM:
                final DeveloperPaginationAdapter.MovieVH movieVH = (DeveloperPaginationAdapter.MovieVH) holder;
                movieVH.Title.setText(result.getFirstName());
                movieVH.description.setText(result.getSkills());
                Glide.with(context)
                        .load(result.getProfilePictureUrl())
                        .diskCacheStrategy(DiskCacheStrategy.ALL)   // cache both original & resized image
                        .centerCrop()
                        .into(movieVH.poster);



                movieVH.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(context, DevDetailsActivity.class);
                        intent.putExtra("name",result.getFirstName()+" "+result.getLastName());
                        intent.putExtra("desc",result.getSkills());
                        intent.putExtra("profile",result.getProfilePictureUrl());
                        context.startActivity(intent);
                    }
                });

                break;

            case LOADING:
//                Do nothing
                break;
        }

    }

    @Override
    public int getItemCount() {
        return movieResults == null ? 0 : movieResults.size();
    }

    @Override
    public int getItemViewType(int position) {
        return (position == movieResults.size() - 1 && isLoadingAdded) ? LOADING : ITEM;
    }


    /*
   Helpers
   _________________________________________________________________________________________________
    */

    public void add(Developer r) {
        movieResults.add(r);
        notifyItemInserted(movieResults.size() - 1);
    }

    public void addAll(List<Developer> moveResults) {
        for (Developer result : moveResults) {
            add(result);
        }
    }

    public void remove(Developer r) {
        int position = movieResults.indexOf(r);
        if (position > -1) {
            movieResults.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clear() {
        isLoadingAdded = false;
        while (getItemCount() > 0) {
            remove(getItem(0));
        }
    }

    public boolean isEmpty() {
        return getItemCount() == 0;
    }


    public void addLoadingFooter() {
        isLoadingAdded = true;
        add(new Developer());
    }

    public void removeLoadingFooter() {
        isLoadingAdded = false;

        int position = movieResults.size() - 1;
        Developer result = getItem(position);

        if (result != null) {
            movieResults.remove(position);
            notifyItemRemoved(position);
        }
    }

    public Developer getItem(int position) {
        return movieResults.get(position);
    }


   /*
   View Holders
   _________________________________________________________________________________________________
    */

    /**
     * Main list's content ViewHolder
     */
    protected class MovieVH extends RecyclerView.ViewHolder {
        private TextView Title;
        private TextView description;
        private TextView mYear; // displays "year | language"
        private ImageView poster;

        public MovieVH(View itemView) {
            super(itemView);

            Title = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
            poster = (ImageView) itemView.findViewById(R.id.poster);
        }
    }


    protected class LoadingVH extends RecyclerView.ViewHolder {

        public LoadingVH(View itemView) {
            super(itemView);
        }
    }


}