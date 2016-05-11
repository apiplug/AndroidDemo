package com.apiplug.androiddemo.rest;


import com.apiplug.androiddemo.models.ActorResults;
import com.apiplug.androiddemo.models.CountryResults;
import com.apiplug.androiddemo.models.FilmResults;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * APIPlug Endpoint Definitions
 *
 * @author APIPlug
 * @version v1.0
 *
 */
public interface APIPlug {

    /*
    These methods defines our API endpoints.
    All REST methods such as GET,POST,UPDATE,DELETE can be stated in here.
    */
    @GET("actor")
    Call<ActorResults> getActors();

    @GET("country")
    Call<CountryResults> getCountries();

    @GET("film")
    Call<FilmResults> getFilms();


}