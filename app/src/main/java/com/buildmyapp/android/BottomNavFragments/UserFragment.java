package com.buildmyapp.android.BottomNavFragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.buildmyapp.android.R;
import com.buildmyapp.android.innerActivity.submitPlan;

public class UserFragment extends Fragment {

    private Button askPlan;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_user, container, false);

        askPlan = (Button) view.findViewById(R.id.submitButton);

       askPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toPlan = new Intent(getActivity(), submitPlan.class);
                startActivity(toPlan);
            }
        });


        return view;

    }


}
