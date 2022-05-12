package com.gmail.avoishel.rickandmortyapivav.characters

import androidx.paging.PageKeyedDataSource
import com.gmail.avoishel.rickandmortyapivav.SharedRepository
import com.gmail.avoishel.rickandmortyapivav.SharedViewModel
import com.gmail.avoishel.rickandmortyapivav.network.response.GetCharacterByIdResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.security.PrivateKey
import kotlin.coroutines.CoroutineContext

class CharactersDataSource (
    //private val viewModel: SharedViewModel,
    private val coroutineScope: CoroutineScope,
    private val repository: CharactersRepository
): PageKeyedDataSource <Int, GetCharacterByIdResponse>() {
    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, GetCharacterByIdResponse>
    ) {
        coroutineScope.launch {
            val characterList = repository.getCharacterList(params.key)
            callback.onResult(characterList, params.key + 1)
        }
    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, GetCharacterByIdResponse>
    ) {
        TODO("Not yet implemented")
    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, GetCharacterByIdResponse>
    ) {
        coroutineScope.launch {
            val characterList = repository.getCharacterList(1)
            callback.onResult(characterList, null, 2)
        }
    }


}