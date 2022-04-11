package ru.skillbranch.data.network.repository

import domain.repository.DataApi
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import ru.skillbranch.data.network.service.retrofitApi.retrofitService
import ru.skillbranch.phone_shop.entietis.JsonData

class DataImpl: DataApi {
   private var data: JsonData? = null


    override suspend fun <JsonData> getData():JsonData {
        coroutineScope{
            launch {

            try {
                data = retrofitService.getPhotos()
            } catch (e: Exception) { }
            }
        }
        return data as JsonData
    }


}