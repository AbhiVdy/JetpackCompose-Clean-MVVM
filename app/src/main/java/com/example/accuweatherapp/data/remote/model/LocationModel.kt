package com.example.accuweatherapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class LocationModel(
    val ID: String,
    @SerializedName("CountryID")
    val countryID: String,
    @SerializedName("EnglishName")
    val englishName: String,
    @SerializedName("EnglishType")
    val englishType: String,
    @SerializedName("Level")
    val level: Int,
    @SerializedName("LocalizedName")
    val localizedName: String,
    @SerializedName("LocalizedType")
    val localizedType: String?
)