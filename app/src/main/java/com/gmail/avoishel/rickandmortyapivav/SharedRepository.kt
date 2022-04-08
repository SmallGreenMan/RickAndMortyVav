package com.gmail.avoishel.rickandmortyapivav

import com.gmail.avoishel.rickandmortyapivav.DataClasses.GetCharacterByIdResponse

class SharedRepository {

    suspend fun getCharacterById(characterId: Int): GetCharacterByIdResponse? {
        val request = NetworkLayer.apiClient.getCharacterById(characterId)

        if (request.isSuccessful){
            return request.body()!!
        }

        return null
    }
}