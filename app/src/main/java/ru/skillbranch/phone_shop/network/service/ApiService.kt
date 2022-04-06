package ru.skillbranch.phone_shop.network.service


import retrofit2.http.GET
import ru.skillbranch.phone_shop.network.JsonData


//Это интерфейс в котором мы прописали функцию, getPhotos которая будет использоваться
// для отправки более точного запроса на сервер
interface ApiService {
    /**
     * Returns a [List] of [MarsPhoto] and this method can be called from a Coroutine.
     * The @GET annotation indicates that the "photos" endpoint will be requested with the GET
     * HTTP method
     */
    @GET("v3/654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getPhotos(): JsonData
}