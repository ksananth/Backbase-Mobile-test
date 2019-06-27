package com.backbase.mobiletest.ui.citymap.presenter;

import android.os.Bundle;

import com.backbase.mobiletest.ui.citymap.contract.CityMap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static com.backbase.mobiletest.ui.citymap.presenter.CityMapPresenter.KEY_SELECTED_CITY;
import static com.backbase.mobiletest.ui.citymap.presenter.CityMapPresenter.KEY_SELECTED_COUNTRY;
import static com.backbase.mobiletest.ui.citymap.presenter.CityMapPresenter.KEY_SELECTED_LAT;
import static com.backbase.mobiletest.ui.citymap.presenter.CityMapPresenter.KEY_SELECTED_LONG;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CityMapPresenterTest {

    private CityMapPresenter presenter;
    private Bundle bundle;

    @Mock
    private CityMap.View view;

    @Before
    public void setUp() {
        bundle = mock(Bundle.class);
        view = mock(CityMap.View.class);
        stubBundle();
        presenter = new CityMapPresenter(view, bundle);
    }

    @Test
    public void shouldInitializeCityMapPresenter() {
        assertNotNull(presenter);
    }

    @Test
    public void shouldGetSelectedCountryDetail_When_InitCalled() {
        presenter.init();

        assertEquals("NL", presenter.getCountry());
        assertEquals("Amsterdam", presenter.getCity());
        assertEquals(2.004, presenter.getLatitude(),0.0);
        assertEquals(1.005, presenter.getLongitude(),0.0);
    }

    @Test
    public void shouldInitializeMaps_when_initCalled() {
        presenter.init();

        verify(view).initializeMap();
    }

    private Bundle stubBundle() {
        when(bundle.getString(KEY_SELECTED_CITY)).thenReturn("Amsterdam");
        when(bundle.getString(KEY_SELECTED_COUNTRY)).thenReturn("NL");
        when(bundle.getString(KEY_SELECTED_LAT)).thenReturn("2.004");
        when(bundle.getString(KEY_SELECTED_LONG)).thenReturn("1.005");
        return bundle;
    }
}