package com.tech.abbas.trendingrepos.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.valentinilk.shimmer.shimmer

@Composable 
fun LoadingScreen(modifier: Modifier) {
    Box(modifier = modifier.shimmer())
}
