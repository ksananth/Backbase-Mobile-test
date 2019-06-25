package com.backbase.mobiletest.ui.citymap.presenter;

import android.content.Context;

import com.backbase.mobiletest.ui.citymap.contract.CityList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CityListPresenterTest {

    @Mock
    private Context context;
    @Mock
    private CityList.View view;
    @Mock
    private CityList.Model model;

    private CityListPresenter presenter;

    @Test
    public void shouldInitializeCityPresenterWithViewAndModel() {
        presenter = new CityListPresenter(context, view, model);

        assertNotNull(presenter);
    }
}