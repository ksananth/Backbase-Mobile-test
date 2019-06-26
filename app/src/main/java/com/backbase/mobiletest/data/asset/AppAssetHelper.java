package com.backbase.mobiletest.data.asset;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.backbase.mobiletest.utils.BaseResponseModel;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

public class AppAssetHelper implements AssetHelper {

    private static final String TAG = AppAssetHelper.class.getSimpleName();
    private WeakReference<Context> context;

    public AppAssetHelper(Context context) {
        this.context = new WeakReference<>(context);
    }

    @Override
    public String getAssetContent(String filename) {
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

    @Override
    public BaseResponseModel parseJson(Class<? extends BaseResponseModel> responseModel, String json) {
        Gson gson = new Gson();
        BaseResponseModel result = gson.fromJson(json, responseModel);
        return result;
    }
}
