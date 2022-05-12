package com.gmail.avoishel.rickandmortyapivav

import com.gmail.avoishel.rickandmortyapivav.network.response.GetCharacterByIdResponse
import com.gmail.avoishel.rickandmortyapivav.network.NetworkLayer

class SharedRepository {

    suspend fun getCharacterById(characterId: Int): GetCharacterByIdResponse? {
        val request = NetworkLayer.apiClient.getCharacterById(characterId)

        if (request.failed){
            return null
        }

        if (!request.isSuccessful){
            return null
        }

        return request.body
    }
}