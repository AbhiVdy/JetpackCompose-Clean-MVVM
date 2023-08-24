package com.example.accuweatherapp.data.repository

import android.util.Log
import com.example.accuweatherapp.common.Constants
import com.example.accuweatherapp.data.remote.WeatherApi
import com.example.accuweatherapp.data.remote.model.LocationModel
import com.example.accuweatherapp.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {

    override suspend fun getLocations(): List<LocationModel> {
        return api.getLocations(Constants.API_KEY)
    }
}