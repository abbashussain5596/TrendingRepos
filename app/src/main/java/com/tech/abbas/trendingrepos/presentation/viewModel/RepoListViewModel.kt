package com.tech.abbas.trendingrepos.presentation.viewModel

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import com.tech.abbas.trendingrepos.domain.entity.GithubRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class RepoListViewModel @Inject constructor(
    application: Application
) : AndroidViewModel(application) {

    var uiState = mutableStateOf<ReposUIState>(
        ReposUIState.Idle
    )
}

sealed class ReposUIState {
    object Idle : ReposUIState()
    data class Success(val data: GithubRepo) : ReposUIState()
    object Error : ReposUIState()
    object Loading : ReposUIState()
}