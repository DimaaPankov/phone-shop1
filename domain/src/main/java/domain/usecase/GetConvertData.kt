package domain.usecase

import domain.repository.DataApi

class GetConvertData<T>(val repository: DataApi) {

    suspend fun execute() = repository.getData<T>()



}