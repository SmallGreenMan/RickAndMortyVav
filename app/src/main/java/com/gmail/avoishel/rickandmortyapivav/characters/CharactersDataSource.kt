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
            val page = repository.getCharactersPage(params.key)

            if (page == null){
                callback.onResult(emptyList(), null)
                return@launch
            }

            callback.onResult(page.result, getPageIndexFromNext(page.info.next!!))
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
            val page = repository.getCharactersPage(1)

            if (page == null){
                callback.onResult(emptyList(), null, null)
                return@launch
            }

            callback.onResult(page.result, null, getPageIndexFromNext(page.info.next!!))
        }
    }

    private fun getPageIndexFromNext(next: String): Int? {
        return next?.split("?page=")?.get(1).toInt()
    }

}