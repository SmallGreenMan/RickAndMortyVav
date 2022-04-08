package com.gmail.avoishel.rickandmortyapivav

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import com.gmail.avoishel.rickandmortyapivav.DataClasses.GetCharacterByIdResponse

class SharedViewModel: ViewModel() {

    private val repository = SharedRepository()

    private val _characterBiIdLiveData = MutableLiveData<GetCharacterByIdResponse>()
    val characterBiIdLiveData: LiveData<GetCharacterByIdResponse> = _characterBiIdLiveData

    fun refreshCharacter(characterId: Int){
        viewModelScope.launch {
            
        }
    }
}