package com.nehaimgurdemoapp.services;

import com.nehaimgurdemoapp.model.response.ImageListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ImagesNetworkService {

    /************************** Get Popular Image List of the week **************************************/
    @GET("gallery/{section}/{sort}/{window}/{page}")
    Call<ImageListResponse> getPopularImageList(@Path("section") String section, @Path("sort") String sort, @Path("window") String window, @Path("page") String page, @Query("showViral") Boolean showViral, @Query("mature") Boolean showMature, @Query("album_previews") Boolean albumPreviews);


    /************************** Get top Image List of the week **************************************/
    @GET("gallery/search/{sort}/{window}")
    Call<ImageListResponse> getSearchedImageList(@Path("sort") String sort, @Path("window") String window, @Query("q") String searchText);


}
