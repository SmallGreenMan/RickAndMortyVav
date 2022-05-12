package com.gmail.avoishel.rickandmortyapivav

import com.gmail.avoishel.rickandmortyapivav.DataClasses.GetCharacterByIdResponse
import retrofit2.Response

class ApiClient(
    private val rickAndMortyService: RickAndMortyService
) {
    suspend fun getCharacterById(characterId: Int): SimpleResponse<GetCharacterByIdResponse> {
        //return rickAndMortyService.getCharacterById(characterId)
        return safeApiCall { rickAndMortyService.getCharacterById(characterId) }
    }

    private inline fun <T> safeApiCall(apiCall: () -> Response<T>): SimpleResponse<T> {
        return try {
            SimpleResponse.success(apiCall.invoke())
        } catch (e: Exception) {
            SimpleResponse.failure(e)
        }
    }
}