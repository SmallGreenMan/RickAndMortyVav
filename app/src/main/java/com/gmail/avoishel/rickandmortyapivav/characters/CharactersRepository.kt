package com.gmail.avoishel.rickandmortyapivav.characters

import com.gmail.avoishel.rickandmortyapivav.network.NetworkLayer
import com.gmail.avoishel.rickandmortyapivav.network.response.GetCharacterByIdResponse
import com.gmail.avoishel.rickandmortyapivav.network.response.GetCharactersPageResponse

class CharactersRepository {

    suspend fun getCharactersPage(pageIndex: Int): GetCharactersPageResponse? {
        val request = NetworkLayer.apiClient.getCharactersPage(pageIndex)

        if (request.failed || !request.isSuccessful){
            return null
        }

        return request.body!!
    }
}