package com.gmail.avoishel.rickandmortyapivav.characters

import com.gmail.avoishel.rickandmortyapivav.network.response.GetCharacterByIdResponse

class CharactersRepository {

    suspend fun getCharacterList(pageIndex: Int): List<GetCharacterByIdResponse> {
        return emptyList()
    }
}