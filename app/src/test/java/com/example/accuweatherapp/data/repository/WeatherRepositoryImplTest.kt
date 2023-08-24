package com.example.accuweatherapp.data.repository

import com.example.accuweatherapp.common.Constants
import com.example.accuweatherapp.data.remote.WeatherApi
import com.example.accuweatherapp.data.remote.model.LocationModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class WeatherRepositoryImplTest {

    private lateinit var repoImpl: WeatherRepositoryImpl

    @Mock
    lateinit var api: WeatherApi

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        repoImpl = WeatherRepositoryImpl(api)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getLocationsEmptyList() =
        runTest {
            Mockito.`when`(api.getLocations(Constants.API_KEY)).thenReturn(emptyList())
            val result = repoImpl.getLocations()
            assertEquals(0, result.size)
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getLocationsById() =
        runTest {
            Mockito.`when`(api.getLocations(Constants.API_KEY)).thenReturn(
                listOf(
                    LocationModel(
                        ID = "AS",
                        countryID = "IN",
                        englishName = "Assam",
                        englishType = "State",
                        level = 1,
                        localizedName = "Assam",
                        localizedType = "State"
                    )
                )
            )

            val result = repoImpl.getLocations().filter { it.ID == "AS" }
            assertEquals("Assam", result.first().englishName)
        }

}