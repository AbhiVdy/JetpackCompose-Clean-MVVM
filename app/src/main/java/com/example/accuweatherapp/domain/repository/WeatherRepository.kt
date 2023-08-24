package com.example.accuweatherapp.domain.repository

import com.example.accuweatherapp.data.remote.model.LocationModel

interface WeatherRepository {

    suspend fun getLocations(): List<LocationModel>
}