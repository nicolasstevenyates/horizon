package com.example.horizon.models;

import org.json.JSONException;
import org.json.JSONObject;

public class ShopItem {

    private String imageUrl;
    private int manifestId;
    private String name;
    private String rarity;
    private String storeCategory;
    private int vBucks;

    private ShopItem(String imageUrl, int manifestId, String name, String rarity, String storeCategory, int vBucks) {
        this.imageUrl = imageUrl;
        this.manifestId = manifestId;
        this.name = name;
        this.rarity = rarity;
        this.storeCategory = storeCategory;
        this.vBucks = vBucks;
    }

    public static ShopItem fromJson(final JSONObject o) throws JSONException {
        return new ShopItem(
                o.getString("imageUrl"),
                o.getInt("manifestId"),
                o.getString("name"),
                o.getString("rarity"),
                o.getString("storeCategory"),
                o.getInt("vBucks"));
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getManifestId() {
        return manifestId;
    }

    public String getName() {
        return name;
    }

    public String getRarity() {
        return rarity;
    }

    public String getStoreCategory() {
        return storeCategory;
    }

    public int getVBucks() {
        return vBucks;
    }
}
