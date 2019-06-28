package com.backbase.mobiletest.ui.about;

import android.content.Context;
import android.support.annotation.NonNull;

import com.backbase.mobiletest.data.AppDataManager;

import java.lang.ref.WeakReference;

/**
 * Created by Backbase R&D B.V on 28/06/2018.
 */

public class AboutPresenterImpl implements About.Presenter {

    private final WeakReference<About.View> aboutView;
    private final AboutModelImpl aboutModel;

    public AboutPresenterImpl(About.View view, @NonNull Context context, AppDataManager appDataManager){
        this.aboutView = new WeakReference<>(view);
        this.aboutModel = new AboutModelImpl(this, context, appDataManager);
    }

    @Override
    public void getAboutInfo() {
        About.View aboutViewImpl = aboutView.get();
        aboutViewImpl.showProgress();
        aboutModel.getAboutInfo();
    }

    @Override
    public void onSuccess(AboutInfo aboutInfo) {
        About.View aboutViewImpl = aboutView.get();

        if(aboutViewImpl != null){
            aboutViewImpl.hideProgress();
            aboutViewImpl.updateUI(aboutInfo);
        }

    }

    @Override
    public void onFail() {
        About.View aboutViewImpl = aboutView.get();
        if (aboutViewImpl != null){
            aboutViewImpl.hideProgress();
            aboutViewImpl.showError();
        }
    }
}
