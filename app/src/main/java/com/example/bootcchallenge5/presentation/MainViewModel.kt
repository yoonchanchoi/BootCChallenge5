package com.example.bootcchallenge5.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bootcchallenge5.data.repository.DefaultSearchRepository
import com.example.bootcchallenge5.presentation.search.model.ImageDocumentEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.jvm.internal.Intrinsics.Kotlin

@HiltViewModel
class MainViewModel @Inject constructor(
    private val defaultSearchRepository: DefaultSearchRepository
): ViewModel(){

    private val _imageDocumentEntities = MutableLiveData<List<ImageDocumentEntity>>()
    val imageDocumentEntities: LiveData<List<ImageDocumentEntity>>
        get() = _imageDocumentEntities


    fun requestImages(){
        viewModelScope.launch {
            val imageDocumentList  = defaultSearchRepository.requestSearch("Kotlin").documents
            withContext(Dispatchers.Main){
//                _imageDocumentEntities.value = imageDocumentList
                imageDocumentList.let {
                    _imageDocumentEntities.value = it
                }
            }
        }
    }
}