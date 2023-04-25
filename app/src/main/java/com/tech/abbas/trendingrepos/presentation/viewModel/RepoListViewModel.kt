package com.tech.abbas.trendingrepos.presentation.viewModel

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import com.tech.abbas.trendingrepos.domain.entity.GithubRepo
import com.tech.abbas.trendingrepos.presentation.mock.GithubReposProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class RepoListViewModel @Inject constructor(
    application: Application
) : AndroidViewModel(application) {

    var uiState = mutableStateOf<ReposUIState>(
        ReposUIState.Success(GithubReposProvider.getGithubRepoList())
    )

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

}

sealed class ReposUIState {
    object Idle : ReposUIState()
    data class Success(val data: List<GithubRepo>) : ReposUIState()
    object Error : ReposUIState()
    object Loading : ReposUIState()
}