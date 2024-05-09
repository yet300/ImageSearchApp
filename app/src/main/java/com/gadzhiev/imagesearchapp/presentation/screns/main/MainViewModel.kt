package com.gadzhiev.imagesearchapp.presentation.screns.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.gadzhiev.imagesearchapp.domain.usecase.GetImagesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject
import kotlin.time.Duration.Companion.milliseconds

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getImagesUseCase: GetImagesUseCase,
) : ViewModel() {

    private val _search = MutableStateFlow("")
    val search = _search.asStateFlow()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = "",
        )

    fun setSearch(query: String) {
        _search.value = query
    }

    /*
    the state is recreated when the screen is rotated
     */
    val imagesSearchResults = search.debounce(300.milliseconds).flatMapLatest { query ->
        getImagesUseCase.invoke(query.ifEmpty { "Очень Интересно IT " })
            .cachedIn(viewModelScope)
    }

}