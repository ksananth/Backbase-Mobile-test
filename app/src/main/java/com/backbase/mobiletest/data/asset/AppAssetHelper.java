package com.backbase.mobiletest.data.asset;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.backbase.mobiletest.ui.citymap.model.city.Country;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class AppAssetHelper implements AssetHelper {

    private static final String TAG = AppAssetHelper.class.getSimpleName();
    private WeakReference<Context> context;

    public AppAssetHelper(Context context) {
        this.context = new WeakReference<>(context);
    }

    private String getJson(String filename) {
        if(context.get() != null){
            try{
                AssetManager manager = context.get().getAssets();
                InputStream file = manager.open(filename);
                byte[] formArray = new byte[file.available()];
                file.read(formArray);
                file.close();
                return new String(formArray);
            }catch (IOException ex){
                Log.e(TAG, ex.getLocalizedMessage(), ex);
            }
        }

        return null;
    }

    private ArrayList<Country> parseJson(String json) {
        Gson gson = new Gson();
        ArrayList<Country> result = gson.fromJson(json, new TypeToken<ArrayList<Country>>() {}.getType());
        return result;
    }

    @Override
    public ArrayList<Country> getAssetContent(String filename) {
        return parseJson(getJson(filename) );
    }
}
