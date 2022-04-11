package domain.repository


interface DataApi {



    suspend fun<T> getData(): T

}