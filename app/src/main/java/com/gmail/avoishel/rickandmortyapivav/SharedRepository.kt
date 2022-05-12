package com.gmail.avoishel.rickandmortyapivav

import com.gmail.avoishel.rickandmortyapivav.network.response.GetCharacterByIdResponse
import com.gmail.avoishel.rickandmortyapivav.network.NetworkLayer
import com.gmail.avoishel.rickandmortyapivav.network.response.GetCharactersPageResponse

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

//    suspend fun getCharacterPage(pageIndex: Int): GetCharactersPageResponse? {
//        val request = NetworkLayer.apiClient.getCharactersPage(pageIndex)
//
//        if (request.failed){
//            return null
//        }
//
//        if (!request.isSuccessful){
//            return null
//        }
//
//        return request.body
//    }
}