package com.example.accuweatherapp.presentation.weather_report

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.accuweatherapp.common.Resources
import com.example.accuweatherapp.domain.use_case.GetLocationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(private val locationUseCase: GetLocationUseCase) :
    ViewModel() {

    private val _locationState = mutableStateOf(LocationListState())
    val locationState: State<LocationListState> = _locationState

    init {
        getLocations()
    }

    private fun getLocations() {

        locationUseCase().onEach { result ->
            when (result) {
                is Resources.Loading -> {
                    _locationState.value = LocationListState(isLoading = true)
                }

                is Resources.Success -> {
                    _locationState.value =
                        LocationListState(locationList = result.data ?: emptyList())
                }

                is Resources.Error -> {
                    _locationState.value =
                        LocationListState(error = result.msg ?: "Some error occured")
                }
            }
        }.launchIn(viewModelScope)
    }

}