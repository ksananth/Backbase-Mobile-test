package com.backbase.mobiletest.data.asset;

import com.backbase.mobiletest.utils.BaseResponseModel;


public interface AssetHelper {
    String getAssetContent(String filename);
    BaseResponseModel parseJson(Class<? extends BaseResponseModel> responseModel, String json);
}
