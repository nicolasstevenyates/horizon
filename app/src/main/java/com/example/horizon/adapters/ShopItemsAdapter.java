package com.example.horizon.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.horizon.R;
import com.example.horizon.models.ShopItem;
import com.example.horizon.requests.ImageLoader;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


public class ShopItemsAdapter extends BaseAdapter {

    private final Context context;
    private final ArrayList<ShopItem> shopItems;

    public ShopItemsAdapter(Context context, ArrayList<ShopItem> shopItems) {
        this.context = context;
        this.shopItems = shopItems;
    }

    @Override
    public int getCount() {
        return shopItems.size();
    }

    @Override
    public Object getItem(int position) {
        return shopItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.shop_item, parent, false);
        }

        ShopItem shopItem = (ShopItem) getItem(position);

        TextView shopItemName = convertView.findViewById(R.id.shop_item_name);
        TextView shopItemPrice = convertView.findViewById(R.id.shop_item_price);
        ImageView shopItemImage = convertView.findViewById(R.id.shop_item_image);

        shopItemName.setText(shopItem.getName());
        try {
            shopItemImage.setImageBitmap(new ImageLoader().execute(shopItem.getImageUrl()).get());
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        //shopItemPrice.setText(shopItem.getvBucks());

        return convertView;
    }
}
