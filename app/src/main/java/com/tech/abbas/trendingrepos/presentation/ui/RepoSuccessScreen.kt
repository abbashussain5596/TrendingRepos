package com.tech.abbas.trendingrepos.presentation.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.tech.abbas.trendingrepos.domain.entity.GithubRepo
import com.tech.abbas.trendingrepos.presentation.ui.RepoSuccessScreen.DIVIDER_LINE
import com.tech.abbas.trendingrepos.presentation.ui.RepoSuccessScreen.USER_IMAGE
import com.tech.abbas.trendingrepos.presentation.ui.RepoSuccessScreen.USER_NAME
import com.tech.abbas.trendingrepos.presentation.ui.RepoSuccessScreen.USER_REPO

@Composable
fun RepoSuccessScreen(modifier: Modifier, data: List<GithubRepo>) {
    LazyColumn(modifier = modifier) {
        items(data) { repo ->
            RepoCollapsedView(repo)
        }
    }
}

@Composable
fun RepoCollapsedView(repo: GithubRepo) {
    Column {

        Row(Modifier.padding(18.dp, 10.dp)) {

            AsyncImage(
                model = repo.avatarUrl,
                contentDescription = "avatar",
                modifier = Modifier
                    .padding(end = 10.dp)
                    .testTag(USER_IMAGE)
                    .size(54.dp)
                    .clip(CircleShape)
                    .border(1.dp, Color.LightGray, CircleShape)
            )

            Column() {
                Text(
                    text = repo.name,
                    fontSize = 14.sp,
                    modifier = Modifier.testTag(USER_NAME)
                )
                Text(
                    text = repo.repoName,
                    fontSize = 16.sp,
                    modifier = Modifier.testTag(USER_REPO)
                )

            }

        }
        Divider(
            color = Color.LightGray,
            thickness = 1.dp,
            modifier = Modifier.testTag(DIVIDER_LINE)
                .padding(start = 15.dp)
        )

    }

}

object RepoSuccessScreen {
    const val USER_IMAGE = "userImage"
    const val USER_NAME = "userName"
    const val USER_REPO = "userRepo"
    const val DIVIDER_LINE = "divider"

}