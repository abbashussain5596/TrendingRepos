package com.tech.abbas.trendingrepos

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun RepoListScreen(
    navController: NavController
) {
    Text(
        text = stringResource(id = R.string.app_name),
        textAlign = TextAlign.Left,
        modifier = Modifier.padding(16.dp, 14.dp, 0.dp, 0.dp),
        fontSize = 24.sp,
    )
}