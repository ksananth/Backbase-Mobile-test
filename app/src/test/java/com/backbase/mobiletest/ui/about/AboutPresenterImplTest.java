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
    public void shouldHideProgress_When_getAboutInfoSuccess() {
        AboutInfo about = new AboutInfo();
        about.setCompanyName("Backbase");
        stubSuccess(about);
        presenter.getAboutInfo();

        Mockito.verify(view).hideProgress();
        Mockito.verify(view).updateUI(about);
    }

    @Test
    public void shouldHideProgress_When_getAboutInfoFailed() {
        stubFail();
        presenter.getAboutInfo();

        Mockito.verify(view).hideProgress();
    }

    private void stubFail() {
        when(appDataManager.parse(any(String.class), (Class<? extends BaseResponseModel>) any())).thenReturn(null);
    }

    private void stubSuccess(AboutInfo about) {
        when(appDataManager.getJson(any(String.class))).thenReturn("{}");
        when(appDataManager.parse(any(String.class), (Class<? extends BaseResponseModel>) any())).thenReturn(about);
    }
}