package com.backbase.mobiletest.ui.about;

import android.content.Context;

import com.backbase.mobiletest.data.AppDataManager;
import com.backbase.mobiletest.utils.BaseResponseModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AboutPresenterImplTest {

    @Mock
    About.View view;
    @Mock
    Context context;
    @Mock
    AppDataManager appDataManager;
    @Mock
    About.Presenter.Callback callback;

    private AboutPresenterImpl presenter;

    @Before
    public void setUp() {
        presenter = new AboutPresenterImpl(view, new AboutModelImpl(context, appDataManager));
    }

    @Test
    public void shouldBeAbleToInitializePresenter() {
        assertNotNull(presenter);
    }

    @Test
    public void shouldShowProgress_When_getAboutInfo() {
        presenter.getAboutInfo();

        Mockito.verify(view).showProgress();
    }

    @Test
    public void shouldUpdateUI_When_getAboutInfoSuccess() {
        AboutInfo about = stubSuccess();

        presenter.getAboutInfo();

        Mockito.verify(view).updateUI(about);
    }

    @Test
    public void shouldHShowError_When_getAboutInfoFailed() {
        stubFail();
        presenter.getAboutInfo();

        Mockito.verify(view).showError();
    }

    private void stubFail() {
        when(appDataManager.parse(any(String.class), (Class<? extends BaseResponseModel>) any())).thenReturn(null);
    }

    private AboutInfo stubSuccess() {
        AboutInfo about = new AboutInfo();
        about.setCompanyName("Backbase");
        about.setAboutInfo("Backbase");
        about.setCompanyAddress("Test");
        about.setCompanyCity("Amsterdam");
        about.setCompanyPostal("1000");

        when(appDataManager.getJson(any(String.class))).thenReturn("{}");
        when(appDataManager.parse(any(String.class), (Class<? extends BaseResponseModel>) any())).thenReturn(about);
        return about;
    }
}