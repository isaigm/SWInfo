package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SWInfoAPI {
    @GET("planets")
    Call<Result<Planet>> getPlanets();
    @GET("vehicles")
    Call<Result<Vehicle>> getVehicles();
    @GET("people")
    Call<Result<People>> getPeople();
}
