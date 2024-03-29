package com.backbase.mobiletest.ui.about;

/**
 * Created by Backbase R&D B.V on 28/06/2018.
 * MVP contract for AboutActivity
 */

public interface About {

    interface Model {
        void getAboutInfo(Presenter.Callback callback);
    }

    interface Presenter {
        void getAboutInfo();
        interface Callback {
            void onSuccess(AboutInfo aboutInfo);
            void onFail();
        }
    }

    interface View {
        void setCompanyName(String companyName);
        void setCompanyAddress(String companyAddress);
        void setCompanyPostalCode(String postalCode);
        void setCompanyCity(String companyCity);
        void setAboutInfo(String info);
        void showError();
        void showProgress();
        void hideProgress();
        void updateUI(AboutInfo aboutInfo);
    }
}
