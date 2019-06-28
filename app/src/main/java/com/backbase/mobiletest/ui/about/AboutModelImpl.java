package com.backbase.mobiletest.ui.about;

import android.content.Context;
import android.support.annotation.NonNull;

import com.backbase.mobiletest.data.AppDataManager;

import java.lang.ref.WeakReference;

/**
 * Created by Backbase R&D B.V on 28/06/2018.
 */

public class AboutModelImpl implements About.Model {

    private static final String TAG = AboutModelImpl.class.getSimpleName();
    private final WeakReference<Context> context;
    private AppDataManager appDataManager;
    private static final String FILE_NAME = "aboutInfo.json";

    public AboutModelImpl(@NonNull Context context, AppDataManager appDataManager){
        this.context = new WeakReference<>(context);
        this.appDataManager = appDataManager;
    }

    @Override
    public void getAboutInfo(About.Presenter.Callback callback) {
        String aboutInfoJson = getAboutInfoFromAssets();

        if(aboutInfoJson != null && !aboutInfoJson.isEmpty()){
    		AboutInfo aboutInfo = parseAboutInfo();
    		if (aboutInfo != null){
                callback.onSuccess(aboutInfo);
        		return;
   		 	}
		}

        callback.onFail();
    }

    private AboutInfo parseAboutInfo() {
        appDataManager.parse(getAboutInfoFromAssets(), AboutInfo.class);
        return (AboutInfo) appDataManager.parse(getAboutInfoFromAssets(), AboutInfo.class);
    }

    private String getAboutInfoFromAssets() {
        return appDataManager.getJson(FILE_NAME);
    }
}
