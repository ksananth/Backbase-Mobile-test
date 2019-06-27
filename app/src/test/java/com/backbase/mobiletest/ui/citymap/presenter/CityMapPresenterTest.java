package com.backbase.mobiletest.ui.citymap.presenter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CityMapPresenterTest {

    private CityMapPresenter presenter;

    @Before
    public void setUp() {
        presenter = new CityMapPresenter();
    }

    @Test
    public void shouldInitializeCityMapPresenter() {
        assertNotNull(presenter);
    }
}