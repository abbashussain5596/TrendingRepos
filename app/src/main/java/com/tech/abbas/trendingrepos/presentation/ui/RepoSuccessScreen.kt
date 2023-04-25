package com.tech.abbas.trendingrepos.presentation.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tech.abbas.trendingrepos.domain.entity.GithubRepo

@Composable
fun RepoSuccessScreen(modifier: Modifier,data : List<GithubRepo>) {
    LazyColumn(modifier = modifier){
        items(data) { repo ->
            Text(text = repo.name)
        }
    }
}