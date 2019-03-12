package com.example.horizon.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.horizon.R;
import com.example.horizon.models.ShopItem;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;


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


        DecimalFormatSymbols customSymbols = new DecimalFormatSymbols();
        customSymbols.setGroupingSeparator('\'');
        DecimalFormat decimalFormat = new DecimalFormat("###,###.###", customSymbols);

        shopItemPrice.setText(String.valueOf(decimalFormat.format(shopItem.getVBucks())));

        int color = Color.WHITE;

        switch (shopItem.getRarity()) {
            case "Handmade":
                color = context.getResources().getColor(R.color.colorUncommon);
                convertView.setBackgroundColor(color);
                break;
            case "Sturdy":
                color = context.getResources().getColor(R.color.colorRare);
                convertView.setBackgroundColor(color);
                break;
            case "Quality":
                color = context.getResources().getColor(R.color.colorEpic);
                convertView.setBackgroundColor(color);
                break;
            case "Fine":
                color = context.getResources().getColor(R.color.colorLegendary);
                convertView.setBackgroundColor(color);
                break;
        }

        Glide.with(convertView)
                .load(shopItem.getImageUrl())
                .placeholder(new ColorDrawable(color))
                .into(shopItemImage);

        return convertView;
    }
}
