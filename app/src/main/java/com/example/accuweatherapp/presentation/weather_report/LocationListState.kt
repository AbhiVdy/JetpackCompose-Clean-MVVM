package com.example.accuweatherapp.presentation.weather_report

import com.example.accuweatherapp.data.remote.model.LocationModel

data class LocationListState(
    val isLoading: Boolean = false,
    val locationList: List<LocationModel> = emptyList(),
    val error: String = ""
)
