package com.backbase.mobiletest.data.asset;

import com.backbase.mobiletest.ui.citymap.model.city.Country;
import com.backbase.mobiletest.utils.BaseResponseModel;

import java.util.ArrayList;
import java.util.List;


public interface AssetHelper {
    ArrayList<Country> getAssetContent(String filename);
}
