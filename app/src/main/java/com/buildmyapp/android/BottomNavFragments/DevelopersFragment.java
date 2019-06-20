package com.buildmyapp.android.BottomNavFragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.buildmyapp.android.R;
import com.buildmyapp.android.bio;
import com.buildmyapp.android.model.Developer;

import java.util.ArrayList;
import java.util.List;

public class DevelopersFragment extends Fragment {




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.fragment_developers, container, false);





        //ImageView userBio  = (ImageView)v.findViewById(R.id.profile_Dummy);

       /** userBio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toBio = new Intent(getActivity(), bio.class);
                startActivity(toBio);
            }
        }); **/


        return v;

    }


}
