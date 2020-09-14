package com.example.cloneyoutube.repository

import com.example.cloneyoutube.data.network.response.CovidResponse
import com.example.cloneyoutube.utils.UseCaseResult

interface IInitialRepo {
   suspend fun getCovidData(): UseCaseResult<CovidResponse>

}