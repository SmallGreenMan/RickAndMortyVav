package com.gmail.avoishel.rickandmortyapivav.network.response

class GetCharactersPageResponse(
    val info: Info = Info(),
    val result: List<GetCharacterByIdResponse> = emptyList()
) {
    data class Info(
        val count: Int = 0,
        val pages: Int = 0,
        val next: String? = null,
        val prev: String? = null
    ){
    }
}