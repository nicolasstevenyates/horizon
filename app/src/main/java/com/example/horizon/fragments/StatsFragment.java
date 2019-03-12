package com.example.horizon.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.horizon.R;

import androidx.fragment.app.Fragment;


public class StatsFragment extends Fragment {

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_stats, container, false);

        return view;
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        listView.setFriction(ViewConfiguration.getScrollFriction() * 4);
//    }
}
