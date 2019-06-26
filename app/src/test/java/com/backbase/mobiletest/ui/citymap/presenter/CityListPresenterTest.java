package com.backbase.mobiletest.ui.citymap.presenter;

import android.content.Context;

import com.backbase.mobiletest.data.DataManager;
import com.backbase.mobiletest.ui.citymap.contract.CityList;
import com.backbase.mobiletest.ui.citymap.model.CityListModel;
import com.backbase.mobiletest.ui.citymap.model.city.Coordinates;
import com.backbase.mobiletest.ui.citymap.model.city.Country;
import com.backbase.mobiletest.ui.citymap.model.city.CountryList;
import com.backbase.mobiletest.utils.BaseResponseModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static com.backbase.mobiletest.ui.citymap.model.CityListModel.CITIES_FILENAME;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CityListPresenterTest {

    @Mock
    private Context context;
    @Mock
    private CityList.View view;
    @Mock
    DataManager dataManager;

    private CityList.Model model;

    private CityListPresenter presenter;

    @Before
    public void setUp() {
        model = new CityListModel(dataManager);
        presenter = new CityListPresenter(context, view, model);
    }

    @Test
    public void shouldInitializeCityPresenterWithViewAndModel() {
        assertNotNull(presenter);
    }

    @Test
    public void shouldGetResponseFromModel_When_initCalled() {
        stubDataManager();

        presenter.init();

        Mockito.verify(dataManager).getAssetContent(CITIES_FILENAME, CountryList.class);
    }

    private void stubDataManager() {
        CountryList value = new CountryList();
        ArrayList<Country> list = new ArrayList<>();

        Country country = new Country();
        country.setCountry("Hurzuf");
        country.setName("UA");
        country.setCoord(new Coordinates(1.000, 2.00));
        list.add(country);

        Country country2 = new Country();
        country2.setCountry("Holubynka");
        country2.setName("SE");
        country2.setCoord(new Coordinates(5.000, 6.00));
        list.add(country2);

        value.setCountryList(list);
        when(dataManager.getAssetContent(any(String.class), (Class<? extends BaseResponseModel>) any())).thenReturn(value);
    }
}