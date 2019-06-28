package com.backbase.mobiletest.ui.about;

import java.lang.ref.WeakReference;

/**
 * Created by Backbase R&D B.V on 28/06/2018.
 */

public class AboutPresenterImpl implements About.Presenter {

    private final WeakReference<About.View> aboutView;
    private final AboutModelImpl aboutModel;

    public AboutPresenterImpl(About.View view, AboutModelImpl aboutModel){
        this.aboutView = new WeakReference<>(view);
        this.aboutModel = aboutModel;
    }

    @Override
    public void getAboutInfo() {
        About.View aboutViewImpl = aboutView.get();
        aboutViewImpl.showProgress();
        aboutModel.getAboutInfo(new AboutCallback());
    }


    private class AboutCallback implements Callback{
        @Override
        public void onSuccess(AboutInfo aboutInfo) {
            About.View aboutViewImpl = aboutView.get();

            if(aboutViewImpl != null){
                aboutViewImpl.updateUI(aboutInfo);
            }
        }

        @Override
        public void onFail() {
            About.View aboutViewImpl = aboutView.get();
            if (aboutViewImpl != null){
                aboutViewImpl.showError();
            }
        }
    }
}
