package com.tech.abbas.trendingrepos

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tech.abbas.trendingrepos.RepoListScreen.TOOLBAR_TAG

@Composable
fun RepoListScreen(
) {
    TopAppBar(
        modifier = Modifier.testTag(TOOLBAR_TAG),
        title = { Text(text = stringResource(id = R.string.toolbar_text),color = Color.Black) },
        backgroundColor = Color.White
    )
}
object RepoListScreen{
    const val TOOLBAR_TAG = "toolbar"
}