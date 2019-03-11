package com.example.horizon.requests;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.net.URL;

public class ImageLoader extends AsyncTask<String, String, Bitmap> {

    @Override
    protected Bitmap doInBackground(String... strings) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(strings[0]);
            bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            return bitmap;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
