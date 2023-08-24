package com.example.accuweatherapp.data.remote

import com.example.accuweatherapp.data.remote.model.LocationModel
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("/locations/v1/adminareas/IN")
    suspend fun getLocations(@Query(value = "apikey") apiKey: String): List<LocationModel>

    @GET("/forecasts/v1/daily/1day/1")
    suspend fun getForcastByLocationId(locationId: String)

}