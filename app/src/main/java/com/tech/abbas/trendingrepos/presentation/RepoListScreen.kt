package com.tech.abbas.trendingrepos

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tech.abbas.trendingrepos.RepoListScreen.MENU_ICON
import com.tech.abbas.trendingrepos.RepoListScreen.TOOLBAR_TAG
import com.tech.abbas.trendingrepos.presentation.viewModel.RepoListViewModel

@Composable
fun RepoListScreen(
    viewModel: RepoListViewModel = hiltViewModel()
) {
    TopAppBar(
        backgroundColor = Color.White,
        modifier = Modifier.testTag(TOOLBAR_TAG)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = stringResource(id = R.string.toolbar_text),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Spacer(Modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.more_vert_black_24dp),
                contentDescription = "menu",
                Modifier.testTag(MENU_ICON)
            )
        }
    }
}

object RepoListScreen {
    const val TOOLBAR_TAG = "toolbar"
    const val MENU_ICON = "menuIcon"

}