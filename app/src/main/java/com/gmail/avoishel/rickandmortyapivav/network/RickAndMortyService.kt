package com.gmail.avoishel.rickandmortyapivav.network

import com.gmail.avoishel.rickandmortyapivav.network.response.GetCharacterByIdResponse
import com.gmail.avoishel.rickandmortyapivav.network.response.GetCharactersPageResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyService {

    @GET("character/{character-id}")
    suspend fun getCharacterById(
        @Path("character-id") characterId: Int
    ): Response<GetCharacterByIdResponse>

    @GET("character")
    suspend fun getCharactersPage(
        @Query("page") pageIndex: Int
    ): Response<GetCharactersPageResponse>
}