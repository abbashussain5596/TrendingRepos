package com.tech.abbas.trendingrepos.presentation.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.tech.abbas.trendingrepos.domain.entity.GithubRepo
import com.tech.abbas.trendingrepos.domain.usecase.IRepoUseCase
import com.tech.abbas.trendingrepos.domain.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class RepoListViewModel @Inject constructor(
    application: Application,
    private val repoUseCase: IRepoUseCase
) : AndroidViewModel(application) {

    var _uiState = MutableStateFlow<ReposUIState>(
        ReposUIState.Idle
    )
    val uiState: StateFlow<ReposUIState> get() = _uiState

    private val _expandedCardIdsList = MutableStateFlow(listOf<Int>())
    val expandedCardIdsList: StateFlow<List<Int>> get() = _expandedCardIdsList


    fun onRepoItemClicked(cardId: Int) {
        _expandedCardIdsList.value = _expandedCardIdsList.value.toMutableList().also { list ->
            if (!list.contains(cardId)) {
                list.clear()
                list.add(cardId)
            }
        }
    }

    fun getRepoList() {
        viewModelScope.launch {
            repoUseCase.getRepoList().map { repoResult ->
                when (repoResult) {
                    is Result.Success -> {
                        _uiState.value = ReposUIState.Success(repoResult.data)
                    }
                    is Result.Loading -> {
                        _uiState.value = ReposUIState.Loading
                    }
                    else -> {}
                }

            }

        }

    }

}

sealed class ReposUIState {
    object Idle : ReposUIState()
    data class Success(val data: List<GithubRepo>) : ReposUIState()
    object Error : ReposUIState()
    object Loading : ReposUIState()
}