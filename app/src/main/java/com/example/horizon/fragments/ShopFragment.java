package com.example.horizon.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;

import com.example.horizon.R;
import com.example.horizon.adapters.ShopItemsAdapter;
import com.example.horizon.components.DynamicListView;
import com.example.horizon.models.ShopItem;
import com.example.horizon.requests.OnTaskCompleted;
import com.example.horizon.tasks.ShopTask;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;


public class ShopFragment extends Fragment implements OnTaskCompleted<ArrayList<ShopItem>> {

    private View view;
    private DynamicListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_shop, container, false);
        listView = view.findViewById(R.id.shop_items_list);

        ShopTask shopTask = new ShopTask(this);
        shopTask.loadShopItems();

        return view;
    }

    @Override
    public void onTaskCompleted(ArrayList<ShopItem> response) {
        ShopItemsAdapter shopItemsAdapter = new ShopItemsAdapter(getContext(), getStoreToday(response));
        listView.setAdapter(shopItemsAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        listView.setFriction(ViewConfiguration.getScrollFriction() * 4);
    }

    private ArrayList<ShopItem> getStoreToday(ArrayList<ShopItem> allShopItems) {

        ArrayList<ShopItem> shopItems = new ArrayList<>();

        int i = 0;
        for (ShopItem shopitem : allShopItems) {
            if (shopitem.getStoreCategory().equals("BRWeeklyStorefront") && i == 0) {
                shopItems.add(shopitem);
            } else if (shopitem.getStoreCategory().equals("BRDailyStorefront") && i <= 1) {
                shopItems.add(shopitem);
                i = 1;
            } else if (shopitem.getStoreCategory().equals("BRWeeklyStorefront") && i != 0)
                break;
        }

        return shopItems;
    }
}
