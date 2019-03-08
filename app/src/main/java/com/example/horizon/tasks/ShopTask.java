package com.example.horizon.tasks;

import com.example.horizon.models.ShopItem;
import com.example.horizon.requests.HttpClient;
import com.example.horizon.requests.OnTaskCompleted;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;


public class ShopTask {

    private ArrayList<ShopItem> shopItems = new ArrayList<>();
    private OnTaskCompleted listener;

    public ShopTask(OnTaskCompleted listener) {

        this.listener = listener;
        loadShopItems();
    }

    public void loadShopItems() {

        HttpClient.get("store", null, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {

                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject o = response.getJSONObject(i);
                        ShopItem shopItem = ShopItem.fromJson(o);
                        shopItems.add(shopItem);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                listener.requestCompleted(shopItems);
            }
        });
    }
}
