package com.example.accuweatherapp.di

import com.example.accuweatherapp.common.Constants
import com.example.accuweatherapp.data.remote.WeatherApi
import com.example.accuweatherapp.data.repository.WeatherRepositoryImpl
import com.example.accuweatherapp.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun getAccuweatherApi(): WeatherApi {
        return Retrofit.Builder()
            .baseUrl(Constants.API_ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }

    @Provides
    @Singleton
    fun getLocations(api: WeatherApi): WeatherRepository {
        return WeatherRepositoryImpl(api)
    }
}