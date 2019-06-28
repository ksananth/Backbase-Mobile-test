package com.backbase.mobiletest.ui.about;

import android.content.Context;

import com.backbase.mobiletest.ui.citymap.model.CityListModel;
import com.backbase.mobiletest.ui.citymap.presenter.CityListPresenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static com.backbase.mobiletest.ui.citymap.model.CityListModel.CITIES_FILENAME;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class AboutPresenterImplTest {

    @Mock
    About.View view;
    @Mock
    Context context;

    private AboutPresenterImpl presenter;

    @Before
    public void setUp() {
        presenter = new AboutPresenterImpl(view, context);
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
}