package com.example.horizon.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.horizon.R;
import com.example.horizon.models.ShopItem;
import com.example.horizon.requests.OnTaskCompleted;
import com.example.horizon.tasks.ShopTask;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;


public class ShopFragment extends Fragment implements OnTaskCompleted<ArrayList<ShopItem>> {

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_shop, container, false);

        ShopTask shopTask = new ShopTask(this);
        shopTask.loadShopItems();

        return view;
    }

    @Override
    public void onTaskCompleted(ArrayList<ShopItem> response) {

    }
}
