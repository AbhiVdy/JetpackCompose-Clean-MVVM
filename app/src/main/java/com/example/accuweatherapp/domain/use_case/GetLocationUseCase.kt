package com.example.accuweatherapp.domain.use_case

import com.example.accuweatherapp.common.Resources
import com.example.accuweatherapp.data.remote.model.LocationModel
import com.example.accuweatherapp.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetLocationUseCase @Inject constructor(private val repository: WeatherRepository) {

    operator fun invoke(): Flow<Resources<List<LocationModel>>> = flow {
        try {
            emit(Resources.Loading<List<LocationModel>>())
            val locations = repository.getLocations()
            emit(Resources.Success<List<LocationModel>>(locations))
        } catch (ex: HttpException) {
            emit(
                Resources.Error<List<LocationModel>>(
                    null,
                    ex.localizedMessage ?: "An HTTP exception occured"
                )
            )
        } catch (ex: IOException) {
            emit(
                Resources.Error<List<LocationModel>>(
                    null,
                    ex.localizedMessage ?: "An exception occured"
                )
            )
        }
    }
}