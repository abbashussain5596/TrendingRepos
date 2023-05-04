package com.tech.abbas.trendingrepos.presentation.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.*
import com.tech.abbas.trendingrepos.R
import com.tech.abbas.trendingrepos.presentation.ui.ErrorScreen.ERROR_ANIM
import com.tech.abbas.trendingrepos.presentation.ui.ErrorScreen.ERROR_DESC
import com.tech.abbas.trendingrepos.presentation.ui.ErrorScreen.ERROR_TEXT
import com.tech.abbas.trendingrepos.presentation.ui.ErrorScreen.RETRY_BUTTON


@Composable
fun ErrorScreen(
    modifier: Modifier,
    onRetryButtonClick: () -> Unit
) {

    val errorComposition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.error)
    )

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        LottieAnimation(
            composition = errorComposition,
            modifier = Modifier
                .testTag(ERROR_ANIM)
                .size(350.dp)
        )
        Text(
            modifier = Modifier
                .testTag(ERROR_TEXT)
                .padding(top = 30.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            text = stringResource(id = R.string.error_text)
        )
        Text(
            modifier = Modifier
                .testTag(ERROR_DESC)
                .padding(top = 20.dp),
            color = Color.LightGray,
            text = stringResource(id = R.string.error_desc)
        )
        Spacer(modifier = Modifier.height(60.dp))
        RetryButton(onRetryButtonClick)
    }
}

@Composable
fun RetryButton(
    onRetryButtonClick: () -> Unit
) {
    Button(
        onClick = {
            onRetryButtonClick()
        },
        modifier = Modifier
            .testTag(RETRY_BUTTON)
            .padding(25.dp)
            .fillMaxWidth(),
        border = BorderStroke(1.dp, Color.Green),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Green)
    ) {
        Text(text = stringResource(id = R.string.retry), color = Color.Green)
    }
}

object ErrorScreen {
    const val ERROR_ANIM = "errorAnim"
    const val ERROR_TEXT = "errorText"
    const val ERROR_DESC = "errorDesc"
    const val RETRY_BUTTON = "retryButton"
}