package com.backbase.mobiletest.data.asset;

import com.backbase.mobiletest.utils.BaseResponseModel;


public interface AssetHelper {
    BaseResponseModel getAssetContent(String filename, Class<? extends BaseResponseModel> responseModel);
}
