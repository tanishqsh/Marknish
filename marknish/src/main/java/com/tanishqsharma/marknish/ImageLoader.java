package com.tanishqsharma.marknish;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Hemant on 11/9/2017.
 */

public class ImageLoader extends AsyncTask<String, Void, Bitmap> {

    private static final String TAG = "ImageLoader";
    private ImageView imageView;

    public ImageLoader(ImageView imageView) {
        this.imageView = imageView;
    }


    @Override
    protected Bitmap doInBackground(String... urls) {
        String url = urls[0];
        Bitmap bitmap = null;
        try {
            URL urlconnection = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlconnection.openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            Log.d(TAG, "doInBackground: " + url);
            InputStream inputStream = httpURLConnection.getInputStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        imageView.setImageBitmap(bitmap);
    }
}