package com.tech.abbas.trendingrepos.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
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
import com.tech.abbas.trendingrepos.presentation.mock.GithubReposProvider
import com.tech.abbas.trendingrepos.presentation.ui.LoadingScreen.DESC_BOX
import com.tech.abbas.trendingrepos.presentation.ui.LoadingScreen.DIVIDER_LINE
import com.tech.abbas.trendingrepos.presentation.ui.LoadingScreen.IMAGE_BOX
import com.tech.abbas.trendingrepos.presentation.ui.LoadingScreen.LOADING_SHIMMER
import com.tech.abbas.trendingrepos.presentation.ui.LoadingScreen.NAME_BOX
import com.valentinilk.shimmer.shimmer

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    repeat(9) {
        Box(modifier = modifier.shimmer()) {
            Column(
                Modifier
                    .testTag(LOADING_SHIMMER)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(54.dp)
                            .clip(CircleShape)
                            .testTag(IMAGE_BOX)
                            .background(Color.LightGray)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.4f)
                                .height(10.dp)
                                .testTag(NAME_BOX)
                                .background(Color.LightGray)

                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(10.dp)
                                .testTag(DESC_BOX)
                                .background(Color.LightGray)
                        )
                    }
                }
                Divider(
                    color = Color.LightGray,
                    thickness = 1.dp,
                    modifier = Modifier
                        .testTag(DIVIDER_LINE)
                        .padding(start = 15.dp)
                )

            }
        }
    }
}


object LoadingScreen {
    const val LOADING_SHIMMER = "shimmer"
    const val IMAGE_BOX = "imageBox"
    const val NAME_BOX = "nameBox"
    const val DESC_BOX = "descBox"
    const val DIVIDER_LINE = "dividerLine"
}