package com.backbase.mobiletest.ui.about;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.backbase.mobiletest.R;
import com.backbase.mobiletest.data.AppDataManager;


public class AboutActivity extends AppCompatActivity implements About.View {

    private TextView companyName;
    private TextView companyAddress;
    private TextView companyPostal;
    private TextView companyCity;
    private TextView aboutInfo;
    private ProgressBar progressBar;
    private android.view.View errorView;
    private android.view.View infoContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        AboutPresenterImpl aboutPresenter = new AboutPresenterImpl(this, new AboutModelImpl(this, new AppDataManager(this)));
        companyName = findViewById(R.id.companyName);
        companyAddress = findViewById(R.id.companyAdress);
        companyPostal = findViewById(R.id.companypostal);
        companyCity = findViewById(R.id.companyCity);
        aboutInfo = findViewById(R.id.aboutInfo);
        progressBar = findViewById(R.id.progressBar);
        errorView = findViewById(R.id.errorView);
        infoContainer = findViewById(R.id.infoContainer);
        aboutPresenter.getAboutInfo();
    }

    @Override
    public void setCompanyName(String companyNameString) {
        infoContainer.setVisibility(android.view.View.VISIBLE);
        companyName.setText(companyNameString);
    }

    @Override
    public void setCompanyAddress(String companyAddressString) {
        companyAddress.setText(companyAddressString);
    }

    @Override
    public void setCompanyPostalCode(String postalCodeString) {
        companyPostal.setText(postalCodeString);
    }

    @Override
    public void setCompanyCity(String companyCityString) {
        companyCity.setText(companyCityString);
    }

    @Override
    public void setAboutInfo(String infoString) {
        aboutInfo.setText(infoString);
    }

    @Override
    public void showError() {
        errorView.setVisibility(android.view.View.VISIBLE);
        hideProgress();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(android.view.View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(android.view.View.GONE);
    }

    @Override
    public void updateUI(final AboutInfo aboutInfo) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setCompanyName(aboutInfo.getCompanyName());
                setCompanyAddress(aboutInfo.getCompanyAddress());
                setCompanyPostalCode(aboutInfo.getCompanyPostal());
                setCompanyCity(aboutInfo.getCompanyCity());
                setAboutInfo(aboutInfo.getAboutInfo());
                hideProgress();
            }
        }, 1000);
    }
}
